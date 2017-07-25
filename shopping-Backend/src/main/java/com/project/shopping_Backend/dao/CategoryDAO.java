package com.project.shopping_Backend.dao;

import java.util.List;

import com.project.shopping_Backend.dto.Category;

public interface CategoryDAO {
	
	Category get(Integer id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
