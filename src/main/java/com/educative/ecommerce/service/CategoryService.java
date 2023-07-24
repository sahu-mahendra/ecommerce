package com.educative.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.repository.Categoryrepository;

@Service
public class CategoryService {

	private static final Collection<Category> listoFCategories = null;
	@Autowired
	private Categoryrepository categoryrepository;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");

	/// Sort by - asc| desc -- id|name|Date let us say field name

	public List<Category> listOfCategory(String sortByField, String sortByOrder) {

		var listoFCategories = this.categoryrepository.findAll();
		if (!listoFCategories.isEmpty()) {

			/// by id

			switch (sortByField) {
			case "Name": {

				if (sortByOrder.equals("desc")) {

					listoFCategories.sort(nameCompartor.reversed());
				} else {
					listoFCategories.sort(nameCompartor);
				}

				break;

			}
			
			
			
			case "Date": {

				if ( ) {
					
				}
			}
				break;
				
				
				
				
			case "id": {

				listoFCategories.sort(sortByOrder.equals("desc") ? idComparator.reversed() : idComparator);

			}
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + sortByField);
			}

		}
		return listoFCategories;

	}

	Comparator<Category> idComparator = Comparator.comparing(Category::getId);
	Comparator<Category> nameCompartor = Comparator.comparing(Category::getCategoryName);
	// Comparator<Category> dateCompartor = Comparator.comparing();
	
	
	
	Optional<Category> latestItem = Category.stream().sorted((e1, e2) -> e2.getCreateDate().
			compareTo(e1.getCreateDate())).findFirst();
	
	
	
	
	public void createCategory(Category category) {

		this.categoryrepository.save(category);
	}

	public Category read(String categoryName) {

		return this.categoryrepository.findByCategoryName(categoryName);
	}

	public Optional<Category> read(Integer id) {

		return this.categoryrepository.findById(id);
	}

	public void updateCategory(Integer id, Category updatedCategory) {

		Category storedCategory = this.categoryrepository.findById(id).get();

		storedCategory.setCategoryName(updatedCategory.getCategoryName());
		storedCategory.setDescription(updatedCategory.getDescription());
		storedCategory.setImageUrl(updatedCategory.getImageUrl());

		this.categoryrepository.save(storedCategory);

	}

}
