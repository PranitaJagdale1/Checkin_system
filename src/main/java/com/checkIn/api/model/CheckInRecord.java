package com.checkIn.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckInRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id;
	
	String lastname;
	String firstname;
	String seatNumber;
	String checkInTime;
	String flightNumber;
	String flightDate;
	long bookingId;
	
	public CheckInRecord(long id, String lastname, String firstname, String seatNumber, String checkInTime,
			String flightNumber, String flightDate, long bookingId) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.seatNumber = seatNumber;
		this.checkInTime = checkInTime;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.bookingId = bookingId;
	}

	public CheckInRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "CheckInRecord [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", seatNumber="
				+ seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate="
				+ flightDate + ", bookingId=" + bookingId + "]";
	}
	
	
	
}
