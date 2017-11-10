package com.cg.hm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.hm.dto.Hotels;
import com.cg.hm.dto.RoomDetails;
import com.cg.hm.service.IHotelService;

@Controller
public class HotelController {

	@Autowired
	IHotelService hotelService;

	@RequestMapping("/home.htm")
	public String redirectToHome()
	{
		return "Home";
	}

	@RequestMapping("/admin.htm")
	public String redirectToAdmin()
	{
		return "Admin";
	}

	@RequestMapping("/login.htm")
	public String login()
	{
		return "Login";
	}

	@RequestMapping("/checkLogin.htm")
	public String checkLogin(@RequestParam("id") String id,@RequestParam("password") String password,Model model)
	{
		if("System".equals(id)&&"Capgemini123".equals(password))
			return "Admin";
		else
		{
			model.addAttribute("message","Invalid Id or Password!!!");
			return "Login";
		}
	}

	@RequestMapping("/addHotel.htm")
	public String addHotel(Model model)
	{
		Hotels hotel= new Hotels();
		model.addAttribute("hotel", hotel);
		return "addHotel";
	}

	@RequestMapping(value="/addHotelImpl.htm",method=RequestMethod.POST)
	public String addHotelImpl(@ModelAttribute("hotel") Hotels hotel,Model model,BindingResult result)
	{
		hotelService.addHotel(hotel);
		model.addAttribute("message", "Hotel Added Successfully!!!");
		return "Admin";
	}


	@RequestMapping("/addRoom.htm")
	public String addRoom(@RequestParam("hotelId") int hotelId,Model model,Model model2)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		if(list.isEmpty())
			list=null;
		model2.addAttribute("list", list);
		model2.addAttribute("hotelId", hotelId);
		RoomDetails room=new RoomDetails();
		model.addAttribute("room", room);
		model.addAttribute("roomTypeList", new String[]{"Select","Standard non A/C room","Standard A/C room","Executive A/C room", "Deluxe A/C room"});
		return "addRoom";
	}

	@RequestMapping(value="/addRoomImpl.htm",method=RequestMethod.POST)
	public String addRoomImpl(@ModelAttribute("room") RoomDetails room,Model model,BindingResult result)
	{
		hotelService.addRoom(room);
		model.addAttribute("message", "Room Added Successfully!!!");
		return "Admin";
	}

	@RequestMapping("/viewHotels.htm")
	public String viewHotels(Model model)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		if(list.isEmpty())
			list=null;
		model.addAttribute("list", list);
		return "HotelList";
	}

	@RequestMapping("/viewRoom.htm")
	public String viewRoom(@RequestParam("hotelId") int hotelId,Model model)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		model.addAttribute("list", list);
		String msg=new String("Rooms in Hotel "+hotelId);
		List<RoomDetails> list2=hotelService.getRoomByHotelId(hotelId);
		if(list2.isEmpty())
		{
			list2=null;
			model.addAttribute("message2", "No Room Available in This Hotel");
		}
		model.addAttribute("list2", list2);
		model.addAttribute("message", msg);
		return "HotelList";
	}

	@RequestMapping("/deleteRoom.htm")
	public String deleteRoom(Model model)
	{
		List<RoomDetails> list=hotelService.viewAllRooms();
		if(list.isEmpty())
			list=null;
		model.addAttribute("list", list);
		return "deleteRoom";
	}

	@RequestMapping("/deleteRoomConfirm.htm")
	public String deleteRoomConfirm(@RequestParam("hiddenRoomId") int roomId,Model model,Model model2)
	{
		List<RoomDetails> list=hotelService.viewAllRooms();
		model.addAttribute("list", list);
		RoomDetails room=hotelService.getRoomById(roomId);
		model2.addAttribute("room", room);
		return "deleteRoom";
	}

	@RequestMapping("/deleteRoomImpl.htm")
	public String deleteRoomImpl(@RequestParam("hiddenRoomId") int roomId,Model model)
	{
		hotelService.deleteRoom(roomId);
		model.addAttribute("message", "Room Deleted Successfully!!!");
		return "Admin";
	}

	@RequestMapping("/deleteHotel.htm")
	public String deleteHotel(Model model)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		if(list.isEmpty())
			list=null;
		model.addAttribute("list", list);
		return "deleteHotel";
	}

	@RequestMapping("/deleteHotelConfirm.htm")
	public String deleteHotelConfirm(@RequestParam("hiddenHotelId") int hotelId,Model model,Model model2)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		model.addAttribute("list", list);
		Hotels hotel=hotelService.getHotelById(hotelId);
		model2.addAttribute("hotel", hotel);
		return "deleteHotel";
	}

	@RequestMapping("/deleteHotelImpl.htm")
	public String deleteHotelImpl(@RequestParam("hiddenHotelId") int hotelId,Model model)
	{
		hotelService.deleteHotel(hotelId);
		model.addAttribute("message", "Hotel Deleted Successfully!!!");
		return "Admin";
	}

	@RequestMapping("/modifyHotel.htm")
	public String modifyHotel(@RequestParam("hotelId") int hotelId,Model model)
	{
		List<Hotels> list=hotelService.viewAllHotels();
		Hotels hotel=new Hotels();
		if(hotelId!=0)
			hotel=hotelService.getHotelById(hotelId);
		model.addAttribute("hotel",hotel);
		if(list.isEmpty())
			list=null;
		model.addAttribute("hotelId", hotelId);
		model.addAttribute("list", list);
		return "modifyHotel";
	}

	@RequestMapping(value="/modifyHotelImpl.htm",method=RequestMethod.POST)
	public String modifyHotelImpl(@ModelAttribute("hotel") Hotels hotel,Model model,BindingResult result)
	{
		hotelService.updateHotel(hotel);
		model.addAttribute("message", "Hotel Modified Successfully!!!");
		return "Admin";
	}

	@RequestMapping("/modifyRoom.htm")
	public String modifyRoom(@RequestParam("roomId") int roomId,Model model)
	{
		List<RoomDetails> list=hotelService.viewAllRooms();
		if(list.isEmpty())
			list=null;
		RoomDetails room=new RoomDetails();
		if(roomId!=0)
			room=hotelService.getRoomById(roomId);
		model.addAttribute("room", room);
		model.addAttribute("roomId", roomId);
		model.addAttribute("list", list);
		model.addAttribute("roomTypeList", new String[]{"Select","Standard non A/C room","Standard A/C room","Executive A/C room", "Deluxe A/C room"});

		return "modifyRoom";
	}

	@RequestMapping(value="/modifyRoomImpl.htm",method=RequestMethod.POST)
	public String modifyRoomImpl(@ModelAttribute("room") RoomDetails room,Model model,BindingResult result)
	{
		hotelService.updateRoom(room);
		model.addAttribute("message", "Room Modified Successfully!!!");
		return "Admin";
	}
}
