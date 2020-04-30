<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscador</title>
</head>

<form action="EnviarBuscadorServlet">
	<input type="text" name="email" placeholder="Trabajador">
	<input type="text" name="proyectoId" placeholder="Proyecto">
	<input type="submit" value="Buscar" />
</form>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>
<body>
</body>
</html>