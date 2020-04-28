<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar Informe</title>
</head>

<form action="BuscadorInformeServlet">
	<input type="text" name="email" placeholder="Trabajador">
	<input type="text" name="mes" placeholder="Mes">
	<input type="text" name="ano" placeholder="Ano">
	<input type="submit" value="Descargar" />
</form>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>
<body>
</body>
</html>