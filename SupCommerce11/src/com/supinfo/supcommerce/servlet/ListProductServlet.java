package com.supinfo.supcommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private EntityManagerFactory emf;
	//@Override
	//public void init() throws ServletException {
	//	emf = Persistence.createEntityManagerFactory("PU");
	//}
	//@Override
	//public void destroy() {
	//	emf.close();
	//}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//EntityManager em = emf.createEntityManager();
		
		
		//request.setAttribute("products", SupProductDao.getAllProducts());

		//Query query = em.createQuery("SELECT p FROM Product AS p");
		//List<Product> products = query.getResultList();
		//request.setAttribute("products", products);
		
		//em.close();
		
		//good practice
		request.setAttribute("products", DaoFactory.getProductDao().getAllProducts());
		
		RequestDispatcher rd = request.getRequestDispatcher("/listProduct.jsp");
		rd.forward(request, response);
		
		
		
	}

}
