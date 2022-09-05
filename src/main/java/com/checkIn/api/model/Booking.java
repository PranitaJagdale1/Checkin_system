package com.checkIn.api.model;

public class Booking {
	private long bookingId;
	private String firstName;
	private String lastName;
	private String gender;
	private int noOfSeats;
	private String classs;
	
	public Booking(long bookingId, String firstName, String lastName, String gender, int noOfSeats, String classs) {
		super();
		this.bookingId = bookingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.noOfSeats = noOfSeats;
		this.classs = classs;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", noOfSeats=" + noOfSeats + ", classs=" + classs + "]";
	}
	
	
	
}
