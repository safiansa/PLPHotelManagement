package com.cg.hm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel_teaser")
public class HotelTeaser {
	
	@Id
	@Column(name="comm")
	private String comment;

	public HotelTeaser() {
		super();
	}

	public HotelTeaser(String comment) {
		super();
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "HotelTeaser [comment=" + comment + "]";
	}
}
