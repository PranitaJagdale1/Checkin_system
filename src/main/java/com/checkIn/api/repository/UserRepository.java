package com.checkIn.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkIn.api.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	public Optional<UserEntity> findById(String id);
}
