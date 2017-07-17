package com.project.shopping_Backend.dao;

import java.util.List;

import com.project.shopping_Backend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	List<Category> list();
	Category get(Integer id);
}
