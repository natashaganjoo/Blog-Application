package com.app.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.blog.entities.Category;
import com.app.blog.entities.User;
import com.app.blog.exceptions.ResourceNotFoundException;
import com.app.blog.services.ICategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/")
	private ResponseEntity<Category> createCategory(@Valid @RequestBody Category cat) {
		categoryService.createCategory(cat);
//		return ResponseEntity.ok(categoryService.createCategory(cat));
		return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
	}

//	@PostMapping("/")
//	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category cat) {
//
//		Category newCategory = categoryService.createCategory(cat);
//		return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
//	}

	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int catId) throws ResourceNotFoundException {

		Category c = categoryService.getCategoryById(catId);
		return new ResponseEntity<Category>(c, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Category>> getAllCategories() {

		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@PutMapping("/{catId}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category c, @PathVariable int catId)
			throws ResourceNotFoundException {

		Category updatedCat = categoryService.updateCategory(c, catId);
		return ResponseEntity.ok(updatedCat);
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<HttpStatus> updateCategory(@PathVariable int catId) throws ResourceNotFoundException {

		categoryService.deleteCategoryById(catId);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
