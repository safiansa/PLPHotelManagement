package com.cg.hm.dao;

import java.sql.Date;
import java.util.List;

import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;

public interface IHotelDao {

	public void addHotel(Hotels hotelDetails);

	public void addRoom(RoomDetails rumDetails);

	public List<Hotels> viewAllHotels();

	public void deleteHotel(int hId);

	public void deleteRoom(int roomId);

	public void updateHotel(Hotels hotelDetails);

	public void updateRoom(RoomDetails rumDetails);

	public RoomDetails getRoomById(int roomId);

	public Hotels getHotelById(int hotelId);

	public List<RoomDetails> getRoomByHotelId(int hotelId);

	public List<RoomDetails> viewAllRooms();

	public List<BookingDetails> viewBookingDetailsFromDate(Date date);

	public List<BookingDetails> viewBookingSpecificHotel(int hotelId);	

	public List<UserDetails> viewGuestListSpecificHotels(int hotelId); 
}
