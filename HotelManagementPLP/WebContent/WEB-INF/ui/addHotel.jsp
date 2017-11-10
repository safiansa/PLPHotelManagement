<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">

	<h1>Add Hotel</h1>
	<c:form action="addHotelImpl.htm" modelAttribute="hotel" method="post">
		<div align="center">
			<table>
				<tr>
					<td><c:label path="city">Enter City:</c:label></td>
					<td><c:input path="city" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern " required="required"></c:input></td>
				</tr>
				<tr>
					<td><c:label path="hotelName">Enter Hotel Name:</c:label></td>
					<td><c:input path="hotelName" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern ex:tajHotel" required="required"></c:input></td>
				</tr>
				<tr>
					<td><c:label path="address">Enter Address:</c:label></td>
					<td><c:input path="address" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern ex:pune" required="required"></c:input></td>
				</tr>
				<tr>
					<td><c:label path="description">Enter Description of Hotel:</c:label></td>
					<td><c:input path="description" pattern="[A-Za-z ]{1,}"
							title="Enter valid Pattern ex:AC" required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="avgRatePerNight">Enter Averate Rate Per Night for the Hotel:</c:label></td>
					<td><c:input path="avgRatePerNight"
							pattern="[1-9]{1}[0-9]{1,}" required="required"
							title="It should be a number"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="phone1">Enter Contact Number:</c:label></td>
					<td><c:input path="phone1" pattern="[1-9]{1}[0-9]{9}"
							title="Phone no. must be 10 digits" required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="phone2">Enter Contact Number 2:</c:label></td>
					<td><c:input path="phone2" pattern="[1-9]{1}[0-9]{9}"
							title="Phone no. must be 10 digits" required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="rating">Enter Rating Out of 5:</c:label></td>
					<td><c:input path="rating" pattern="[1-5]{1}"
							title="Enter in the range of 1-5" required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="fax">Enter Fax:</c:label></td>
					<td><c:input path="fax" required="required"></c:input></td>
				</tr>

				<tr>
					<td><c:label path="email">Enter Email:</c:label></td>
					<td><c:input path="email"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							title="Enter valid Email Ex:abc@gmail.com" required="required"></c:input></td>
				</tr>

				<tr>
					<td colspan="2" align="right"><button type="submit">Save</button></td>
				</tr>
			</table>
		</div>
	</c:form>
	<a href="home.htm">Logout</a>

</body>
</html>