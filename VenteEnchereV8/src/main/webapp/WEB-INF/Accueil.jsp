<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
</head>

<body>

<h1>ENI-Enchères</h1>
<a href="Connexion.jsp">S'inscrire - Se connecter</a>

<h3>Liste des enchères</h3>

<h3>Filtres:</h3>

<form action="AccueilServlet" method="POST">

<div>
  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
</div>
<br>
<div id="wrap">
<ul class="navbar">

    <a href="#"></a>
    <ul>
      <li><a href="#">Informatique</a></li>
      <li><a href="#">Sport & Loisir</a></li>
      <li><a href="#">Vêtement</a></li>
      <li><a href="#">Ameublement</a></li>
    </ul>
  </li>
<br>
<input type = "submit" name="Rechercher" value="rechercher"/>
<br>
<br>
<!-- article et caractéristiques a faire -->
</form>

</body>
</html>