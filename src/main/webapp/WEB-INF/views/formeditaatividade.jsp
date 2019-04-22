<%@page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Formulário: Edita Atividade</title>

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
            var dataInicio = $('#dataInicio');
            dataInicio.mask('00/00/0000');

            var dataFim = $('#dataFim');
            dataFim.mask('00/00/0000');

            document.getElementById("titulo").value = "${atividade.titulo}";
            document.getElementById("descricao").value = "${atividade.descricao}";
            document.getElementById("dataInicio").value = "${atividade.dataInicio}";
            document.getElementById("dataFim").value = "${atividade.dataFim}";
            document.getElementById("duracao").value = "${atividade.duracao}";
            $("#categoria").val("${atividade.categoria}");
            document.getElementById("id").value = "${atividade.id}";


            $('#duracao').bind('keypress', function (e) {
        		return !(e.which != 8 && e.which != 0 &&
                	(e.which < 48 || e.which > 57) && e.which != 46);
    		});

            document.getElementById("idSede").value = "${idSede}";

            $('form').submit(function() {
                if (!$("#titulo").val() || !$("#descricao").val() || 
                !$("#dataInicio").val() || !$("#dataFim").val() || 
                !$("#duracao").val()) {
                    alert('Preencha todos os campos!');
                    return false;
                }
            });
        });
    </script>
    
    <div class="ui container form">
        <h1>Formulário: Edita Atividade</h1>
        <form role="form" action="editaatividade.html" method="POST">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Título </label>
                    <input class="form-control" type="text" id="titulo" name="titulo"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Descrição </label> 
                    <input class="form-control" type="text" id="descricao" name="descricao"/>
                </div>
            </div>
            <div class="form-row">           
                <div class="form-group col-md-4">
                    <label>Data de Início </label>
                    <input class="form-control" type="text" id="dataInicio" name="dataInicio"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Data de Fim </label>
                    <input class="form-control" type="text" id="dataFim" name="dataFim"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Duração </label>
                    <input class="form-control" type="text" id="duracao" name="duracao"/>
                </div>    
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Categoria </label>
                    <select class="form-control" type="text" id="categoria" name="categoria">
                        <option value="JURIDICO">Jurídico </option>
                        <option value="ASSISTENCIAL">Assistencial </option>
                        <option value="FINANCEIRA">Financeira </option>
                        <option value="EXECUTIVA">Executiva </option>
                    </select>
                </div>
            </div>
            <input class="form-control" type="hidden" id="id" name="id"/>
            <input class="form-control" type="hidden" id="idSede" name="idSede"/>
            <input class="form-control" type="submit"/>
        </form>

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