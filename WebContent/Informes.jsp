<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informes</title>
</head>
<body>

<form action="SubirInformeServlet">
	<button type="submit">Subir Informe</button>
</form>

<form action="DescargarInformeServlet">
	<button type="submit">Descargar Informe</button>
</form>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>