<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Trabalho 01</title>
</head>
<body>
    <h1>Trabalho 01</h1>

    <select class="form-control" id="sede" name="sede">
		<c:forEach var="sede" items="${sedes}">
            <option value="${sede.id}">${sede.nome}</option>
        </c:forEach>
    </select>  
    
    <ul style="list-style: none;" class="form-control" id="sede" name="sede">
		<c:forEach var="sede" items="${sedes}">
            <li value="${sede.id}">  <a href=""> X </a> ${sede.nome}</option>
        </c:forEach>
    </ul>   


    <a href="novaatividade.html">Nova Atividade</a><br>
    <a href="novomembro.html">Novo Membro</a><br>
    <a href="novasede.html">Nova Sede</a><br>
</body>
</html>