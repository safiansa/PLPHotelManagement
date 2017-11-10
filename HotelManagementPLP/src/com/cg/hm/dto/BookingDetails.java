package com.cg.hm.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking_details")
public class BookingDetails {
	
	@Id
	@Column(name="booking_id")
	private String bookingId;
	
	@Column(name="hotel_id")
	private String hotelId;
	
	@Column(name="room_id")
	private String roomId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="booked_from")
	private Date bookedFrom;
	
	@Column(name="booked_to")
	private Date bookedTo;
	
	@Column(name="no_of_adults")
	private int noOfAdults;
	
	@Column(name="no_of_children")
	private int  noOfChildren;
	
	@Column(name="amount")
	private int amount;
	
	public BookingDetails() {
		super();
	}
	public BookingDetails(String bookingId, String hotelId, String roomId,
			String userId, Date bookedFrom, Date bookedTo,
			int noOfAdults, int noOfChildren, int amount) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public Date getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", hotelId="
				+ hotelId + ", roomId=" + roomId + ", userId=" + userId
				+ ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo
				+ ", noOfAdults=" + noOfAdults + ", noOfChildren="
				+ noOfChildren + ", amount=" + amount + "]";
	}

}
