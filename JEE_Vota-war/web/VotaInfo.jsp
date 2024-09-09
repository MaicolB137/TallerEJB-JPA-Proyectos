<%-- 
    Document   : VotaInfo
    Created on : 9/09/2024, 12:27:34 PM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Information</title>
</head>
<body>
<h1>Project Information</h1>
<form action="./VotaServlet" method="POST">
<table>
<tr>
<td>Proyecto Id</td>
<td><input type="text" name="PROYECTOID" value="${stud.proyectoid}" /></td>
</tr>
<tr>
<td>Nombre Proyecto</td>
<td><input type="text" name="NOMBREPROYECTO" value="${stud.nombreproyecto}" /></td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="DESCRIPCION" value="${stud.descripcion}" /></td>
</tr>
<tr>
<td>Localidad</td>
<td><input type="text" name="LOCALIDAD" value="${stud.localidad}" /></td>
</tr>
<tr>
<td>Presupuesto</td>
<td><input type="text" name="presupuesto" value="${stud.presupuesto}" /></td>
</tr>
<tr>
<td>Num Habitantes</td>
<td><input type="text" name="NUMEROHABITANTES" value="${stud.numerohabitantes}" /></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" name="action" value="Add" />
<input type="submit" name="action" value="Edit" />
<input type="submit" name="action" value="Delete" />
<input type="submit" name="action" value="Search" />
</td>
</tr>
</table>
</form>
<br>
<table border="1">
<th>ID</th>
<th>Project Name</th>
<th>Description</th>
<th>Location</th>
<th>Budget</th>
<th>Population</th>
<c:forEach items="${allStudents}" var="stud">
<tr>
<td>${stud.proyectoid}</td>
<td>${stud.nombreproyecto}</td>
<td>${stud.descripcion}</td>
<td>${stud.localidad}</td>
<td>${stud.presupuesto}</td>
<td>${stud.numerohabitantes}</td>
</tr>
</c:forEach> 
</table>
</body>
</html>
