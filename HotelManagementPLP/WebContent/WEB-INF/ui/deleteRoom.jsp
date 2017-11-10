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
		<h2>No Room Available</h2>
	</c:if>

	<c:if test="${list ne null}">
		<h3>Delete a room</h3>
		<form action="deleteRoomConfirm.htm" method="post">
			<table border="2">
				<tr>
					<th>roomId</th>
					<th>hotelId</th>
					<th>roomNo</th>
					<th>roomType</th>
					<th>perNightRate</th>
					<th>availability</th>
				</tr>
				<c:forEach items="${list}" var="room">

					<tr>
						<td>${room.roomId}</td>
						<td>${room.hotelId}</td>
						<td>${room.roomNo}</td>
						<td>${room.roomType}</td>
						<td>${room.perNightRate}</td>
						<td>${room.availability}</td>
						<td><input type="hidden" name="hiddenRoomId"
							value="${room.roomId}"></td>
						<td><input type="submit" value="Delete room"
							name="Delete room"></td>
					</tr>

				</c:forEach>
			</table>
		</form>
	</c:if>

	<c:if test="${room ne null }">
		<h2>Do you want to delete the room?</h2>
		<form action="deleteRoomImpl.htm" method="post">
			<table border="2">
				<tr>
					<th>roomId</th>
					<th>hotelId</th>
					<th>roomNo</th>
					<th>roomType</th>
					<th>perNightRate</th>
					<th>availability</th>
				</tr>
				<tr>
					<td>${room.roomId}</td>
					<td>${room.hotelId}</td>
					<td>${room.roomNo}</td>
					<td>${room.roomType}</td>
					<td>${room.perNightRate}</td>
					<td>${room.availability}</td>
					<td><input type="hidden" name="hiddenRoomId"
						value="${room.roomId}"></td>
				</tr>
				<tr>
				<td colspan=6 align=right><input type="submit" value="Yes"
						name="Delete room"></td>
				</tr>
			</table>
		</form>

	</c:if>

	<a href="admin.htm">Continue</a>
</body>
</html>