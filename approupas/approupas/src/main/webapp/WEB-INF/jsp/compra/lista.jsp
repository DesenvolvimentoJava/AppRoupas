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
		<form action="/compra" method="get">
			<h2>LISTA DE COMPRAS</h2>
				<c:if test="${empty compras}">
					<h5>Não existem compras cadastradas!!!</h5>
				</c:if>
				
				<c:if test="${not empty compras}">
					<h5>Quantidade de compras cadastradas: ${compras.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>ID</th>
 							<th>DESCRIÇÃO</th>
 							<th>VAREJO</th>
 							<th>DATA</th>
							<th>CLIENTE</th>
							<th>ROUPAS</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="co" items="${compras}">
								<tr>
									<td>${co.id}</td>
 									<td>${co.descricao}</td>
 									<td>${co.varejo}</td> 
 									<td>${co.data}</td> 
									<td>${co.cliente.nome}</td>
									<td>${co.roupas.size()}</td>
									<td><a href="/compra/${co.id}/excluir">Excluir</a></td>
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