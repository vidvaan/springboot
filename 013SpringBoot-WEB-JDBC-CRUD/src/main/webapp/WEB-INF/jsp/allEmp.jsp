<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Employees</h1>
	<hr>
	<table>
		<tr>
			<th>Eid</th>
			<th>Ename</th>
			<th>Esal</th>
		</tr>

		<c:forEach items="${employees}" var="emp">
			<tr>
				<td><c:out value="${emp.eid}"></c:out></td>
				<td><c:out value="${emp.ename}"></c:out></td>
				<td><c:out value="${emp.esal}"></c:out></td>
				<td><a href='./deleteById?eid=${emp.eid}'>Delete</a></td>
				<td><a href='./updateEmpShow?eid=${emp.eid}'>Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>