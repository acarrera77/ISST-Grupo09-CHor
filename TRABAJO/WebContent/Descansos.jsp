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

<form action="DescansosServlet">
	<h2>10 Minutos de Descanso</h2>
	<button type="submit">Enviar</button>
</form>

<form action="GoBackServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>