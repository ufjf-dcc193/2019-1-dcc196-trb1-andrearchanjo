<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Trabalho 01</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
    <div class="ui container form">
    
        <h1>Trabalho 01</h1>

        <div class="form-row">
            <div class="form-group col-md-3">
                    <a href="formnovasede.html">Nova Sede</a>    
            </div>
            <div class="form-group col-md-3">         
                <a href="novaatividade.html">Nova Atividade</a>  
            </div>
            <div class="form-group col-md-3">
                <a href="novomembro.html">Novo Membro</a>
            </div>           
        </div>
    
        <div class="form-group"> 

        <h2>Lista de Sedes: </h2>
            <ul style="list-style: none;" class="form-control" id="sede" name="sede">      
                <c:forEach var="sede" items="${sedes}">         
                    <li value="${sede.id}">  <a href="deletasede.html?id=${sede.id}"> X 
                    </a> <a href="visualizasede.html?id=${sede.id}"> ${sede.nome} </a>    
                </c:forEach>   
            </ul>      
        </div>

    
        

    </div>

</body>
</html>