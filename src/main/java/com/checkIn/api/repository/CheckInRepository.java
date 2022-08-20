package com.checkIn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkIn.api.model.CheckInRecord;

public interface CheckInRepository extends JpaRepository<CheckInRecord, Long>{

}
