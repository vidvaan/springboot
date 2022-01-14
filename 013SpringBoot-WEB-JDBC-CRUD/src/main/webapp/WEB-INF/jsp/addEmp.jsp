<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Add Employee</h1>
	<hr>
	
	
	<form:form action="./saveEmp" method="post" modelAttribute="employee">
       <%--  <div>
	         <form:errors path="*" class="error"></form:errors>
	     </div> --%>
		<table>
			<tr>
				<td>Ename</td>
				<td><form:input type="text" name="ename" path="ename"></form:input></td>
				<td><form:errors path="ename" class="error"></form:errors></td>
			</tr>
			<tr>
				<td>Esal</td>
				<td><form:input type="text" name="esal" path="esal"></form:input></td>
				<td><form:errors path="esal" class="error"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><input type="reset"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>