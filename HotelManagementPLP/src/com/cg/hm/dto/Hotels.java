package com.cg.hm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotels {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hotel_id")
	private int hotelId;

	@Column(name="city")
	private String city;

	@Column(name="hotel_name")
	private String hotelName;

	@Column(name="address")
	private String address;

	@Column(name="description")
	private String description;

	@Column(name="avg_rate_per_night")
	private int  avgRatePerNight;

	@Column(name="phone_no1")
	private String phone1;

	@Column(name="phone_no2")
	private String phone2;

	@Column(name="rating")
	private int rating;

	@Column(name="fax")
	private String fax;

	@Column(name="email")
	private String email;



	public Hotels() {
		super();
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Hotels [hotelId=" + hotelId + ", city=" + city + ", hotelName="
				+ hotelName + ", address=" + address + ", description="
				+ description + ", avgRatePerNight=" + avgRatePerNight
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", rating="
				+ rating + ", fax=" + fax + ", email=" + email + "]";
	}



	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvgRatePerNight() {
		return avgRatePerNight;
	}
	public void setAvgRatePerNight(int avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

}

