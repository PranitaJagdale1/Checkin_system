package com.checkIn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkIn.api.model.CheckInRecord;
import com.checkIn.api.repository.CheckInRepository;



@RestController
public class CheckInController {

	/*@GetMapping("/checkinhost")
	public String gethello()
	{
		return "Hello world";
	}*/
	
	@Autowired
	private CheckInRepository checkInRepository;
	
	//to insert checkin data
	@PostMapping("/checkin")
	public CheckInRecord addCheckin(@RequestBody CheckInRecord checkInRecord)
	{
		return checkInRepository.save(checkInRecord);
	}
	
	//to get all checkin data
	@GetMapping("/checkin")
	public List<CheckInRecord> getAllcheckin()
	{
		return checkInRepository.findAll();
	}
}
