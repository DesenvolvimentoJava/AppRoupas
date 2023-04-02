<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppRoupas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	<main class="container mt-5 d-flex flex-column align-items-center">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${mensagem}
			</div>
		</c:if>
		
		<h2>LISTA DE USUÁRIOS</h2>
			<c:if test="${empty usuarios}">
				<h5>Não existem usuarios cadastrados!!!</h5>
			</c:if>
			
			<c:if test="${not empty usuarios}">
				<h5>Quantidade de usuários cadastrados: ${usuarios.size()} !!!</h5>

				<table class="table table-striped container">
					<thead>
						<th>Id</th>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>E-mail</th>
						<th>Senha</th>
						<th>Telefone</th>
						<th>Tipo</th>
						<th>Admin</th>
						<th>Endereço</th>
						<th>Clientes</th>
						<th>Roupas</th>
						<th>Compras</th>
						<c:if test="${usuario.admin}">
							<th></th>
						</c:if>
					</thead>
					<tbody>
						<c:forEach var="u" items="${usuarios}">
							<tr>
								<td>${u.id}</td>
								<td>${u.nome}</td>
								<td>${u.sobrenome}</td>
								<td>${u.email}</td>
								<td>${u.senha}</td>
								<td>${u.tel}</td>
								<td><c:if test="${u.tipo == '1'}">Fornecedor</c:if> <c:if
										test="${u.tipo == '2'}">Funcionario</c:if> <c:if 
										test="${u.tipo == '3'}">Cliente</c:if></td>
								<td>${u.admin}</td>
								<td>${u.endereco}</td>
								<td>${u.clientes.size()}</td>
								<td>${u.roupas.size()}</td>
								<td>${u.compras.size()}</td>
								<c:if test="${usuario.admin}">
									<td><a href="/usuario/${u.id}/excluir">Excluir</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
	</main>
</body>
</html>