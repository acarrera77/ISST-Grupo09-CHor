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


<form action="EnviarInformeServlet" method="post" enctype="multipart/form-data">
	<h2>Subir Informe</h2>
	<input type="text" name="email" placeholder="Trabajador">
	<input type="text" name="mes" placeholder="Mes">
	<input type="text" name="ano" placeholder="Año">
	<input type="file" name="informe"/>
	<button type="submit">Enviar</button>
</form>

<form action="GoBackGestorServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>