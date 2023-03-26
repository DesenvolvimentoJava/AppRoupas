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
		<form action="/masculina" method="get">
			<h2>LISTA DE ROUPAS MASCULINA</h2>
				<c:if test="${empty masculina}">
					<h5>Não existem roupas masculinas cadastradas!!!</h5>
				</c:if>
				
				<c:if test="${not empty masculina}">
					<h5>Quantidade de roupas masculinas cadastradas: ${masculina.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>ID</th>
 							<th>CODIGO</th> 
 							<th>DESCRIÇÃO</th> 
 							<th>VALOR</th> 
 							<th>QUANTIDADE</th> 
							<th>BORDADO</th>
							<th>TAMANHO</th>
							<th>% ALGODÃO</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="m" items="${masculina}">
								<tr>
									<td>${m.id}</td>
 									<td>${m.codProd}</td> 
 									<td>${m.descricao}</td> 
 									<td>${m.valorCusto}</td> 
 									<td>${m.qtdade}</td> 
									<td>${m.bordado}</td>
									<td>${m.tamanho}</td>
									<td>${m.porAlgodao}</td>
									<td><a href="/masculina/${m.id}/excluir">Excluir</a></td>
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