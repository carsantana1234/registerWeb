<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de busqueda</title>

</head>
<body>
	

	
	<table>

		<c:forEach var="registro" items="${registrosLista}">

			<tr>
				<td>${registro.id}</td>
				<td>${registro.name}</td>
				<td><a href="${pageContext.request.contextPath}/register/edit/${registro.id}">Edit</a></td>
				<td><a href="${pageContext.request.contextPath}/register/delete/${registro.id}">Delete</a></td>
			</tr>

		</c:forEach>
			<tr>
			
				<td colspan="4"><a href="${pageContext.request.contextPath}/register/create">New</a></td>
				
			</tr>
	</table>

</body>
</html>