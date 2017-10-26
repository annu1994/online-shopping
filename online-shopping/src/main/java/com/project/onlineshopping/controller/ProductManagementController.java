package com.project.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.onlineshopping.util.FileUploadUtility;
import com.project.onlineshopping.validator.ProductValidator;
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

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		// set some field
		nProduct.setActive(true);
		nProduct.setSupplierId(1);
		
		mv.addObject("product", nProduct);
		
		logger.info("In [ProductManagementController] >> [showManageProducts] product active status : {}" , nProduct.isActive());
		

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product added Successfully");
			}
			else if(operation.equals("category")){
				mv.addObject("message", "Category added Successfully");
			}
		}

		return mv;
	}
	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView handleEditProduct(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		//Fetch  the Product by its id
		Product nProduct = productDAO.get(id);
		
		mv.addObject("product", nProduct);

		return mv;
	}



	// Handling Product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model,HttpServletRequest request) {
		if(mProduct.getId()==0){
			new ProductValidator().validate(mProduct, results);
		}
		else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// check if any Error
		if (results.hasErrors()) {

			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for Product submission");
			return "page";
		}
		logger.info("In [ProductManagementController] >>>> [handleProductSubmission] New Product data :{}",mProduct.toString());
		
		if(mProduct.getId()==0){
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);	
		}
		
		/*we are applying a simple check if the mproduct contain the file call the file upload method*/
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id){
		//getting the product id 
		Product product=productDAO.get(id);
		//checking whether is active or not
		boolean isActive=product.isActive();
		//activate or deactivate the product
		product.setActive(!product.isActive() );
		productDAO.update(product);
		
		return (isActive)? "You have Successfully Deactivate the Product with Id" +product.getId() :
							"You have Successfully Activate the Product with Id" +product.getId();
	}
	//returning categories for all request 
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();

	}
	
	@ModelAttribute("category")
	public Category getCategory() {

		return new Category();

	}
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category") Category category){
		
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
	}

}
