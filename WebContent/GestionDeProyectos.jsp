Integer<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<h2>Gestion de Proyectos</h2>

<h2>Asignar proyecto a empleado:</h2>
<form action="AsignarProyectoServlet">
	<input type="text" name="email" placeholder="Trabajador">
	<input type="text" name="proyectoId" placeholder="Proyecto">
	<button type="submit">Asignar</button>
</form>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>