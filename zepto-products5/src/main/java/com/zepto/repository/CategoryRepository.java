package com.zepto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zepto.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
	Optional<CategoryEntity> findByCategory(String name);
}
