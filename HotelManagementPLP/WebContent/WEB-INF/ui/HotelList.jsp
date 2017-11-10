<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">
	<h1>
		<font color="Blue">Hotel List:</font>
	</h1>
	<c:if test="${list eq null}">
		<h2>No Hotel Available</h2>
	</c:if>

	<c:if test="${list ne null}">
		<form action="viewRoom.htm">
			<table border="2">

				<tr>
					<th>hotelId</th>
					<th>city</th>
					<th>hotelName</th>
					<th>address</th>
					<th>description</th>
					<th>avgRatePerNight</th>
					<th>phone1</th>
					<th>phone2</th>
					<th>rating</th>
					<th>fax</th>
				</tr>
				<c:forEach items="${list}" var="hotel">
					<tr>
						<td>${hotel.hotelId}</td>
						<td>${hotel.city}</td>
						<td>${hotel.hotelName}</td>
						<td>${hotel.address}</td>
						<td>${hotel.description}</td>
						<td>${hotel.avgRatePerNight}</td>
						<td>${hotel.phone1}</td>
						<td>${hotel.phone2}</td>
						<td>${hotel.rating}</td>
						<td>${hotel.fax}</td>
						<td><input type="hidden" name="hotelId"
							value="${hotel.hotelId}"></td>
						<td><input type="submit" value="View Rooms" name="View Rooms"></td>

					</tr>
				</c:forEach>

			</table>
		</form>
	</c:if>
	<h2>
		<font color="Blue">${message }</font>
	</h2>
	<br>
	<c:if test="${list2 eq null }">
		<h2>${message2 }</h2>
	</c:if>

	<c:if test="${list2 ne null}">
		<table border="2">
			<tr>
				<th>roomId</th>
				<th>hotelId</th>
				<th>roomNo</th>
				<th>roomType</th>
				<th>perNightRate</th>
				<th>availability</th>
			</tr>
			<c:forEach items="${list2}" var="room">

				<tr>
					<td>${room.roomId}</td>
					<td>${room.hotelId}</td>
					<td>${room.roomNo}</td>
					<td>${room.roomType}</td>
					<td>${room.perNightRate}</td>
					<td>${room.availability}</td>
				</tr>

			</c:forEach>
		</table>
	</c:if>

	<a href="admin.htm">Continue</a>


</body>
</html>