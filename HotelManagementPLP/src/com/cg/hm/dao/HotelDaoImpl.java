package com.cg.hm.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;

@Repository
@Transactional
public class HotelDaoImpl implements IHotelDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addHotel(Hotels hotelDetails) {
		entityManager.persist(hotelDetails);
	}

	@Override
	public void addRoom(RoomDetails roomDetails) {
		entityManager.persist(roomDetails);
	}

	@Override
	public List<Hotels> viewAllHotels() {
		String qStr = "SELECT hotels FROM Hotels hotels";
		TypedQuery<Hotels> query = entityManager.createQuery(qStr, Hotels.class);
		return query.getResultList();
	}

	@Override
	public RoomDetails getRoomById(int roomId) {
		RoomDetails room=entityManager.find(RoomDetails.class,roomId);
		return room;
	}

	@Override
	public Hotels getHotelById(int hotelId) {
		Hotels hotel=entityManager.find(Hotels.class, hotelId);
		return hotel;
	}

	@Override
	public List<RoomDetails> getRoomByHotelId(int hotelId) {
		String quer=new String("SELECT r from RoomDetails r where r.hotelId=:p");
		TypedQuery<RoomDetails> querry=entityManager.createQuery(quer, RoomDetails.class);
		querry.setParameter("p", hotelId);
		return querry.getResultList();
	}	

	@Override
	public List<RoomDetails> viewAllRooms() {
		String quer=new String("SELECT r from RoomDetails r");
		TypedQuery<RoomDetails> querry=entityManager.createQuery(quer, RoomDetails.class);
		return querry.getResultList();
	}

	@Override
	public void deleteRoom(int roomID)
	{		
		Query query = entityManager.createQuery(
				"DELETE FROM RoomDetails h WHERE h.roomId =:p");
		query.setParameter("p", roomID).executeUpdate();
	}

	@Override
	public void deleteHotel(int hId) {
		Query query = entityManager.createQuery(
				"DELETE FROM Hotels h WHERE h.hotelId =:p");
		query.setParameter("p", hId).executeUpdate();
	}

	@Override
	public void updateHotel(Hotels hotelDetails) {
		entityManager.merge(hotelDetails);
	}

	@Override
	public void updateRoom(RoomDetails roomDetails) {
		entityManager.merge(roomDetails);
	}

	@Override
	public List<BookingDetails> viewBookingDetailsFromDate(Date date2) {
		List<BookingDetails> bookingDetails=new ArrayList<BookingDetails>();
		String querry=new String("select bookingDetails from BookingDetails bookingDetails"+
				" where bookingDetails.bookedFrom>=:pDate and bookingDetails.bookedTo<=:pDate"
				);	
		TypedQuery<BookingDetails> quer=entityManager.createQuery(querry,BookingDetails.class);
		quer.setParameter("pDate", date2);
		bookingDetails= quer.getResultList();
		return bookingDetails;
	}

	@Override
	public List<BookingDetails> viewBookingSpecificHotel(int hotelId) {
		TypedQuery<BookingDetails> query = entityManager.createQuery("SELECT bdetails FROM BookingDetails bdetails WHERE bdetails.hotelId="+hotelId, BookingDetails.class);
		List<BookingDetails> b=query.getResultList();
		return b;
	}

	@Override
	public List<UserDetails> viewGuestListSpecificHotels(int hotelId) {
		String qStr = "SELECT guestList.userId FROM BookingDetails guestList WHERE hotelId ="+hotelId;
		Query query = entityManager.createQuery(qStr);
		List<Integer> uIDList=query.getResultList();
		if(!uIDList.isEmpty())
		{
			List<UserDetails> list=new ArrayList<>();
			for(int uId:uIDList){
				String q="SELECT gList FROM UserDetails gList WHERE userId="+uId;
				TypedQuery<UserDetails> querry= entityManager.createQuery(q,UserDetails.class);
				UserDetails user=querry.getSingleResult();
				list.add(user);
			}
			return list;
		}else{
			return null;
		}
	}
}


