<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir</title>
</head>
<body>
  <div align="center">
 <form action="add" method="post">

<fieldset style="width: 400px">
   <legend>Dados</legend>

	 Nome: <input type="text" name="nome" /><br /><br />
    Idade: <input type="number" name="idade"/><br /> <br />
   Estado: <input type="text" name="endereco"/><br /><br />
   JUGS:<input type="radio" name="jugs" value="SouJava"/>SouJava
   <input type="radio" name="jugs" value="RioJug"/>RioJug
   <input type="radio" name="jugs" value="SouJava Campinas"/>SouJava Campinas<br /><br />
   
   <textarea rows="10" cols="30" name="descricao">Descrição</textarea> 
   <br/><br />
  
   <input type="submit" value="Cadastrar Dados."/>
   
</fieldset>
  </form>
  </div>
</body>
</html>