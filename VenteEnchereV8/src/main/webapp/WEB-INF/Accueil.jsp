<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
</head>
<body>
	<div class = "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<a href="ConnexionServlet">S'inscrire - Se connecter</a>
	<h2>Liste des enchères</h2>
	<div>
		<h3>Filtres:</h3>
  		<input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
	</div>
	<div class ="formulaire">
		<form action="AccueilServlet" method="POST">
			<p><select name = "categorie">
				<option value = "ameublement">Ameublement</option>
				<option value = "informatique">Informatique</option>
				<option value = "sportEtLoisir">Sport et loisir</option>
				<option value = "vetement">Vetement</option>
			</select>
			</p><br>
			<div class = "rechercher">
				<input type = "submit" name="Rechercher" value="rechercher"/>
			</div>
			<div class = "articles">
				<ul>
					<li>${model.lstArticles }</li>
					<li>${model.lstArticles }</li>
					<li>${model.lstArticles }</li>
					<li>${model.lstArticles }</li>
					<li>${model.lstArticles }</li>
					<li>${model.lstArticles }</li>
				</ul>
			</div>
		</form>
   </div>
</body>
</html>