<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Menu</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav d-flex flex-row">
      <li class="active"><a href="#">Home</a></li>
      	<c:if test="${not empty usuario}">
	      <li><a href="/usuario/lista">Usuários</a></li>
	      <li><a href="/cliente/lista">Cliente</a></li>
	      <li><a href="/roupa/lista">Roupa</a></li>
	      <li><a href="/masculina/lista">Masculina</a></li>
	      <li><a href="/feminina/lista">Feminina</a></li>
	      <li><a href="/infantil/lista">Infantil</a></li>
	      <li><a href="/compra/lista">Compras</a></li>
		</c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right d-flex flex-row">
    	<c:if test="${empty usuario}">
      		<li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      		<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      	</c:if>	
      	<c:if test="${not empty usuario}">	
      		<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${usuario.nome}</a></li>
      	</c:if>
    </ul>
  </div>
</nav>
</body>
</html>