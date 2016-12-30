package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ///**
    // * @see HttpServlet#HttpServlet()
    // */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	///**
	// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	// */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	// TODO Auto-generated method stub
	//}

	///**
	// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	// */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	// TODO Auto-generated method stub
	//}
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		List<SupProduct> products = SupProductDao.getAllProducts();
		
    		PrintWriter out = response.getWriter();
		out.println("My products : ");
		
		
		for (SupProduct product : products) {
			out.println(product.getName() + " - " + product.getContent() + " - " + product.getPrice());
		}
	}
}


