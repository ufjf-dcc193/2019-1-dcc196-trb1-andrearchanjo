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
    
        <h1>Atividade ${atividade.titulo}</h1>

        <div class="form-row">
            <ul>
                <li>Descrição: ${atividade.descricao}</li>
                <li>Data de início: ${atividade.dataInicio}</li>
                <li>Data de fim: ${atividade.dataFim}</li>
                <li>Duração: ${atividade.duracao}</li>
                <li>Categoria: ${atividade.categoria}</li>
            </ul>           
        </div>

        <br>
        <br>
        <br>
        <br>

        <div class="form-row">
            <div class="form-group col-md-3">
                <a href="visualizasede.html?id=${idSede}">Voltar</a>           
        </div>
    
    </div>
</body>
</html>