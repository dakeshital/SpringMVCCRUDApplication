<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Staff List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="staf" items="${list}">
		<tr>
			<td>${staf.sid}</td>
			<td>${staf.sname}</td>
			<td>${staf.semail}</td>
			<td>${staf.spass}</td>
			<td><a href="editStaff/${staf.sid}">Edit</a></td>
			<td><a href="deleteStaff/${staf.sid}">Delete</a></td>
		</tr>
	</c:forEach>
</table>

