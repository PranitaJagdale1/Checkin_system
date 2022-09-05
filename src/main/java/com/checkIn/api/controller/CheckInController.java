package com.checkIn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.checkIn.api.model.Booking;
import com.checkIn.api.model.CheckInRecord;

import com.checkIn.api.repository.CheckInRepository;



@RestController
//@RequestMapping("/api")
public class CheckInController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/checkinhost")
	public String gethello()
	{
		return "Hello world";
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CheckInRepository checkInRepository;
	
	
	
	//to insert checkin data
	@PostMapping("/checkin")
	public CheckInRecord addCheckin(@RequestBody CheckInRecord checkInRecord)
	{
		return checkInRepository.save(checkInRecord);
	}
	
	//to display all checkin data
	@GetMapping("/checkin")
	public List<CheckInRecord> getAllcheckin()
	{
		return checkInRepository.findAll();
	}
	
	
	// Method to fetch data by checkin id
		@GetMapping("/checkin/{Id}")
		public ResponseEntity<CheckInRecord> getCheckInId(@PathVariable Long Id)
		{
			CheckInRecord getCheckIn = checkInRepository.getById(Id);
			return ResponseEntity.ok().body(getCheckIn);
		}
		
		@GetMapping("/checkin/booking/{bookingId}")
		public List<CheckInRecord> getCheckInByBookingId(@PathVariable("bookingId") Long bookingId)
		{
			return checkInRepository.findByBookingId(bookingId);
		}
	
}
