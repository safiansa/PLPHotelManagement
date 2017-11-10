package com.cg.hm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room_details")
public class RoomDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="hotel_id")
	private int hotelId;
	
	@Column(name="room_no")
	private String roomNo;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="per_night_rate")
	private int perNightRate;
	
	@Column(name="availability")
	private String availability;
	

	public RoomDetails() {
		super();
	}
	public RoomDetails(int hotelId, int roomId, String roomNo,
			String roomType, int perNightRate, String availability) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(int perNightRate) {
		this.perNightRate = perNightRate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "roomDetails [hotelId=" + hotelId + ", roomId=" + roomId
				+ ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", availability="
				+ availability + "]";
	}
}

