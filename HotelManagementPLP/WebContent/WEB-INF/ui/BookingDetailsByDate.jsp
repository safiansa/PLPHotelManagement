<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<font color="Blue"><h2>Booking Details for ${message }</h2></font>
	<c:if test="${list eq null}">
		<h3>No Booking for ${message }!!!</h3>
	</c:if>
	<c:if test="${list ne null}">
		<table border="2">
			<tr>
				<th>bookingId</th>
				<th>hotelId</th>
				<th>roomId</th>
				<th>userId</th>
				<th>bookedFrom</th>
				<th>bookedTo</th>
				<th>noOfAdults</th>
				<th>noOfChildren</th>
				<th>amount</th>

			</tr>
			<c:forEach items="${list}" var="bkDetails">
				<tr>
					<td>${bkDetails.bookingId}</td>
					<td>${bkDetails.hotelId}</td>
					<td>${bkDetails.roomId}</td>
					<td>${bkDetails.userId}</td>
					<td>${bkDetails.bookedFrom}</td>
					<td>${bkDetails.bookedTo}</td>
					<td>${bkDetails.noOfAdults}</td>
					<td>${bkDetails.noOfChildren}</td>
					<td>${bkDetails.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<form action="viewBookingsOnDateSpecified.htm">
		<table border=1>
			<tr>
				<td>Enter Date to Get Booking Details:</td>
				<td><input type="date" name="date" required></td>
			</tr>
			<tr>
				<td colspan=2 align=right><input type="submit"
					value="Get Booking Details"></td>
			</tr>
		</table>
	</form>
	<a href="admin.htm">Continue</a>


</body>
</html>