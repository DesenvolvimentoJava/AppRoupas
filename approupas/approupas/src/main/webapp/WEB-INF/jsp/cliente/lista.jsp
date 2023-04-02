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
		<form action="/cliente" method="get">
			<h2>LISTA DE CLIENTES</h2>
				<c:if test="${empty cliente}">
					<h5>Não existem Clientes cadastrados!!!</h5>
				</c:if>
				
				<c:if test="${not empty cliente}">
					<h5>Quantidade de clientes cadastrados: ${cliente.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>Id</th>
							<th>Nome</th>
							<th>CPF</th>
<!-- 							<th>Endereço</th> -->
							<th>E-mail</th>
							<th>Usuario</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="c" items="${cliente}">
								<tr>
									<td>${c.id}</td>
									<td>${c.nome}</td>
									<td>${c.cpf}</td>
<%-- 									<td>${c.endereco}</td> --%>
									<td>${c.email}</td>
									<td>${c.usuario.nome}</td>
									<td><a href="/cliente/${c.id}/excluir">Excluir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			<button type="submit" class="btn btn-primary">Novo</button>
		</form>
			
	</main>
</body>
</html>