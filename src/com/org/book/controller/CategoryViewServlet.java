 package com.org.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.org.book.model.Book;
import com.org.book.sslConfig.SslConfig;


@WebServlet("/categoryviewservlet")
public class CategoryViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Processes the HTTP Get and Post Requests to get all the books available for a particular Category
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void userController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("Category");
		
		SslConfig sslconf= new SslConfig();
    	Client client = sslconf.ssl();
    	
		WebTarget target = client.target("https://localhost:8443/OnlineBookStore/rest/ProductCatalog/getCategoryBooks")
				.path("/{category}").resolveTemplate("category", category);

		try {
			
			response.setContentType("application/json;charset=UTF-8");
			 
			response.setHeader("Cache-Control", "no-cache");
			// get the PrintWriter object to write the html page
			PrintWriter out = response.getWriter();
			Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
			Response res = ib.get();
			
			Gson gsonBuilder = new GsonBuilder().create();
			
			// Reference from
			// "https://stackoverflow.com/questions/21918081/jersey-2-6-with-jackson-json-deserialization"
			// JSON deserialization
			List<Book> book = res.readEntity(new GenericType<List<Book>>() {
			});
			
			System.out.println("Before converting to json");
			System.out.println(book);
			
			String jsonData = gsonBuilder.toJson(book);
			
			System.out.println(jsonData);
			//String tempStr = "BookListJsonDataParse(" + jsonData.toString() + ")";
			//String tempStr = "menuListJsonDataParse(" + jsonData.toString() + ")";
			out.print(jsonData);
			

			//request.setAttribute("book", book);
			//request.getRequestDispatcher("products.jsp").forward(request, response);

		    } 
		catch (Exception e) {
			e.printStackTrace();
		    }

		}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userController(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userController(request, response);
	}
}