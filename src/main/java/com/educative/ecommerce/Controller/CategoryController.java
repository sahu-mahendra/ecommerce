package com.educative.ecommerce.Controller;

import com.educative.ecommerce.model.ApiResponse;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{sortBy}/{orderBy}")
	public ResponseEntity<List<Category>> getAllCategory(@PathVariable("sortBy") String sortBy, @PathVariable("orderBy")String orderBy) {

		System.out.println("Hello world");
		
		List<Category> categories = this.categoryService.listOfCategory(sortBy,orderBy);

		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		if (Objects.nonNull(categoryService.read(category.getId()))) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"),
					HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);

	}

	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID,
			@Valid @RequestBody Category category) {

		if (Objects.nonNull(categoryService.read(categoryID))) {

			categoryService.updateCategory(categoryID, category);

			return new ResponseEntity<>(new ApiResponse(false, "updated"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/delet/{categoryID}")
	public void deletData(@PathVariable("categoryID") Integer categoryID, Integer categoryid) {
		System.out.println(categoryID);
	}

	// @PutMapping("")

}
