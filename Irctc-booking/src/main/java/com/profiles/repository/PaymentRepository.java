package com.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profiles.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
