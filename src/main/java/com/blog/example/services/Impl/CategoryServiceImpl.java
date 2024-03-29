package com.blog.example.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.example.entities.Category;
import com.blog.example.exceptions.ResourceNotFoundException;
import com.blog.example.payloads.CategoryDto;
import com.blog.example.repositories.CategoryRepo;
import com.blog.example.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	  Category category = this.modelMapper.map(categoryDto, Category.class);
	  Category addedcategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addedcategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
	  Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
	 category.setCategoryTitle(categoryDto.getCategoryTitle());
	 category.setCategoryDescription(categoryDto.getCategoryDescription());
	 Category updatedcategory = this.categoryRepo.save(category);
	 return this.modelMapper.map(updatedcategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		  Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
		  this.categoryRepo.delete(category);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		  Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		 List<CategoryDto> categoryDtos = categories.stream().map((category)->this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}
}
