<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Relatório: Duração Total</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
    <div class="ui container form">
    
        <h1>Relatório: Duração Total</h1>

        <div class="form-row">
            <div class="form-group col-md-3">
                    Duração Total: ${duracaoTotal}
                    <br>
                    Duração Jurídica: ${duracaoJuridica}
                    <br>
                    Duração Assistencial: ${duracaoAssistencial}
                    <br>
                    Duração Financeira: ${duracaoFinanceira}
                    <br>
                    Duração Executiva: ${duracaoExecutiva}
            </div>      
        </div>

        <div class="form-row">
            <div class="form-group col-md-3">
                    <a href="visualizasede.html?id=${id}">Voltar</a>    
            </div>      
        </div>
    
        <div class="form-group"> 

        

    
        

    </div>

</body>
</html>