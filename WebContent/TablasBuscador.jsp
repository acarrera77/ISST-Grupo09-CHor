<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h2>Registros</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>HORA ENTRADA</th>
    <th>DESCANSOS</th>
    <th>HORA SALIDA</th>
  </tr>
<c:forEach items="${lr}" var="lri">
<tr>
<td>${lri.id}</td>
<td>${lri.horaEntrada}</td> 
<td>${lri.horaDescanso}</td>
<td>${lri.horaSalida}</td>
</tr>
</c:forEach>
</table>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>