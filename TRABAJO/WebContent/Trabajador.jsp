<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Control Horario</title>
</head>
<body>
<h2>Trabajador</h2>

<form action="HoraEntradaServlet">
	<button type="submit">Hora de Entrada</button>
</form>

<form action="DescansosServlet">
	<button type="submit">Descansos</button>
</form>

<form action="HoraSalidaServlet">
	<button type="submit">Hora de Salida</button>
</form>

<form action="LogoutServlet">
	<button type="submit">Log out</button>
</form>

</body>
</html>