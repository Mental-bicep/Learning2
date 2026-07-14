package com.prac1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.prac1.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{
	Optional<OrderEntity> findByProductName(String name);
}
