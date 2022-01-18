<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
</head>

<body>

<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
<a href="ConnexionServlet">S'inscrire - Se connecter</a>

<h3>Liste des enchères</h3>

<h3>Filtres:</h3>

<form action="AccueilServlet" method="POST">

<div>
  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
</div>
<br>
<p><select name = "categorie">
	<option value = "ameublement">Ameublement</option>
	<option value = "informatique">Informatique</option>
	<option value = "sportEtLoisir">Sport et loisir</option>
	<option value = "vetement">Vetement</option>
</select>
</p>
<br>
<input type = "submit" name="Rechercher" value="rechercher"/>
<br>
<br>
<!-- article et caractéristiques a faire -->
</form>

</body>
</html>