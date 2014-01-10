package com.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nutsaboutcandy.entities.StorePackage;
import com.nutsaboutcandy.entities.ingredients.Ingredient;

/**
 * Servlet implementation class DisplayPackage
 */
public class DisplayPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPackage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		InputStream input = getServletContext().getResourceAsStream("nac_dbase.log");
		ObjectInputStream objectInput = new ObjectInputStream(input);
		
		if(session.getAttribute("admin")!=null) {
		
		try {
			
			out.println("<table width='1000px' border='1'>");
			out.println("<tr>");
			out.println("<th width='150px'>Product Name</th>");
			out.println("<th width='250px'>Ingredients</th>");
			out.println("<th width='100px'>Size</th>");
			out.println("<th width='100px'>Weigh in Grams</th>");
			out.println("<th width='100px'>No. of Stocks</th>");
			out.println("<th width='100px'>Options</th>");
			out.println("</tr>");
			
			@SuppressWarnings("unchecked")
			ArrayList<StorePackage> nac_database = (ArrayList<StorePackage>) objectInput.readObject();
			for(StorePackage pack : nac_database){
				out.println("<tr>");
						out.println("<td>" + pack.getProduct().getName() + "</td>");
						out.println("<td>");
						for(Ingredient ingredient : pack.getProduct().getListOfIngredients()) {	
					    out.println(ingredient.getName() + ",");
						}
						out.println("</td>");
						out.println("<td>" + pack.getSize() + "</td>");
						out.println("<td>" + pack.getWeighInGrams() + "</td>");
						out.println("<td>" + pack.getNumberOfStock() + "</td>");
						out.println("<td><table>");
						out.println("<form action='UpdateItem' method='post'>");
						out.println("<input type='submit' value='UPDATE'><br>");
						out.println("</form>");
						out.println("<form action='RemoveItem' method='post'>");
						out.println("<input type='submit' value='REMOVE'><br>");
						out.println("</form>");
						out.println("</table></td>");
						out.println("</tr>");
			}
			out.println("</table>");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		out.flush();
		objectInput.close();
		} else {
			response.sendRedirect("Login");
		}
		out.println("<form action='Home' method='get'>");
		out.println("<input type='submit' value='Back to Home'><br>");
		out.println("</form>");
		out.println("<form action='DisplayPackage' method='get'>");
		out.println("<input type='submit' value='Back to Top'><br>");
		out.println("</form>");
			
		}
		
		}

