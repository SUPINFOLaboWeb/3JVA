package com.supinfo.supcommerce.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//EntityManager em = emf.createEntityManager();
		
		try {
			//Product product = em.find(Product.class, Long.parseLong(request.getParameter("id")));
			//em.getTransaction().begin();
			//em.remove(product);
			//em.getTransaction().commit();
			Product product = DaoFactory.getProductDao().findProductById(Long.parseLong(request.getParameter("id")));
			DaoFactory.getProductDao().removeProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
			response.sendRedirect(request.getContextPath() + "/listProduct");
		}
	}

}
