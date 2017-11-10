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

	<c:if test="${list eq null}">
		<h2>No hotel Available</h2>
	</c:if>

	<c:if test="${list ne null}">
		<h3>Delete a Hotel</h3>
		<form action="deleteHotelConfirm.htm" method="post">
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
						<td><input type="hidden" name="hiddenHotelId"
							value="${hotel.hotelId}"></td>
						<td><input type="submit" value="Delete Hotel"
							name="Delete Hotel"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</c:if>

	<c:if test="${hotel ne null }">
		<h2>Do You Want to Delete the Hotel?</h2>
		<form action="deleteHotelImpl.htm" method="post">
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
					<td><input type="hidden" name="hiddenHotelId"
						value="${hotel.hotelId}"></td>

				</tr>
				<tr>
					<td colspan=10 align=right><input type="submit" value="Yes" name="Delete Hotel"></td>
				</tr>
			</table>
		</form>
	</c:if>
	<a href="admin.htm">Continue</a>
</body>
</html>