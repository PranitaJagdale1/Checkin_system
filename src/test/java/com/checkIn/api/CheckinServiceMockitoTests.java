package com.checkIn.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.checkIn.api.controller.CheckInController;
import com.checkIn.api.model.CheckInRecord;
import com.checkIn.api.repository.CheckInRepository;

@SpringBootTest(classes= {CheckinServiceMockitoTests.class})
public class CheckinServiceMockitoTests {

	@Mock
	CheckInRepository checkInRepository;
	
	@InjectMocks
	CheckInController checkInController;
	
	public List<CheckInRecord> myCheckIn;
	
	//Test to get all checkin data
	@Test
	@Order(1)
	public void test_getAllCkeckin()
	{
		List<CheckInRecord> myCheckIn = new ArrayList<CheckInRecord>();
		myCheckIn.add(new CheckInRecord(1,"Patil","Shivani","6","2pm","indigo12","23-9-2022",4));
		myCheckIn.add(new CheckInRecord(2,"Bhoite","Mayuri","8","5pm","AirlineAb12","21-9-2022",1));
		
		//to mock external dependency
		//(i.e whenever this getAllChecking() method is called it will return our own data.
		//It will not return actual data from database)
		when(checkInRepository.findAll()).thenReturn(myCheckIn);
		assertEquals(2,checkInController.getAllcheckin().size());
		
	}
	
	//Test to add or insert checkin data
	@Test
	@Order(2)
	public void test_addCheckin()
	{
		CheckInRecord checkInRecord = new CheckInRecord(3,"Sawant","Rutuja","3","6pm","AirlineA","11-10-2022",3);
		//mock external dependency
		when(checkInRepository.save(checkInRecord)).thenReturn(checkInRecord);
		assertEquals(checkInRecord,checkInController.addCheckin(checkInRecord));
	}
	
}
