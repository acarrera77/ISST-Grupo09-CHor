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

<form action="EnviarHoraEntradaServlet">
	<h2>Hora de Entrada</h2>
	<input type="text" name="proyectoId" placeholder="Proyecto ID">
	<button type="submit" name="horaEntrada">Enviar</button>
</form>

<form action="GoBackServlet">
	<button type="submit">Go back</button>
</form>


</body>
</html>