package com.cg.hm.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hm.dao.IHotelDao;
import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	IHotelDao hotelDao;

	@Override
	public RoomDetails getRoomById(int roomId) {
		return hotelDao.getRoomById(roomId);
	}

	@Override
	public Hotels getHotelById(int hotelId) {
		return hotelDao.getHotelById(hotelId);
	}

	@Override
	public List<RoomDetails> getRoomByHotelId(int hotelId) {
		return hotelDao.getRoomByHotelId(hotelId);
	}

	@Override
	public List<Hotels> viewAllHotels() {
		return hotelDao.viewAllHotels();
	}

	@Override
	public void addHotel(Hotels hotel) {
		hotelDao.addHotel(hotel);
	}

	@Override
	public void deleteHotel(int hotelID) {
		hotelDao.deleteHotel(hotelID);

	}

	@Override
	public void deleteRoom(int roomID) {
		hotelDao.deleteRoom(roomID);
	}

	@Override
	public void addRoom(RoomDetails rDetails) {
		hotelDao.addRoom(rDetails);
	}

	@Override
	public List<RoomDetails> viewAllRooms() {
		return hotelDao.viewAllRooms();
	}

	@Override
	public List<BookingDetails> viewBookingDetailsFromDate(Date date) {
		return hotelDao.viewBookingDetailsFromDate(date);
	}

	@Override
	public void updateHotel(Hotels hotel) {
		hotelDao.updateHotel(hotel);

	}

	@Override
	public void updateRoom(RoomDetails rDetails) {
		hotelDao.updateRoom(rDetails);
	}

	@Override
	public List<BookingDetails> viewBookingSpecificHotel(int hotelId) {	//neha
		return hotelDao.viewBookingSpecificHotel(hotelId);
	}

	@Override
	public List<UserDetails> viewGuestListSpecificHotels(int hotellId) {	//neha
		return hotelDao.viewGuestListSpecificHotels(hotellId); 
	}

}
