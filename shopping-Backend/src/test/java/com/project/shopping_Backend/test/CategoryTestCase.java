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
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project.shopping_Backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
/*
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("this is Mobile description");
		category.setImgURL("Mobile.png");
		assertEquals("Succesfully added inside the table ", true, categoryDAO.add(category));
	}
*/
	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.get(1);
		
		assertEquals("Succesfully get category from  the table ", "Fan", category.getName());
	}*/

	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(1);
		category.setName("I-Phone");
		
		assertEquals("Succesfully update category in   the table ", true, categoryDAO.update(category));
	}*/
	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(2);
	
		assertEquals("Succesfully delete category in   the table ", true, categoryDAO.delete(category));
	}*/
	/*@Test
	public void testListCategory(){
		
		assertEquals("Succesfully fetch category from  the table ", 3, categoryDAO.list().size());
	}*/
	@Test
	public void testCrudCategory(){
		
		/*adding the category*/
		category = new Category();
		category.setName("Mobile");
		category.setDescription("this is Mobile description");
		category.setImgURL("Mobile.png");
		assertEquals("Succesfully added inside the table ", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("this is Television description");
		category.setImgURL("Television.png");
		assertEquals("Succesfully added inside the table ", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("I-Phone");
		category.setDescription("this is I-Phone description");
		category.setImgURL("I-Phone.png");
		assertEquals("Succesfully added inside the table ", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Camera");
		category.setDescription("this is Camera description");
		category.setImgURL("Camera.png");
		assertEquals("Succesfully added inside the table ", true, categoryDAO.add(category));
		
		/*fetching and updating the category
		*/
		category=categoryDAO.get(1);
		category.setName("Redmi");
		assertEquals("Succesfully update category in   the table ", true, categoryDAO.update(category));
		
		/*Deleting the single Category*/
		category=categoryDAO.get(2);
		assertEquals("Succesfully delete category in   the table ", true, categoryDAO.delete(category));
		
		/*Getting the list of Category which is Active*/
		assertEquals("Succesfully fetch category from  the table ", 3, categoryDAO.list().size());
	}
}
