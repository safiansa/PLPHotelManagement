package com.cg.hm.dao;

import java.sql.Date;
import java.time.LocalDate;
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
import com.cg.hm.exception.HotelManagementException;

@Repository
@Transactional
public class HotelDaoImpl implements IHotelDao {
	//private static Logger Logger = org.apache.log4j.Logger.getLogger(com.cg.hotelManagement.dao.HotelManagementDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addHotel(Hotels hotelDetails) {
		entityManager.persist(hotelDetails);
		return true;
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

	public void modifyRoom(RoomDetails roomDetails)
	{	
		entityManager.merge(roomDetails);
	}

	@Override
	public void updateHotel(Hotels hotelDetails) {
		entityManager.merge(hotelDetails);
	}
	
	@Override
	public void updateRoom(RoomDetails roomDetails) {
			entityManager.merge(roomDetails);
	}

	//**********************************************************************	

	@Override
	public UserDetails userLogin(String userId) throws HotelManagementException{
		entityManager.getTransaction().begin();
		try{
			UserDetails userDetails=entityManager.find(UserDetails.class,userId);
			entityManager.getTransaction().commit();
			//Logger.info("User Login with login ID -->"+userId);
			return userDetails;
		}catch(NullPointerException e){
			//Logger.error("Wrong user ID tried to login.");
			throw new HotelManagementException("This User Does Not Exist");

		}

	}

	@Override
	public void addUser(UserDetails userDetails) {
		entityManager.persist(userDetails);
	}





	@Override
	public List<BookingDetails> viewBookingDetailsFromDate(LocalDate date2) {
		int d=date2.getDayOfMonth();
		int y=date2.getYear();
		int m=date2.getMonthValue();
		Date date=new Date(y-1900, m-1, d);
		List<BookingDetails> bookingDetails=new ArrayList<BookingDetails>();
		String querry=new String("select bookingDetails from BookingDetails bookingDetails"+
				" where bookingDetails.bookedFrom>=:pDate"
				);	
		TypedQuery<BookingDetails> quer=entityManager.createQuery(querry,BookingDetails.class);
		quer.setParameter("pDate", date);
		//Logger.info("Viewed booking details from date ::"+date2);
		return quer.getResultList();
	}

	@Override
	public List<Hotels> searchHotels(String city, int minPrice,
			int maxPrice, int rating) {
		String querry=new String("select hotel from Hotels hotel"+
				" where hotel.city=:pCity and "
				+ "hotel.avgRatePerNight<=:pMaxPrice and "+
				"hotel.avgRatePerNight>=:pMinPrice"+
				" and hotel.rating>=:pRating");	
		TypedQuery<Hotels> quer=entityManager.createQuery(querry,Hotels.class);
		quer.setParameter("pMinPrice",minPrice);
		quer.setParameter("pMaxPrice",maxPrice);
		quer.setParameter("pRating",rating);
		quer.setParameter("pCity",city);
		//Logger.info("Hotel search executed.");
		return quer.getResultList();
	}

	//	@Override
	//	public void bookHotel(BookingDetails bkDetails)
	//	{
	//		entityManager.persist(bkDetails);
	//		//Logger.info("Booking details with details ::"+bkDetails+"successfully inserted");
	//	}


	@Override
	public RoomDetails checkAvailability(BookingDetails bkDetails) {
		try{
			//beginTransaction();
			String query=new String("select rd from RoomDetails rd where rd.hotelId=:hId and rd.roomId=:rId");
			TypedQuery<RoomDetails> quer=entityManager.createQuery(query,RoomDetails.class);
			quer.setParameter("hId",bkDetails.getHotelId());
			quer.setParameter("rId",bkDetails.getRoomId());

			RoomDetails rDetails=new RoomDetails();
			rDetails=quer.getSingleResult();
			return rDetails;
		}
		catch(Exception e)
		{
			System.err.println("Enter valid RoomId");
			return null;
		}

	}

	@Override
	public void update(BookingDetails bkDetails) 
	{

		String query=new String("update RoomDetails rd " +
				"set rd.availability=rd.availability-1 "+
				"where rd.roomId=:bkRId and rd.hotelId=:bkHId");

		Query qur=  entityManager.createQuery(query);
		qur.setParameter("bkRId",bkDetails.getRoomId());
		qur.setParameter("bkHId",bkDetails.getHotelId());

		int status= qur.executeUpdate();


		entityManager.getTransaction().commit();


	}



	@Override
	public List<String> viewGuestListSpecificHotels(int hotellId) {
		if(entityManager.find(Hotels.class,hotellId)==null)
		{
			System.err.println("Hotel ID you Entered does not exist.");
			return null;
		}
		else{
			String qStr = "SELECT guestList.userId FROM BookingDetails guestList WHERE hotelId ='"+hotellId+"'";
			TypedQuery<String> query = entityManager.createQuery(qStr, String.class);

			List<String> uIDList= query.getResultList();
			List<String> uNameList=null;
			for(String uId:uIDList){
				String q="SELECT gList.userName FROM UserDetails gList WHERE userId='"+uId+"'";
				Query query1 = entityManager.createQuery(q,String.class);
				System.out.println("User name ::"+query1.getResultList());
				//entityManager.getTransaction().commit();
				//uNameList.add((String) query1.getSingleResult());
			}
			return uNameList;
		}
	}

	@Override
	public List<BookingDetails> viewBookingSpecificHotel(int hotelId) {
		TypedQuery<BookingDetails> query = entityManager.createQuery("SELECT bdetails FROM BookingDetails bdetails WHERE bdetails.hotelId="+hotelId, BookingDetails.class);
		List<BookingDetails> b=query.getResultList();
		entityManager.getTransaction().commit();
		return b;
	}



	



	@Override
	public int getAmountToBePaid(BookingDetails bkDetails) {

		String query=new String("select rd from RoomDetails rd where rd.hotelId=:hId and rd.roomId=:rId");
		TypedQuery<RoomDetails> quer=entityManager.createQuery(query,RoomDetails.class);
		quer.setParameter("hId",bkDetails.getHotelId());
		quer.setParameter("rId",bkDetails.getRoomId());

		RoomDetails rDetails=new RoomDetails();
		rDetails=quer.getSingleResult();
		return rDetails.getPerNightRate();

	}
	@Override
	public RoomDetails getStatus(RoomDetails rumDetails) {

		try{
			String query=new String("select rd from RoomDetails rd where rd.hotelId=:hId and rd.roomId=:rId");
			TypedQuery<RoomDetails> quer=entityManager.createQuery(query,RoomDetails.class);
			quer.setParameter("hId",rumDetails.getHotelId());
			quer.setParameter("rId",rumDetails.getRoomId());

			RoomDetails rDetails=new RoomDetails();
			rDetails=quer.getSingleResult();
			return rDetails;
		}
		catch(Exception e)
		{
			System.err.println("The Entered RoomId does not Exists ");
			return null;
		}


	}

	@Override
	public void updateTableBeforeBooking(BookingDetails bkDetailsObj) {
		// TODO Auto-generated method stub

	}



}


