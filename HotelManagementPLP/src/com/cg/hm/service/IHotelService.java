package com.cg.hm.service;

import java.sql.Date;
import java.util.List;

import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;

public interface IHotelService {

	public void addHotel(Hotels hotel);

	public void addRoom(RoomDetails rDetails);

	public void deleteHotel(int hotelID);

	public void deleteRoom(int roomID);

	public void updateHotel(Hotels hotel);

	public void updateRoom(RoomDetails rDetails);

	public List<Hotels> viewAllHotels();

	public List<RoomDetails> viewAllRooms();

	public RoomDetails getRoomById(int roomId);

	public Hotels getHotelById(int hotelId);

	public List<RoomDetails> getRoomByHotelId(int hotelId);

	public List<BookingDetails> viewBookingDetailsFromDate(Date date); 

	public List<BookingDetails> viewBookingSpecificHotel(int hotelId);

	public List<UserDetails> viewGuestListSpecificHotels(int hotellId); 
}
