
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Staff Details</title>
<meta charset="UTF-8">
</head>
<body>
	<h2>Edit Staff Details</h2>
	<form action="${pageContext.request.contextPath}/update" method="post">
		<input type="hidden" name="sid" value="${staff.sid}"> <input
			type="text" name="sname" value="${staff.sname}"><br> <input
			type="text" name="semail" value="${staff.semail}"><br> <input
			type="text" name="spass" value="${staff.spass}"><br> <input
			type="submit" value="Update">
	</form>
</body>
</html>
