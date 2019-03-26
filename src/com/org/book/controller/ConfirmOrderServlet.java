package com.org.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.org.book.cart.Cart;
import com.org.book.cart.CartItem;
import com.org.book.sslConfig.SslConfig;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles all the Http Get and Post requests to confirm the order for a user after payment details are provided
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ConfirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the purchase order Id
		//int purchaseorderid = (int) request.getSession(false).getAttribute("POID");
		String pid = request.getParameter("Poid");
		int purchaseorderid = Integer.parseInt(pid);
    	
    	//Get the cart Items
//    	Cart cartItems = (Cart) request.getSession(false).getAttribute("items_in_cart");
//    	List<CartItem> cartitems = cartItems.getBookcart();
		
		String cart = request.getParameter("CartArray");
		Gson g = new Gson();
		//CartItem[] ci = g.fromJson(cart, CartItem[].class);
		//List<CartItem> lci = ci.getBookcart();
		
		response.setContentType("application/json;charset=UTF-8");
		 
		response.setHeader("Cache-Control", "no-cache");
		// get the PrintWriter object to write the html page
		PrintWriter out = response.getWriter();
    	
		
		Type collectionType = new TypeToken<List<CartItem>>(){}.getType();
		List<CartItem> cartitems = g.fromJson(cart, collectionType);
    	
    	SslConfig sslconf= new SslConfig();
    	Client client = sslconf.ssl(); 
    	
		String URL= "https://localhost:8443/OnlineBookStore/rest/OrderProcess/confirmOrder";
		WebTarget target = client.target(URL).path("/{POID}").resolveTemplate("POID", purchaseorderid);
		Invocation.Builder ib = target.request(MediaType.TEXT_PLAIN);
		Response res = ib.put(Entity.entity(cartitems, MediaType.APPLICATION_JSON));
		
		boolean confirm = res.readEntity(boolean.class);
		//String action = null;
		JSONObject action = new JSONObject();
		try {
		if(confirm == true) {
			//action = "Order Successfully Placed";
			
				action.put("ConfirmOrder", true);
			
		}
		else
		{
			action.put("ConfirmOrder", false);
			//action = "Credit Card Authorization Denied";
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.getSession(false).setAttribute("order_status", action);
//		response.sendRedirect("confirmation.jsp");
    	out.print(action.toString());
		
	}
			
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConfirmOrder(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConfirmOrder(request, response);
	}

}
