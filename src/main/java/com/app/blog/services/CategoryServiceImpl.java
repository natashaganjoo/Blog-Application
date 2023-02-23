package com.app.blog.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.entities.Category;
import com.app.blog.exceptions.ResourceNotFoundException;
import com.app.blog.repositories.CategoryRepo;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public void createCategory(Category cat) {

		categoryRepo.save(cat);
//		return cat;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(int catId) throws ResourceNotFoundException {

		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "CategoryId", catId));

		return cat;
	}

	@Override
	public Category updateCategory(Category cat, int catId) throws ResourceNotFoundException {

		Category category = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "CategoryId", catId));

		category.setCategoryDescription(cat.getCategoryDescription());
		category.setCategoryTitle(cat.getCategoryTitle());
		
		Category updated = categoryRepo.save(category);

		return updated;
	}

	@Override
	public void deleteCategoryById(int catId) throws ResourceNotFoundException {

		Category category = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "CategoryId", catId));

		categoryRepo.delete(category);
	}

}
