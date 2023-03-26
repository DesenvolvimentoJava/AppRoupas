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
		<form action="/roupa" method="get">
			<h2>LISTA DE ROUPAS</h2>
				<c:if test="${empty roupa}">
					<h5>Não existem roupas cadastradas!!!</h5>
				</c:if>
				
				<c:if test="${not empty roupa}">
					<h5>Quantidade de roupas cadastradas: ${oupa.size()} !!!</h5>
	
					<table class="table table-striped container">
						<thead>
							<th>ID</th>
 							<th>CODIGO</th>
 							<th>DESCRIÇÃO</th>
 							<th>VALOR</th>
 							<th>QUANTIDADE</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach var="r" items="${roupa}">
								<tr>
									<td>${r.id}</td>
 									<td>${r.codProd}</td>
 									<td>${r.descricao}</td>
 									<td>${r.valorCusto}</td>
- 									<td>${r.qtdade}</td>
									<td><a href="/roupa/${r.id}/excluir">Excluir</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
<!-- 			<button type="submit" class="btn btn-primary">Novo</button> -->
		</form>
			
	</main>
</body>
</html>