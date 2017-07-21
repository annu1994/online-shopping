package com.project.shopping_Backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.shopping_Backend.dao.CategoryDAO;
import com.project.shopping_Backend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	
	@BeforeClass
	public static void init(){
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.project.shopping_Backend");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	@Test
	public  void testAddCategory(){
		
		category=new Category();
		category.setName("LED");
		category.setDescription("this is televison description");
		category.setImgURL("LED.png");
		
		assertEquals("Succesfully added inside the table ",true,categoryDAO.add(category));
	}
	
}
