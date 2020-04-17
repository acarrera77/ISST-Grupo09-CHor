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

<form action="EnviarHoraFinalizacionProyectoServlet">
	<h2>Proyecto</h2>
    <input list="proyectos"> <!-- MIRAR COMO PONERLO -->
    <h2>Final</h2>
	<input type="time" name="hora" placeholder="00:00">
	<button type="submit">Enviar</button>
</form>

<form action="GoBackServlet">
	<button type="submit">Go back</button>
</form>

</body>
</html>

<!-- <form action="">  -->
<!--         <label>Your Cars Name: </label>  -->
<!--         <input list="cars">  -->
<!--         <datalist id="cars">  -->
<!--             <option value="BMW" />  -->
<!--             <option value="Bentley" />  -->
<!--             <option value="Mercedes" />  -->
<!--             <option value="Audi" />  -->
<!--             <option value="Volkswagen" />  -->
<!--         </datalist>  -->
<!--     </form>  -->