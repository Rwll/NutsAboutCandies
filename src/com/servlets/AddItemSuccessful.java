package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nutsaboutcandy.entities.StorePackage;
import com.nutsaboutcandy.entities.categories.*;
/**
 * Servlet implementation class AddItemSuccessful
 */
@WebServlet("/AddItemSuccessful")
public class AddItemSuccessful extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemSuccessful() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, ArrayList<StorePackage> nac_database) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productName = request.getParameter("productName");
		String NutsCategory = request.getParameter("NutsCategory");
		String CandyCategory = request.getParameter("CandyCategory");
		String NutsCandyCategory = request.getParameter("NutsCandyCategory");
		String listOfIngredients = request.getParameter("ingredients");
		String regularType = request.getParameter("regular");
		String premiumType = request.getParameter("premium");
		String numOfStockSmall = request.getParameter("numberOfStockSmall");
		String numOfStockMedium = request.getParameter("numberOfStockMedium");
		String numOfStockLarge = request.getParameter("numberOfStockLarge");
		

	       
	      
		
	}

}
