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
		<form action="/infantil" method="get">
			<h2>LISTA DE ROUPAS INFANTIL</h2>
				<c:if test="${empty infantil}">
					<h5>Não existem roupas infantis cadastradas!!!</h5>
				</c:if>
				
				<c:if test="${not empty infantil}">
					<h5>Quantidade de roupas infantis cadastradas: ${infantil.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>ID</th>
 							<th>CODIGO</th>
 							<th>DESCRIÇÃO</th>
 							<th>VALOR</th> 
  							<th>QUANTIDADE</th>
							<th>CONJUNTO</th>
							<th>NUMERAÇÃO</th>
							<th>COR</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="i" items="${infantil}">
								<tr>
									<td>${i.id}</td>
 									<td>${i.codProd}</td>
 									<td>${i.descricao}</td>
  									<td>${i.valorCusto}</td> 
  									<td>${i.qtdade}</td>
									<td>${i.conjunto}</td>
									<td>${i.numeracao}</td>
									<td>${i.cor}</td>
									<td><a href="/infantil/${i.id}/excluir">Excluir</a></td>
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