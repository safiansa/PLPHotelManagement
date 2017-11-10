package com.cg.hm.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;
import com.cg.hm.exception.HotelManagementException;



public interface IHotelService {

	public void addHotel(Hotels hotel);
	
	public List<Hotels> viewAllHotels();
	
	public void deleteHotel(int hotelID);

	public void addRoom(RoomDetails rDetails);

	public void deleteRoom(int roomID);

	public RoomDetails getRoomById(int roomId);

	public Hotels getHotelById(int hotelId);
	
	public List<RoomDetails> getRoomByHotelId(int hotelId);

	public List<RoomDetails> viewAllRooms();

	//*****************************************************

	public boolean adminLogin(String userName,String password); //will verify username and password of admin and return true or false.(these values are hardcoded in service class.)

	public int userLogin(String userName,String Password) throws HotelManagementException; //this will verify login details of user and return status(0/1) from dao layer.

	public void addUser(UserDetails userDetails);


	public void updateHotel(Hotels hotel);



	public void updateRoom(RoomDetails rDetails);

	 //it will display all hotels from table HOTELS.

	public List<BookingDetails> viewBookingSpecificHotel(int hotelId);

	public List<String> viewGuestListSpecificHotels(int hotellId); 

	public List<BookingDetails> viewBookingDetailsFromDate(LocalDate date); 

	public List<Hotels> searchHotels(String city, int minPrice,int maxPrice,
			int rating); 

	public int bookingStatus(); 

	int getAmountToBePaid(BookingDetails bkDetails);

	//	int bookHotel(BookingDetails bkDetails);

	public RoomDetails getStatus(RoomDetails rumDetails);



}
