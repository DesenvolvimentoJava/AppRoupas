<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuario</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-5 d-flex flex-column align-items-center border border-2 rounded pt-5 pb-5">
		<form action="/cep" class="form-inline" method="post">
			<label>CEP:</label>
			<input type="text" name="cep" value="24400500" class="form-conytol">
			<button type="submit" class="btn btn-primary">Buscar</button>
		</form>
	
		<h2>Cadastro de Usuário</h2>
		<form action="/usuario/incluir" method="post" class="w-50" >
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Nome" name="nome">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Sobrenome" name="sobrenome">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="E-mail" name="email">
	    	<input type="password" class="form-control form-control-lg mt-3" placeholder="senha" name="senha">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Telefone" name="tel">
	    	<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>
	    	<label>Tipo:</label>
	    	<div class="d-flex justify-content-around">
		    	<div class="form-check form-switch mt-3">
		    		<label class="form-check-label" for="adm">Fornecedor</label>
	  				<input class="form-check-input" type="radio" id="adm" name="tipo" value="1">
	  			</div>
	  			<div class="form-check form-switch mt-3">
	  				<label class="form-check-label" for="funcionario">Funcionario</label>
	  				<input class="form-check-input" type="radio" id="funcionario" name="tipo" value="2">
	  			</div>
	  			<div class="form-check form-switch mt-3">
	  				<label class="form-check-label" for="cliente">Cliente</label>
	  				<input class="form-check-input" type="radio" id="cliente" name="tipo" value="3">
				</div> 
			</div> 
			<button type="submit" class="btn btn-outline-secondary mt-5">Cadastrar</button>	   	   	
	  	</form>
  	</div>

</body>
</html>