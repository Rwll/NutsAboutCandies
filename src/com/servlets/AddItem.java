package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItem
 */
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>ADD ITEM</h1>");
		out.print("<p>Choose Category : ");
		out.print("<select>");
		out.print("<option name='NutsCategory' value='Nuts'>Nuts</option>");
		out.print("<option name='CandyCategory' value='Candies'>Candies</option>");
		out.print("<option name='NutsCandyCategory' value='Mixed'>Mixed(Nuts and Candies)</option>");
		out.print("</select></p>");
		out.print("<p>Enter Product Name : <input type='text' name='productName'/><br><br></p>");
		out.print("<p>Enter Ingredients : <input type='text' name='ingredients'/><br><br> </p>");
		out.print("<p>Choose Product Type : ");
		out.print("<select>");
		out.print("<option name='regular' value='Regular'>Regular</option>");
		out.print("<option name='premium' value='Premium'>Premium</option>");
		out.print("</select></p>");
		out.print("<p>Enter Number of Stocks for Small :  <input type='text' name='numberOfStockSmall'/><br></p>");
		out.print("<p>Enter Number of Stocks for Medium :  <input type='text' name='numberOfStockMedium'/><br></p>");
		out.print("<p>Enter Number of Stocks for Large :  <input type='text' name='numberOfStockLarge'/><br></p>");
		out.print("<form action='AddItemSuccessful' method='post'>");
		out.print("<input type='submit' value='Add to Database'><br>");
		out.print("</form>");
		out.print("<form action='Home' method='get'>");
		out.print("<input type='submit' value='Back to Home'><br>");
		out.print("</form>");
		
		
		
	}

}
