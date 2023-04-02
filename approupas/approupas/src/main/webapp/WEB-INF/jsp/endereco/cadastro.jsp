<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Endereço</title>
</head>
<body>
  	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.cep}" placeholder="CEP" name="cep">
	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.logradouro}" placeholder="Endereço" name="logradouro">
	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.complemento}" placeholder="Complemento" name="complemento">
	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.bairro}" placeholder="Bairro" name="bairro">
	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.localidade}" placeholder="Cidade" name="localidade">
	<input type="text" class="form-control form-control-lg mt-3" value="${endereco.uf}" placeholder="Estado" name="uf">

</body>
</html>