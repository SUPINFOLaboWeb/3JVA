package com.supinfo.supcommerce.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;


@Path("/products") 
public class ProductResource {

	@GET  
	@Path("/hello") 
    @Produces("text/plain")  
    public String hello(){  
        return "Hello World!!!";      
    }  
	
	@GET @Produces(MediaType.APPLICATION_XML)
	@Path("/products") 
	public String getAllProductsInXml() {
		List<Product> products = DaoFactory.getProductDao().getAllProducts();
		String result = new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?><products>");
		for (Product product : products) {
			result = result.concat("<product><id>"+product.getId()+"</id><name>"+product.getName()+"</name><description>"+product.getContent()+"</description><price>"+product.getPrice()+"</price></product>");	
		}
		
	    result = result.concat("</products>");

	    return result;
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	@Path("/products") 
	public String getAllProductsInJson() throws JSONException {
		List<Product> products = DaoFactory.getProductDao().getAllProducts();
		JSONArray list1 = new JSONArray();
		for (Product product : products) {
			JSONObject obj1 = new JSONObject();
			obj1.put("id",product.getId());
			obj1.put("name", product.getName());
			obj1.put("description", product.getContent());
			obj1.put("price", product.getPrice());
			list1.put(obj1);
		}
		
		return list1.toString();
	    
	}
	
	@GET @Path("/product/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String getProductInXml(@PathParam("id") Long productId) {
		Product product = DaoFactory.getProductDao().findProductById(productId);
		String result = new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		result = result.concat("<product><id>"+product.getId()+"</id><name>"+product.getName()+"</name><description>"+product.getContent()+"</description><price>"+product.getPrice()+"</price></product>");	
		
		return result;
	}
	
	@GET @Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductInJson(@PathParam("id") Long productId) throws JSONException {
		
		Product product = DaoFactory.getProductDao().findProductById(productId);
		JSONObject obj1 = new JSONObject();
		obj1.put("id",product.getId());
		obj1.put("name", product.getName());
		obj1.put("description", product.getContent());
		obj1.put("price", product.getPrice());
		return obj1.toString();
		
	}
	
	@DELETE @Path("/product/{id}")
	public void removeProduct(@PathParam("id") Long productId) {
		
		DaoFactory.getProductDao().removeProduct(DaoFactory.getProductDao().findProductById(productId));
	}

	
}
