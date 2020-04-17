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
<h2>Gestor</h2>

<form action="GestionDeProyectosServlet">
	<button type="submit">Gestión de Proyectos</button>
</form>

<form action="BuscadorServlet">
	<button type="submit">Buscador</button>
</form>

<form action="InformesServlet">
	<button type="submit">Informes</button>
</form>

<form action="LogoutServlet">
	<button type="submit">Logout</button>
</form>

</body>
</html>