package com.sheryians.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Category;

public interface CategoryRespository extends JpaRepository<Category, Integer>{
	
}
