package com.project.shopping_Backend.dao;

import java.util.List;

import com.project.shopping_Backend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	//bussiness methods
	List<Product> listActiveProduct();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product> listLatestActiveProduct(int count);
	
	
}
