package com.app.blog.services;

import java.util.List;

import com.app.blog.entities.Category;
import com.app.blog.exceptions.ResourceNotFoundException;

public interface ICategoryService {

	void createCategory(Category cat);

	List<Category> getAllCategories();

	Category getCategoryById(int catId) throws ResourceNotFoundException;

	Category updateCategory(Category cat, int catId) throws ResourceNotFoundException;

	void deleteCategoryById(int catId) throws ResourceNotFoundException;
}
