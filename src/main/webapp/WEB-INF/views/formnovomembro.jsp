<%@page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Formulário: Novo Membro</title>

    <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <script>   
        $(document).ready(function () { 
            var dataEntrada = $('#dataEntrada');
            dataEntrada.mask('00/00/0000');

            var dataSaida = $('#dataSaida');
            dataSaida.mask('00/00/0000');

            document.getElementById("idSede").value = "${idSede}";

            alert(document.getElementById("idSede").value);

            $('form').submit(function() {
                if (!$("#nome").val() || !$("#funcao").val() || !$("#email").val() || 
                !$("#dataEntrada").val() || !$("#dataSaida").val()) {
                    alert('Preencha todos os campos!');
                    return false;
                }
            });
        });
    </script>
    
    <div class="ui container form">
        <h1>Formulário: Novo Membro</h1>
        <form role="form" action="novomembro.html" method="POST">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Nome </label>
                    <input class="form-control" type="text" id="nome" name="nome"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Função </label> 
                    <input class="form-control" type="text" id="funcao" name="funcao"/>
                </div>
                <div class="form-group col-md-4">
                    <label>E-mail </label>
                    <input class="form-control" type="text" id="email" name="email"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Data de Entrada </label>
                    <input class="form-control" type="text" id="dataEntrada" name="dataEntrada"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Data de Saída </label>
                    <input class="form-control" type="text" id="dataSaida" name="dataSaida"/>
                </div>
            </div>
            <input class="form-control" type="hidden" id="idSede" name="idSede"/>
            <input class="form-control" type="submit"/>
        </form>
    </div>
</body>
</html>