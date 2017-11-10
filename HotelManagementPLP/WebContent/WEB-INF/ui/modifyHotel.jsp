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
		<h2>No Hotel Available to Modify</h2>
	</d:if>
	<d:if test="${list ne null}">
		<h3>Modify a Hotel</h3>
		<form action="modifyHotel.htm" method="post">
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
					<th>email</th>
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
						<td>${hotel.email}</td>
						<td><input type="hidden" name="hotelId"
							value="${hotel.hotelId}"></td>
						<td><input type="submit" value="Modify Hotel"
							name="Modify Hotel"></td>
					</tr>
				</d:forEach>
			</table>
		</form>
	</d:if>

	<d:if test="${hotelId ne 0 }">
		<c:form action="modifyHotelImpl.htm" modelAttribute="hotel"
			method="post">
			<h3>Hotel info is as follows::</h3>
			<table border="2">
				<tr>
					<td><c:label path="hotelId">Enter Hotel Id:</c:label></td>
					<td><input name="hotelId" value="${hotelId}" readonly></td>
				</tr>

				<tr>
					<td><c:label path="city">Enter City:</c:label></td>
					<td><input name="city" value="${hotel.city}" pattern="[A-Za-z ]{1,}" required></td>
				</tr>

				<tr>
					<td><c:label path="hotelName">Enter Hotel Name:</c:label></td>
					<td><input name="hotelName"
							value="${hotel.hotelName}" pattern="[A-Za-z ]{1,}" required></td>
				</tr>

				<tr>
					<td><c:label path="address">Enter Address:</c:label></td>
					<td><input name="address" 
							value="${hotel.address}" pattern="[A-Za-z ]{1,}" required></td>
				</tr>
				<tr>
					<td><c:label path="description">Enter Description of Hotel:</c:label></td>
					<td><input name="description" 
							value="${hotel.description}" pattern="[A-Za-z ]{1,}" required></td>
				</tr>


				<tr>
					<td><c:label path="avgRatePerNight">Enter Averate Rate Per Night for the Hotel:</c:label></td>
					<td><input name="avgRatePerNight"
							value="${hotel.avgRatePerNight}" pattern="[1-9]{1}[0-9]{1,}" required></td>
				</tr>

				<tr>
					<td><c:label path="phone1">Enter Contact Number:</c:label></td>
					<td><input name="phone1" 
							value="${hotel.phone1}" pattern="[1-9]{1}[0-9]{9}" required></td>
				</tr>
				<tr>
					<td><c:label path="phone2">Enter Contact Number 2:</c:label></td>
					<td><input name="phone2"
							value="${hotel.phone2}" pattern="[1-9]{1}[0-9]{9}" required></td>
				</tr>
				<tr>
					<td><c:label path="rating">Enter Rating Out of 5:</c:label></td>
					<td><input name="rating" 
							value="${hotel.rating}" pattern="[1-5]{1}" required></td>
				</tr>

				<tr>
					<td><c:label path="fax">Enter Fax:</c:label></td>
					<td><input name="fax" value="${hotel.fax}" pattern="[0-9]{1,}" required></td>
				</tr>
				<tr>
					<td><c:label path="email">Enter Email:</c:label></td>
					<td><input name="email" value="${hotel.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required
							></td>
				</tr>
				<tr><td colspan=2 align=right>
				<input type="submit" value="update" name="update">
			</td></tr>
			</table>
			
		</c:form>

	</d:if>
	<a href="admin.htm">Continue</a>
</body>
</html>