<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Sede ${sede.nome}</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
    <div class="ui container form">
    
        <h1>Sede ${sede.nome}</h1>

        <div class="form-row">
            <ul>
                <li>${sede.estado}</li>
                <li>${sede.cidade}</li>
                <li>${sede.bairro}</li>
                <li>${sede.telefone}</li>
                <li>${sede.enderecoWeb}</li>
            </ul>           
        </div>

        <div class="form-row">
            <form role="form" action="formeditasede.html?id=${sede.id}" method="POST">
                <input class="form-control" type="submit" value="Editar"/>
            </form>
        </div>

        <div class="form-row">
                <h2>Lista de Membros: </h2>
                <ul style="list-style: none;" class="form-control" id="membro" name="membro">      
                    <c:forEach var="membro" items="${sede.membros}">         
                        <li value="${membro.id}">  ${membro.nome}
                    </c:forEach>   
                </ul>      
            </div>
            <div class="form-group col-md-3">
                <a href="formnovomembro.html?idSede=${sede.id}">Novo Membro</a>
            </div> 

        </div>

    </div>

</body>
</html>