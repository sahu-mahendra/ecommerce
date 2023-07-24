package com.educative.ecommerce.model;

import java.util.stream.Stream;

//import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	private static Stream<Category> name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "categoryName")
	private @NotBlank String categoryName;

	private @NotBlank String description;

	@Column(name = "imageUrl")
	private @NotBlank String imageUrl;

	
	
	@JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
	@Column(name = "date")
	private String date;

	public String getDateCreated() {
		return date;
	}

	public void setDateCreated(String date) {
		this.date = date;
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDate() {
		return date;
	}

	public static Object stream() {
		
		return null;
	}

}
