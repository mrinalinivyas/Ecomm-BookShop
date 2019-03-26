package com.org.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.org.book.cart.Cart;
import com.org.book.model.Address;
import com.org.book.model.PurchaseOrder;
import com.org.book.sslConfig.SslConfig;

/**
 * Servlet implementation class OrderProcessServlet
 */
@WebServlet("/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * Method to create the order request for a user and send the response back to JSP pages
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processOrder(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
    	//Get the valid user id from the session
//    	int cid = (int) request.getSession(false).getAttribute("customerid");
//    	String customerid = Integer.toString(cid);
//    	
//    	//Get the items in the cart
//    	Cart cartItems = (Cart) request.getSession(false).getAttribute("items_in_cart");
//    	double cart_total = cartItems.getTotalPrice();
    	
    	response.setContentType("application/json;charset=UTF-8");
		 
		response.setHeader("Cache-Control", "no-cache");
		// get the PrintWriter object to write the html page
		PrintWriter out = response.getWriter();
    	
    	
    	String customerid = request.getParameter("customerid");
    	String cart_total = request.getParameter("cart_total");
    	System.out.println("ID : " + customerid + " cartTOTAl : " + cart_total);
    	
    	
    	SslConfig sslconf= new SslConfig();
    	Client client = sslconf.ssl(); 
    	
		String URL= "https://localhost:8443/OnlineBookStore/rest/OrderProcess";
		WebTarget target = client.target(URL).path("/order").queryParam("customerid", customerid).queryParam("cart_total", cart_total);
		Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
		Response res = ib.get();
		
		PurchaseOrder PO = res.readEntity(PurchaseOrder.class);  
		
		Address addr = PO.getAddr();
		Gson gsonBuilder = new GsonBuilder().create();
		String address = gsonBuilder.toJson(addr);
		
		//HttpSession session = request.getSession(false);
		//session.setAttribute("Address", addr);
		//session.setAttribute("POID", PO.getId());
		
		//response.sendRedirect("order_details.jsp");
		
		JSONObject orderObj = new JSONObject();
		try {
			orderObj.put("Address", address);
			orderObj.put("Poid", PO.getId());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" Order ::: " + orderObj.toString());
		out.print(orderObj.toString());
		
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processOrder(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processOrder(request, response);
	}

}
