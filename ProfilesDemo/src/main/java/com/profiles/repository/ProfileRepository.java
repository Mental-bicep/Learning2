package com.profiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profiles.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>{

}
