package com.project.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping_Backend.dao.CategoryDAO;
import com.project.shopping_Backend.dao.ProductDAO;
import com.project.shopping_Backend.dto.Category;
import com.project.shopping_Backend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {
	
		@Autowired
		private CategoryDAO categoryDAO;
		@Autowired
		private ProductDAO productDAO;
		
		private static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);
		
		@RequestMapping(value="/products", method=RequestMethod.GET)
		public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation){
			
			ModelAndView mv=new ModelAndView("page");
			mv.addObject("userClickManageProduct", true);
			mv.addObject("title", "Manage Products");
			Product nproduct=new Product();
			//set some field
			nproduct.setSupplierId(1);
			nproduct.setActive(true);
			mv.addObject("product", nproduct);
			
			if(operation!=null){
				if(operation.equals("product")){
					mv.addObject("message", "Product added Successfully");
				}
			}
			
			return mv;
		}
		
		
		
		@ModelAttribute("categories")
		public List<Category> getCategories(){
			
			return categoryDAO.list();
			
		}
		//Handling Product submission
		@RequestMapping(value="/products", method=RequestMethod.POST)
		public String handleProductSubmission(@ModelAttribute("product") Product mProduct){
			
			logger.info(mProduct.toString());
			productDAO.add(mProduct);
			return "redirect:/manage/products?operation=product";
		}
		
}
