package com.project.shopping_Backend.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.shopping_Backend.dao.CategoryDAO;
import com.project.shopping_Backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImp implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();
		category.setId(1);
		category.setName("television");
		category.setDescription("this is televison description");
		category.setImgURL("television1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Freze");
		category.setDescription("this is Freze description");
		category.setImgURL("Freze1.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is laptop description");
		category.setImgURL("laptop.png");
		categories.add(category);

	}

	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(Integer id) {
		/* forEach loop for getting category based on id */
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
