package com.cg.hm.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;
import com.cg.hm.exception.HotelManagementException;


public interface IHotelDao {

	public boolean addHotel(Hotels hotelDetails);

	public void addRoom(RoomDetails rumDetails);

	public List<Hotels> viewAllHotels();
	
	public void deleteHotel(int hId);

	public void deleteRoom(int roomId);
	
	public RoomDetails getRoomById(int roomId);
	
	public Hotels getHotelById(int hotelId);
	
	public List<RoomDetails> getRoomByHotelId(int hotelId);
	
	public List<RoomDetails> viewAllRooms();
//****************************************************

	public UserDetails userLogin(String userName) throws HotelManagementException;

	public void addUser(UserDetails userDetails);

	public List<BookingDetails> viewBookingDetailsFromDate(LocalDate date);

	public List<Hotels> searchHotels(String city,int minPrice,int maxPrice,int rating); 	

	public List<String> viewGuestListSpecificHotels(int hotellId); 	

	public List<BookingDetails> viewBookingSpecificHotel(int hotelId);	



	public void updateHotel(Hotels hotelDetails);

	

	public void updateRoom(RoomDetails rumDetails);

	public void updateTableBeforeBooking(BookingDetails bkDetailsObj); 

	public void update(BookingDetails bkDetails); 

	public RoomDetails checkAvailability(BookingDetails bkDetails); 

	//	public void bookHotel(BookingDetails bkDetails); 
	public int getAmountToBePaid(BookingDetails bkDetails) ;

	RoomDetails getStatus(RoomDetails rumDetails);


}
