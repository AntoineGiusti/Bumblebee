<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
</head>
<body>
<<<<<<< HEAD
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
=======

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
	<option value = "toutes">Toutes</option>
	<option value = "ameublement">Ameublement</option>
	<option value = "informatique">Informatique</option>
	<option value = "sportEtLoisir">Sport et loisir</option>
	<option value = "vetement">Vetement</option>
</select>
</p>
<br>
<input type = "submit" name="Rechercher" value="Rechercher"/>
<br>
	${model.lstArticles }
<br>
<br>
	${lstInfo }
<br>

<!-- article et caractéristiques a faire -->
</form>

>>>>>>> f31013e6689c414aa272d1309d773f9d89f56fab
</body>
</html>