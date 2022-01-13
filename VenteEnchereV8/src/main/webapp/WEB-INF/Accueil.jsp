<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
</head>
<h1>ENI-Enchères</h1>
<a href="Connexion.jsp">S'inscrire - Se connecter</a>
<body>
<h3>Liste des enchères</h3>

<h3>Filtres:</h3>

<form action="AccueilServlet" method="POST">

<div>
  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
</div>
<br>
<menuitem type="radio" radiogroup="group1">Catégorie:</menuitem>
<input type = "submit" name="Rechercher" value="rechercher"/>
<br>
<br>

</form>

</body>
</html>