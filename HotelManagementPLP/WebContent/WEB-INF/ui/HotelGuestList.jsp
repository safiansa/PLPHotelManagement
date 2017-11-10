<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${list eq null}">
		<h2>No Hotel Available to Show Guest List</h2>
	</c:if>

	<c:if test="${list ne null}">
		<h1>
			<font color="Blue">Hotel List:</font>
		</h1>
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
					<td><a href="viewGuestList.htm?hotelId=${hotel.hotelId}">View
							Guest List Of This Hotel</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


	<c:if test="${hotelId ne 0 }">
		<font color="Blue"><h2>Guest Details</h2></font>
		<c:if test="${list2 eq null}">
			<h3>There is no Guest in this Hotel!!!</h3>
		</c:if>

		<c:if test="${list2 ne null}">
			<table border="2">
				<tr>
					<th>userId</th>
					<th>role</th>
					<th>userName</th>
					<th>mobileNo</th>
					<th>phone</th>
					<th>address</th>
					<th>email</th>
				</tr>
				<c:forEach items="${list2}" var="userDetails">
					<tr>
						<td>${userDetails.userId}</td>
						<td>${userDetails.role}</td>
						<td>${userDetails.userName}</td>
						<td>${userDetails.phone}</td>
						<td>${userDetails.address}</td>
						<td>${userDetails.email}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
	<a href="admin.htm">Continue</a>



</body>
</html>