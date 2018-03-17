<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Pessoas</title>
</head>
<body>
<form  action="../alterar" method="post">

<fieldset>
   <legend>Alteração de Dados</legend>

	Nome: <input type="text" name="nome" value="${atualizar.nome}"/><br /><br />
    Idade: <input type="number" name="idade" value="${atualizar.idade}"/><br /> <br />
    Profissão: <input type="text" name="profissao" value="${atualizar.profissao}"/><br /><br />
    Cidade: <input type="text" name="endereco.cidade" value="${atualizar.endereco.cidade}"/><br /><br />
    Bairro: <input type="text" name="endereco.bairro" value="${atualizar.endereco.bairro}"/><br /><br />
    Estado: <input type="text" name="endereco.estado" value="${atualizar.endereco.estado}"/><br /><br/>
    
              <input type="submit" value="Alterar Dados."/>
   
</fieldset>
  </form>
</body>
</html>