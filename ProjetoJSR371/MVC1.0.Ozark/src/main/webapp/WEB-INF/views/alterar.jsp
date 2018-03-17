<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar Dados</title>
</head>
<body>
		<div align="center">
		<form action="../update" method="post">
		<fieldset style="width: 400px">
            <legend>Alteração de Dados</legend>
   
		<input type="text" name="_id" value="${update._id }" hidden="true"><br/><br />
      Nome:<input type="text" name="nome" value="${update.nome }"><br/><br /> 
      Idade: <input type="number" name="idade" value="${update.idade }"/><br /> <br />
      Cidade<input type="text" name="endereco"  value="${update.endereco.estado}"><br /><br/>
      <textarea rows="10" cols="30" name="descricao" disabled="disabled">${update.jugs.get(0).descricao}</textarea>
      <br /><br />
      
      <input type="submit" value="Atualizar">
      </fieldset>
  </form>
  </div>
</body>
</html>