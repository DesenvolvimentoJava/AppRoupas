<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Cliente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-5 d-flex flex-column align-items-center border border-2 rounded pt-5 pb-5">
	
		<h2>Cadastro de Cliente</h2>
		<form action="/cliente/incluir" method="post" class="w-50" >
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Nome" name="nome">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="CPF" name="cpf">
<!-- 	    <input type="text" class="form-control form-control-lg mt-3" placeholder="Endereço" name="endereco"> -->
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="E-mail" name="email">
			<button type="submit" class="btn btn-outline-secondary mt-5">Cadastrar</button>	   	   	
	  	</form>
  	</div>

</body>
</html>