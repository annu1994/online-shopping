package com.project.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.shopping_Backend.dao.ProductDAO;
import com.project.shopping_Backend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProduct() {

		return productDAO.listActiveProduct();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCatgory(@PathVariable int id) {

		return productDAO.listActiveProductByCategory(id);
	}

}
