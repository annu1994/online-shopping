package com.project.shopping_Backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.shopping_Backend.dao.ProductDAO;
import com.project.shopping_Backend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.shopping_Backend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	/*@Test
	public void TestCrudProduct() {
		//saving the product
		product = new Product();
		product.setName("iphone 6s");
		product.setBrand("iphone");
		product.setDescription("this is expensive phone");
		product.setUnitPrice(25000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("error while saving data ", true, productDAO.add(product));
	
		// updating the product 
		product=productDAO.get(1);
		product.setName("samsung");
		assertEquals("error while updating the product", true, productDAO.update(product));
		//soft delete the product item
		product=productDAO.get(1);
		assertEquals("error while deleting the product", true, productDAO.delete(product));
		//Fetching the list of product
		assertEquals("error while fetching list of product",3,productDAO.list().size());
	}*/
	/*@Test
	public void ListofActiveProduct(){
		
		assertEquals("error while fetching list of product",2,productDAO.listActiveProduct().size());
	}
	*/
	/*@Test
	public void ListofActiveProductByCategory(){
		
		assertEquals("error while fetching list of list of ActiveproductBy category",1,productDAO.listActiveProductByCategory(3).size());
	}*/
	/*@Test
	public void ListoflatestActiveProduct(){
		
		assertEquals("error while fetching list of list of ActiveproductBy category",2,productDAO.listLatestActiveProduct(2).size());
	}*/
}
