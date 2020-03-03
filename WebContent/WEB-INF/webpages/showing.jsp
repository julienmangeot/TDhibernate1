<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>See all our formations</title>
	<style><%@ include file="bootstrap.min.css" %></style>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/TDHibernate1/home">Home</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
   			<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
    		<ul class="navbar-nav">
     			<li class="nav-item active">
        			<a class="nav-link" href="/TDHibernate1/add">Adding <span class="sr-only">(current)</span></a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/TDHibernate1/show">Listing</a>
      			</li>
    		</ul>
  		</div>
	</nav>
<div>
	<c:forEach items="${listing}" var="fr">
		<h2> Id Formation: ${fr.idFormation} </h2>
		<h2> Theme Formation:  ${fr.theme}</h2>
	</c:forEach>
</div>
</body>
</html>