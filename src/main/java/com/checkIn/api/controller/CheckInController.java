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

	/*@GetMapping("/checkin")
	public String gethello()
	{
		return "Hello world";
	}*/
	
	@Autowired
	private CheckInRepository checkInRepository;
	
	@PostMapping("/checkin")
	public CheckInRecord postAuthor(@RequestBody CheckInRecord checkInRecord)
	{
		return checkInRepository.save(checkInRecord);
	}
	
	@GetMapping("/checkin")
	public List<CheckInRecord> getAllcheckin()
	{
		return checkInRepository.findAll();
	}
}
