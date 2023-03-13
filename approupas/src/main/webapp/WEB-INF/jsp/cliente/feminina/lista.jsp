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
		<form action="/feminina" method="get">
			<h2>LISTA DE ROUPAS FEMININAS</h2>
				<c:if test="${empty feminina}">
					<h5>Não existem roupas femininas cadastradas!!!</h5>
				</c:if>
				
				<c:if test="${not empty feminina}">
					<h5>Quantidade de roupas femininas cadastradas: ${feminina.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>ID</th>
<!-- 							<th>CODIGO</th> -->
<!-- 							<th>DESCRIÇÃO</th> -->
<!-- 							<th>VALOR</th> -->
<!-- 							<th>QUANTIDADE</th> -->
							<th>ESTAMPA</th>
							<th>TAMANHO</th>
							<th>COLEÇÃO</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="f" items="${feminina}">
								<tr>
									<td>${f.id}</td>
<%-- 									<td>${f.cod_prod}</td> --%>
<%-- 									<td>${f.descricao}</td> --%>
<%-- 									<td>${f.valor}</td> --%>
<%-- 									<td>${f.quantidade}</td> --%>
									<td>${f.estampa}</td>
									<td>${f.tamanho}</td>
									<td>${f.colecao}</td>
									<td><a href="/feminina/${f.id}/excluir">Excluir</a></td>
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