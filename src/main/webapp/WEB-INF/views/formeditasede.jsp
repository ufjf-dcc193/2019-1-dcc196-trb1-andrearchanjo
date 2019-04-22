<%@page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Formulário: Editar Sede</title>
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
            var telefone = $('#telefone');
            telefone.mask('0000-0000');

            document.getElementById("nome").value = "${sede.nome}";
            document.getElementById("estado").value = "${sede.estado}";
            document.getElementById("cidade").value = "${sede.cidade}";
            document.getElementById("bairro").value = "${sede.bairro}";
            document.getElementById("telefone").value = "${sede.telefone}";
            document.getElementById("enderecoWeb").value = "${sede.enderecoWeb}";
            document.getElementById("id").value = "${sede.id}";

            //alert(document.getElementById("id").value);

            $('form').submit(function() {
                if (!$("#nome").val() || !$("#estado").val() || 
                !$("#cidade").val() || !$("#bairro").val() || 
                !$("#telefone").val() || !$("#enderecoWeb").val()) {
                    alert('Preencha todos os campos!');
                    return false;
                }
            });
        });
    </script>
    
    <div class="ui container form">
        <h1>Formulário: Edita Sede</h1>
        <form role="form" action="editasede.html" method="POST">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Nome </label>
                    <input class="form-control" type="text" id="nome" name="nome"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Estado </label> 
                    <input class="form-control" type="text" id="estado" name="estado"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Cidade </label>
                    <input class="form-control" type="text" id="cidade" name="cidade"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Bairro </label>
                    <input class="form-control" type="text" id="bairro" name="bairro"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label>Telefone </label>
                    <input class="form-control" type="text" id="telefone" name="telefone"/>
                </div>
                <div class="form-group col-md-4">
                    <label>Endereço Web </label>
                    <input class="form-control" type="text" id="enderecoWeb" name="enderecoWeb"/>
                </div>
            </div>
            <input class="form-control" type="hidden" id="id" name="id"/>
            <input class="form-control" type="submit" value="Confirmar"/>
        </form>

        <br>
        <br>
        <br>
        <br>

        <div class="form-row">
            <div class="form-group col-md-6">
                <a href="visualizasede.html?id=${sede.id}">Voltar</a> 
            </div>
        <div>

    </div>
</body>
</html>