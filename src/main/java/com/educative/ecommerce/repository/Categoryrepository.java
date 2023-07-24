package com.educative.ecommerce.repository;

//import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educative.ecommerce.model.Category;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {

	Optional<Category> findById(Integer id);

	Category findByCategoryName(String categoryName);


	Category findByCategoryNameAndId(String categoryName, Integer id);
}
