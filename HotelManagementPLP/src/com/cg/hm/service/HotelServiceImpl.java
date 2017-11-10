package com.cg.hm.service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hm.dao.IHotelDao;
import com.cg.hm.dto.BookingDetails;
import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.dto.UserDetails;
import com.cg.hm.exception.HotelManagementException;

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

	//******************************************

	public boolean adminLogin(String userName,String password){
		if(userName.equalsIgnoreCase("system") && password.equals("Capgemini123"))
			return true;
		else 
			return false;
	}

	@Override
	public int getAmountToBePaid(BookingDetails bkDetails) {

		RoomDetails rumDetails=hotelDao.checkAvailability(bkDetails);
		int amountToBePaid=rumDetails.getPerNightRate();
		return amountToBePaid;
	}

	@Override
	public int userLogin(String userName, String Password) throws HotelManagementException {
		UserDetails  userDetails=hotelDao.userLogin(userName);
		try{
			String uId = userDetails.getUserId();
			String pwd= userDetails.getPassword();

			if(userName.equalsIgnoreCase(uId) && Password.equals(pwd))
				return 1;
			else 
				return 0;
		}catch(NullPointerException e){
			throw new HotelManagementException("User does not exist");
		}
	}




	@Override
	public List<BookingDetails> viewBookingSpecificHotel(int hotelId) {	//neha
		return hotelDao.viewBookingSpecificHotel(hotelId);
	}

	@Override
	public List<String> viewGuestListSpecificHotels(int hotellId) {	//neha
		return hotelDao.viewGuestListSpecificHotels(hotellId); 
	}

	@Override
	public List<BookingDetails> viewBookingDetailsFromDate(LocalDate date) {
		return hotelDao.viewBookingDetailsFromDate(date);
	}

	@Override
	public List<Hotels> searchHotels(String city, int minPrice,int maxPrice,
			int rating) {
		return hotelDao.searchHotels(city, minPrice, maxPrice, rating);
	}

	//	@Override
	//	public int bookHotel(BookingDetails bkDetails) {
	//		
	//		
	//		RoomDetails rumDetails=hotelDao.checkAvailability(bkDetails);
	//
	//		int noOfRoomsAvailable=rumDetails.getAvailability();
	//		
	//		System.out.println("Available no of rooms is "+noOfRoomsAvailable);
	//
	//		if(noOfRoomsAvailable>0)
	//		{
	//			/*Date bookedFrom = bkDetails.getBookedFrom();
	//			Date bookedTo = bkDetails.getBookedTo();
	//			Period prd=( bookedFrom.toLocalDate()).until( bookedTo.toLocalDate());
	//			int prdInDays=prd.getDays();*/
	//			
	//				
	//				hotelDao.bookHotel(bkDetails);
	//				System.out.println("\nHotel is  Booked \n");
	//				
	//				hotelDao.update(bkDetails);
	//				System.out.println("Updated the no of rooms in Room Details \n");
	//				return 1;
	//		
	//		}
	//
	//		else return 0;
	//
	//	}

	@Override
	public int bookingStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addUser(UserDetails userDetails) {
		hotelDao.addUser(userDetails);
	}



	@Override
	public void updateHotel(Hotels hotel) {
		hotelDao.updateHotel(hotel);

	}



	@Override
	public void updateRoom(RoomDetails rDetails) {
		hotelDao.updateRoom(rDetails);

	}


	public void checkHotelId(String hId) throws HotelManagementException
	{

		String validHId = "[0-9]{3}";

		if(Pattern.matches(validHId, hId)==false)
			throw new HotelManagementException("Enter valid Input");
	}

	public void checkHotelCity(String cty) throws HotelManagementException {

		String validCty = "[A-Za-z ]{1,}";

		if(Pattern.matches(validCty,cty )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkHotelName(String hName) throws HotelManagementException {
		String validHotelName = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelName,hName )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkaddrs(String addrs) throws HotelManagementException {
		String validHotelAddrs = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelAddrs,addrs )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkDesc(String desc) throws HotelManagementException {

		String validHotelDesc = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelDesc,desc )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkArpn(int arpn) throws HotelManagementException {
		String validHotelAvgRPN = "[1-9]{1}[0-9]{1,}";

		if(Pattern.matches(validHotelAvgRPN,Integer.toString(arpn) )==false)//String.valueOf
			throw new HotelManagementException("Enter valid Input");
	}

	public void checkPNo(String pno) throws HotelManagementException {
		String validHotelAvgRPN = "[1-9]{1}[0-9]{9}";

		if(Pattern.matches(validHotelAvgRPN,pno )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkSNo(String sno) throws HotelManagementException {
		String validHotelAvgRSN = "[1-9]{1}[0-9]{9}";

		if(Pattern.matches(validHotelAvgRSN,sno )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkRating(int rating) throws HotelManagementException {
		String validHotelAvgRSN = "[1-5]{1}";

		if(Pattern.matches(validHotelAvgRSN,Integer.toString(rating) )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkFax(String fax) throws HotelManagementException {

		String validHotelFax = "[0-9]{5}";

		if(Pattern.matches(validHotelFax,fax )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkRId(String rId) throws HotelManagementException {

		String validHotelRId = "[0-9]{3}";

		if(Pattern.matches(validHotelRId,rId )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkRoomNo(String rNo) throws HotelManagementException {

		String validHotelRNo = "[1-9]{1}[0-9]{2}";

		if(Pattern.matches(validHotelRNo,rNo )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkRoomType(String rType) throws HotelManagementException {

		String validHotelRNo = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelRNo,rType )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkPNR(int pnr) throws HotelManagementException {

		String validHotelAvgRSN = "[1-9]{1}[0-9]{1,}";

		if(Pattern.matches(validHotelAvgRSN,Integer.toString(pnr) )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkAVL(int avl) throws HotelManagementException {
		String validHotelAvgRSN = "[0-1]{1}";

		if(Pattern.matches(validHotelAvgRSN,Integer.toString(avl) )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkCity(String city) throws HotelManagementException {


		String validHotelRNo = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelRNo,city )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkBookingId(String bookingId) throws HotelManagementException {
		String validHotelAvgRSN = "[1-9]{1}[0-9]{4}";

		if(Pattern.matches(validHotelAvgRSN,bookingId )==false)
			throw new HotelManagementException("BookingId is not valid");


	}

	public void checkUserId(String userId) throws HotelManagementException {

		String validHotelAvgRSN = "[0-9]{1,}";

		if(Pattern.matches(validHotelAvgRSN,userId )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkNoOfAdults(int noOfAdults) throws HotelManagementException {
		String validHotelAvgRSN = "[1-6]{1}";

		if(Pattern.matches(validHotelAvgRSN,Integer.toString(noOfAdults) )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkNoOfChildren(int noOfChildren) throws HotelManagementException {
		String validHotelAvgRSN = "[0-5]{1}";

		if(Pattern.matches(validHotelAvgRSN,Integer.toString(noOfChildren) )==false)
			throw new HotelManagementException("Enter valid Input");



	}

	public void checkUserRole(String userRole) throws HotelManagementException {
		if(userRole.equals("user")||userRole.equals("hotelemployee"))
			return;
		else
			throw new HotelManagementException("Enter valid Input");
	}

	public void checkUserName(String userName) throws HotelManagementException {

		String validHotelAvgRSN = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelAvgRSN,userName )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkMobileNo(String userMobileNo) throws HotelManagementException {

		String validHotelAvgRSN = "[1-9]{1}[0-9]{9}";

		if(Pattern.matches(validHotelAvgRSN,userMobileNo )==false)
			throw new HotelManagementException("Enter valid Input");

	}

	public void checkPhoneNo(String userPhone) throws HotelManagementException {

		String validHotelAvgRSN = "[1-9]{1}[0-9]{6}";

		if(Pattern.matches(validHotelAvgRSN,userPhone )==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkAddress(String userAddress) throws HotelManagementException {
		String validHotelAvgRSN = "[A-Za-z ]{1,}";

		if(Pattern.matches(validHotelAvgRSN,userAddress)==false)
			throw new HotelManagementException("Enter valid Input");


	}

	public void checkEmail(String userEmail) {
		// TODO Auto-generated method stub

	}
	@Override
	public RoomDetails getStatus(RoomDetails rumDetails) {

		return hotelDao.getStatus(rumDetails);
	}

	public void checkDate(LocalDate lb,LocalDate la) throws HotelManagementException{
		boolean b = la.isAfter(lb);

		if(b==false)
			throw new HotelManagementException("Date should be after the current date");
	}




}
