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
                <li>Estado: ${sede.estado}</li>
                <li>Cidade: ${sede.cidade}</li>
                <li>Bairro: ${sede.bairro}</li>
                <li>Telefone: ${sede.telefone}</li>
                <li>Endereço Web: ${sede.enderecoWeb}</li>
            </ul>           
        </div>

        <div class="form-row">
            <form role="form" action="formeditasede.html?id=${sede.id}" method="POST">
                <input class="form-control" type="submit" value="Editar"/>
            </form>
        </div>

        <br>
        <br>

        <div class="form-row">
            <div class="form-group col-md-6">
                <h2>Lista de Membros </h2>
                <ul style="list-style: none;" class="form-control" id="membro" name="membro">      
                    <c:forEach var="membro" items="${sede.membros}">         
                        <li value="${membro.id}"> <a href="deletamembro.html?id=${membro.id}&idSede=${sede.id}"> X 
                        </a> <a href="vermembro.html?id=${membro.id}&idSede=${sede.id}"> &#9634; </a>
                        <a href="formeditamembro.html?id=${membro.id}&idSede=${sede.id}">${membro.nome}</a> 
                    </c:forEach>   
                </ul>      
            </div>

            <div class="form-group col-md-6">
                <h2>Lista de Atividades </h2>
                <ul style="list-style: none;" class="form-control" id="atividade" name="atividade">      
                    <c:forEach var="atividade" items="${sede.atividades}">         
                        <li value="${atividade.id}"> <a href="deletaatividade.html?id=${atividade.id}&idSede=${sede.id}"> X 
                        </a> <a href="veratividade.html?id=${atividade.id}&idSede=${sede.id}"> &#9634; </a> 
                        <a href="formeditaatividade.html?id=${atividade.id}&idSede=${sede.id}">${atividade.titulo}</a>
                    </c:forEach>   
                </ul>      
            </div>

            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <a href="formnovomembro.html?idSede=${sede.id}">Novo Membro</a>
            </div> 
            <div class="form-group col-md-6">
                <a href="formnovaatividade.html?idSede=${sede.id}">Nova Atividade</a>
            </div> 
        </div>
        
        <div class="form-row">
            <div class="form-group col-md-6">
                <a href="index.html">Voltar</a> 
            </div>
            <div class="form-group col-md-6">
                <a href="relatorioduracaototal.html?id=${sede.id}">Relatório</a>
            </div>           
        </div>

    </div>

</body>
</html>