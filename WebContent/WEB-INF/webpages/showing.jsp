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
        			<a class="nav-link" href="/TDHibernate1/addf">Adding a formation<span class="sr-only">(current)</span></a>
      			</li>
      			 <li class="nav-item active">
        			<a class="nav-link" href="/TDHibernate1/addl">Adding a location<span class="sr-only">(current)</span></a>
      			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="/TDHibernate1/showf">Listing formations<span class="sr-only">(current)</span></a>
      			</li>
    		</ul>
  		</div>
	</nav>
<form action="/TDHibernate1/showf" method="post">
<div class="form-group">
    <label>Select a location</label>
    <select class="form-control" name="location" id="location">
    	<c:forEach items="${listingl}" var="l">
      		<option value="${l.idLieu}"> ${l.city} </option>
      	</c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Valider</button>
  </div>
  </form>
<div>
<label>Here all formations connected to this location</label>
	<c:forEach items="${listingf}" var="fr">
		<h2> Id Formation: ${fr.idFormation} </h2>
		<h2> Theme Formation:  ${fr.theme}</h2>
	</c:forEach>
</div>
</body>
</html>