package com.project.shopping_Backend.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shopping_Backend.dao.CategoryDAO;
import com.project.shopping_Backend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImp implements CategoryDAO {
	
	private static List<Category> categories= new ArrayList<>();
	
	static{
		Category category=new  Category();
		category.setId(1);
		category.setName("television");
		category.setDescription("this is televison description");
		category.setImgURL("telebision1.png");
		
		categories.add(category);
		
		
		category=new  Category();
		category.setId(2);
		category.setName("Freze");
		category.setDescription("this is Freze description");
		category.setImgURL("Freze1.png");
		
		categories.add(category);
	}

	public List<Category> list() {
		
		return categories;
	}

}
