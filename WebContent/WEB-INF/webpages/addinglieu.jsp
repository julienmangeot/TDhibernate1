<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Add a location here</title>
	<style><%@ include file="bootstrap.min.css" %></style>
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
<form action="/TDHibernate1/addl" method="post">
  <div class="form-group">
    <label>Location address</label>
    <input type="text" class="form-control" name="adress" id="ad" aria-describedby="emailHelp" placeholder="Enter a adress">
  </div>
  <div class="form-group">
    <label>Location city</label>
    <input type="text" class="form-control" name="city" id="ct" aria-describedby="emailHelp" placeholder="Enter a city">
  </div>
  <button type="submit" class="btn btn-primary">Valider</button>
</form>
</body>
</html>