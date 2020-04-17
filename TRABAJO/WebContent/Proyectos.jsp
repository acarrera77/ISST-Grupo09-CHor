<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyectos</title>
</head>
<body>

<form action="HoraComienzoProyectoServlet">
	<button type="submit">Hora de Comienzo</button>
</form>

<form action="HoraFinalizacionProyectoServlet">
	<button type="submit">Hora de Finalización</button>
</form>

<form action="GoBackServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>