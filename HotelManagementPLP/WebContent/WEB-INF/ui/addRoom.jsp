<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">
	<d:if test="${list eq null}">
		<h2>No Hotel Available to Add a Room</h2>
	</d:if>

	<d:if test="${list ne null}">
		<h3>In Which Hotel Do You Want to Add a Room?</h3>
		<form action="addRoom.htm" method="post">
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
				<d:forEach items="${list}" var="hotel">
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
						<td><input type="submit" value="Add Room" name="Add Room"></td>
					</tr>
				</d:forEach>
			</table>
		</form>
	</d:if>

	<d:if test="${hotelId ne 0 }">
		<h1>Add Rooms</h1>
		<c:form action="addRoomImpl.htm" modelAttribute="room" method="post">
			<div align="center">
				<table>

					<tr>
						<td><c:label path="hotelId">Enter HotelId:</c:label></td>
						<td><input name="hotelId" value="${hotelId}" readonly></td>
					</tr>
					<tr>
						<td><c:label path="roomNo">Enter Room No:</c:label></td>
						<td><c:input path="roomNo" pattern="[1-9]{1}[0-9]{1,}"
								required="required"></c:input></td>
					</tr>
					<tr>
						<td><c:label path="roomType">Room Type</c:label></td>
						<td><c:select path="roomType">
								<c:options items="${roomTypeList}" />
							</c:select></td>
					</tr>
					<tr>
						<td><c:label path="perNightRate">Enter  Per Night Rate for the Room:</c:label></td>
						<td><c:input path="perNightRate" pattern="[1-9]{1}[0-9]{1,}"
								required="required"></c:input></td>
					</tr>

					<tr>
						<td><c:label path="availability">Availability:</c:label></td>
						<td><c:input path="availability" pattern="[A-Za-z]{1,}"
								placeholder="YES/NO" required="required"></c:input></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button type="submit">Save</button></td>
					</tr>
				</table>
			</div>
		</c:form>
	</d:if>
	<a href="home.htm">Logout</a>


</body>
</html>