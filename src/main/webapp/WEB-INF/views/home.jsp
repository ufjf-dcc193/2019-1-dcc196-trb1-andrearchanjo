<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Trabalho 01</title>
</head>
<body>
    <ol>
        <c:forEach var="sede" items="${sedes}">
            <li value="${sede.id}">${sede.nome}</li>   
        </c:forEach>
    </ol>
            


    <a href="novaatividade.html">Nova Atividade</a><br>
    <a href="novomembro.html">Novo Membro</a><br>
    <a href="novasede.html">Nova Sede</a><br>
</body>
</html>