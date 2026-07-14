package com.zepto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zepto.entity.CategoryEntity;
import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	
	Optional<CategoryEntity> findByCategoryName(String categoryName);
}
