package com.amazon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.entity.OtpEntity;
import java.util.List;


@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Integer>{
	
	List<OtpEntity> findByMobile(String mobile);
}
