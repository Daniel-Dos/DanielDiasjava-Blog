<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Pessoas</title>
<link rel="stylesheet" href="../recursos/css/jquery-ui-1.9.2.custom.min.css">
<script src="../recursos/js/jquery-3.1.0.min.js"></script>
<script src="../recursos/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="../recursos/js/datepicker-pt-BR.js"></script>
<script type="text/javascript">
		$(function(){
		  $("#date").datepicker({
		      showOn:"button",
			  buttonImage:"../recursos/imagem/calendar.gif",
			  buttonImageOnly:true
		   });
		});
		</script>

</head>
<body>

<form  action="inserirPessoa" method="post">

<fieldset>
   <legend>Dados</legend>

	 Nome: <input type="text" name="nome" /><br /><br />
   Idade: <input type="number" name="idade"/><br /> <br />
   Profissão: <input type="text" name="profissao"/><br /><br />
   Cidade: <input type="text" name="endereco.cidade"/><br /><br />
   Bairro: <input type="text" name="endereco.bairro"/><br /><br />
   Estado: <input type="text" name="endereco.estado"/><br /><br/>
   Data de Nascimento: <input id="date" type="text" name="dataNascimento" placeholder="dd/mm/yyyy"/><br /><br />
   JUGS:<input type="checkbox" name="jugs" value="SouJava"/>SouJava
   <input type="checkbox" name="jugs" value="RioJug"/>RioJug
   <input type="checkbox" name="jugs" value="SouJava Campinas"/>SouJava Campinas<br /><br />
   
   <input type="submit" value="Cadastrar Dados."/>
   
</fieldset>
  </form>

</body>
</html>