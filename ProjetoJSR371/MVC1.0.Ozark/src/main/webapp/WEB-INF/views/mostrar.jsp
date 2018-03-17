<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostrar</title>
</head>
<body>

<h1 align="center">Listagem dos Dados</h1>

<a href="novo">Adicionar</a>

		<table align="center" border="4">
		<tr bgcolor="gray">
		    <th>ID</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Estado</th>
			<th>JUGS</th>
			<th>Descrição</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<c:forEach items="${listar}" var="pessoas">
			<tr>
				<td>${pessoas._id}</td>
				<td>${pessoas.nome}</td>
				<td>${pessoas.idade}</td>
				<td>${pessoas.endereco.estado}</td>
				<td>${pessoas.jugs.get(0).nome}</td>
				<td>
				<textarea rows="10" cols="60" name="descricao" disabled="disabled"> ${pessoas.jugs.get(0).descricao} </textarea>
				</td>
				<td><a href="atualizar/${pessoas._id }">Alterar</a></td>
				<td><a href="remover/${pessoas._id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>

     
       
</body>
</html>