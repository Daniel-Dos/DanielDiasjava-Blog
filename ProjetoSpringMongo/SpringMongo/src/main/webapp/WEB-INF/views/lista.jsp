<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Pessoas</title>
</head>
<body>
		<h1 align="center">Listagem dos Dados</h1>
<a href="inserirPessoa.html">Adicionar</a>
		<table align="center" border="4">
		<tr bgcolor="gray">
		    <th>ID</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Profissão</th>
			<!--  <th>Endere�o</th>-->
			<th>Cidade</th>
			<th>Bairro</th>
			<th>Estado</th>
			<th>Jugs</th>
			<th>Data</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<c:forEach items="${listas}" var="pessoas">
			<tr>
				<td>${pessoas._id}</td>
				<td>${pessoas.nome}</td>
				<td>${pessoas.idade}</td>
				<td>${pessoas.profissao}</td>
				<!--  <td>${tarefa.Endereco}</td>-->
				<td>${pessoas.endereco.cidade}</td>
				<td>${pessoas.endereco.bairro}</td>
				<td>${pessoas.endereco.estado}</td>
				<td>${pessoas.jugs.get(0).nome}</td>
				<td>
				<fmt:formatDate value="${pessoas.nascimento}" pattern="dd/MM/yyyy"/>
				</td>
				<td><a href="alterarPessoa.html/${pessoas._id }">Alterar</a></td>
				<td><a href="remover/${pessoas._id}">Excluir</a></td>
				
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>