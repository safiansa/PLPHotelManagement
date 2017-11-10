<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF0">

	<a:if test="${list eq null}">
		<h2>No Room Available to Modify</h2>
	</a:if>
	

	<a:if test="${list ne null}">
		<h3>Modify a Room</h3>
		<form action="modifyRoom.htm" method="post">
			<table border="2">
				<tr>
					<th>roomId</th>
					<th>hotelId</th>
					<th>roomNo</th>
					<th>roomType</th>
					<th>perNightRate</th>
					<th>availability</th>
				</tr>
				<a:forEach items="${list}" var="room">

					<tr>
						<td>${room.roomId}</td>
						<td>${room.hotelId}</td>
						<td>${room.roomNo}</td>
						<td>${room.roomType}</td>
						<td>${room.perNightRate}</td>
						<td>${room.availability}</td>
						<td><input type="hidden" name="roomId"
							value="${room.roomId}"></td>
						<td><input type="submit" value="Modify Room"
							name="Modify Room"></td>
					</tr>
				</a:forEach>
			</table>
		</form>
	</a:if>

	
	<a:if test="${roomId ne 0}">
		<c:form action="modifyRoomImpl.htm" modelAttribute="room"
			method="post">
			<h3>Hotel info is as follows::</h3>
			<table border="2">
				<tr>
					<td><c:label path="roomId">Enter Room Id:</c:label></td>
					<td><input name="roomId" value="${room.roomId}"
							 readonly></td>
				</tr>

				<tr>
					<td><c:label path="hotelId">Enter Hotel Id:</c:label></td>
					<td><input name="hotelId" value="${room.hotelId}"
							 readonly></td>
				</tr>

				<tr>
					<td><c:label path="roomNo">Enter Room No:</c:label></td>
					<td><input name="roomNo" pattern="[1-9]{1}[0-9]{1,}"
							value="${room.roomNo}" required></td>
				</tr>

				<!-- Here you will get the values of roomtype list from controller in list -->
				<tr>
					<td><c:label path="roomType">Room Type</c:label></td>
					<td><c:select path="roomType" value="${room.roomType}">
							<c:options items="${roomTypeList}" />
						</c:select></td>
				</tr>
				<tr>
					<td><c:label path="perNightRate">Enter Description of Hotel:</c:label></td>
					<td><input name="perNightRate" pattern="[1-9]{1}[0-9]{1,}"
							value="${room.perNightRate}" required></td>
				</tr>


				<tr>
					<td><c:label path="availability">Enter Availability:</c:label></td>
					<td><input name="availability" value="${room.availability}"
							pattern="[A-Za-z]{1,4}" required></td>
				</tr>
				<tr>
					<td colspan=2 align=right><input type="submit" value="update" name="update">
					</td>
				</tr>

			</table>

		</c:form>
	</a:if>
<a href="admin.htm">Continue</a>
</body>
</html>