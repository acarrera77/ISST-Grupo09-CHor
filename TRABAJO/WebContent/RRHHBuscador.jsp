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

<form action="EnviarBuscadorRRHHServlet">
	<input type="text" name="email" placeholder="Trabajador">
	<input type="text" name="ano" placeholder="Ano">
	<input type="submit" value="Buscar" />
</form>

<form action="GoBackRRHHServlet">
	<button type="submit">Go back</button>
</form>
<body>
</body>
</html>