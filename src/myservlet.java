

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			out.println("<P ALIGN='center'><TABLE BORDER=1>");
			out.println("<h1>BOOK INFORMATION</h>");
			Class.forName("com.mysql.jdbc.Driver");
			//resolved timezone error with help from https://stackoverflow.com/questions/7605953/how-to-change-mysql-timezone-in-java-connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOKSTORE?useLegacyDatetimeCode=false&serverTimezone=America/Toronto","root","fiberlink@1");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from BOOK ");
			while(rs.next()) 
			{
				out.println("<TR>");
				out.println("<TD>"+rs.getInt("bookid")+"</TD>"+"   "+"<TD>"+rs.getString("title")+"</TD>"+"   "+"<TD>"+rs.getInt("price")+"</TD>"+"   "+"<TD>"+rs.getString("author")+"</TD>"+"   "+"<TD>"+rs.getString("category")+"</TD>");  
			    out.println("</TR>");
			}
			out.println("</TABLE></P>");
			conn.close();  
		}
		catch(Exception e)
		{
			System.out.println("driver not found");
			e.printStackTrace();
		}
	}
	}


