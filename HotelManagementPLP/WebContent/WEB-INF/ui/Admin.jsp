<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">

	<h1>Admin Page</h1>
	<h3>
		<font color="green">${message }</font>
	</h3>
	<h3>
		<table border=1>
			<tr>
				<th>Hotel Management</th>
				<th>Room Management</th>
				<th>View Reports</th>
			</tr>
			<tr>
				<td><a href="addHotel.htm">add</a></td>
				<td>
					<a href="addRoom.htm?hotelId=0">add</a>
				</td>
				<td><a href="viewHotels.htm">View List of Hotels</a></td>

			</tr>
			<tr>
				<td><a href="deleteHotel.htm">delete</a></td>
				<td><a href="deleteRoom.htm">delete</a></td>
				<td><a href="viewBookingsOfHotel.htm?hotelId=0">View Booking Details of Specific Hotel </a></td>
			</tr>
			<tr>
				<td><a href="modifyHotel.htm?hotelId=0">update</a></td>
				<td><a href="modifyRoom.htm?roomId=0">update</a></td>
				<td><a href="viewGuestList.htm?hotelId=0">View Guest List of Specific Hotel</a></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><a href="viewBookingsOnDate.htm">View Booking Details for Specified Date</a></td>
			</tr>

		</table>
		<a href="home.htm">Logout</a>
	</h3>
</body>
</html>