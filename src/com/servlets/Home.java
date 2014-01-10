package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("admin")!=null) {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>Welcome Admin!</h1>");
		out.print("<form action='Logout' align='right' method='get'>");
		out.print("<input width='100px' type='submit' value='Logout'><br>");
		out.print("</form>");
		out.print("<form action='AddItem' method='post'>");
		out.print("<input width='100%'type='submit' value='Add Item'><br>");
		out.print("</form>");
		out.print("<form action='DisplayPackage' method='get'>");
		out.print("<input width='100%' type='submit' value='Display Packages'/>");
		out.print("</form>");
		
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
