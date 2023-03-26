<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Compras</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-5 d-flex flex-column align-items-center border border-2 rounded pt-5 pb-5">
		<h2>Cadastro de Compras</h2>
		<form action="/compra/incluir" method="post" class="w-50" >
	    	<input type="text" class="form-control form-control-lg mt-3" placeholder="Descição" name="descricao"> 
<!-- 	 	<input type="text" class="form-control form-control-lg mt-3" placeholder="Data" name="data"> -->
	    	<label>Varejo:</label>
	    	<div class="d-flex justify-content-around">
		    	<div class="form-check form-switch mt-3">
		    		<label class="form-check-label" for="sim">Sim</label>
	  				<input class="form-check-input" type="radio" id="sim" name="varejo" value="true">
	  			</div>
	  			<div class="form-check form-switch mt-3">
	  				<label class="form-check-label" for="nao">Não</label>
	  				<input class="form-check-input" type="radio" id="nao" name="varejo" value="false">
	  			</div>
	  		</div>	
			<button type="submit" class="btn btn-outline-secondary mt-5">Cadastrar</button>	   	   	
	  	</form>
  	</div>

</body>
</html>