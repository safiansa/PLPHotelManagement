package com.cg.hm.testing;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hm.dao.HotelDaoImpl;
import com.cg.hm.dao.IHotelDao;
import com.cg.hm.dto.Hotels;

public class Testing {
	
	IHotelDao iHotelDao;
	
	@Before
	public void setUp() throws Exception {
		iHotelDao= new HotelDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void addNewHotelTest() {
		
		Hotels hotel = new Hotels(600,"Pune","Hayat","b-67","Great",300,"7891485069","8560914659",3,"7894","king@gmail.com");

		assertTrue(iHotelDao.addHotel(hotel));
		//assertEquals(hotel,hotel);
	}

}
