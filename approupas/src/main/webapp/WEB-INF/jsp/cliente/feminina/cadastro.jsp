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
		<h2>Cadastro de Roupas Femininas</h2>
		<form action="/feminina/incluir" method="post" class="w-50" >
  	 	    <input type="text" class="form-control form-control-lg mt-3" placeholder="Código do Produto" name="cod_prod">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Descrição" name="descricao">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Valor" name="valor">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Quantidade" name="quantidade">
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Tamanho" name="tamanho"> 
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Ano Coleção" name="colecao">
	    	<div class="d-flex justify-content-around">
		    	<div class="form-check form-switch mt-3">
		    		<label class="form-check-label" for="sim">Sim</label>
	  				<input class="form-check-input" type="radio" id="sim" name="estampa" value="true">
	  			</div>
	  			<div class="form-check form-switch mt-3">
	  				<label class="form-check-label" for="nao">Não</label>
	  				<input class="form-check-input" type="radio" id="nao" name="estampa" value="false">
	  			</div>
	  		</div>	
			<button type="submit" class="btn btn-outline-secondary mt-5">Cadastrar</button>	   	   	
	  	</form>
  	</div>

</body>
</html>