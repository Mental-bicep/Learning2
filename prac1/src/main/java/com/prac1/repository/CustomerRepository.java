package com.prac1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.prac1.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>{
	Optional<CustomerEntity> findByCustomerNameAndCustomerEmail(String name, String email);
}
