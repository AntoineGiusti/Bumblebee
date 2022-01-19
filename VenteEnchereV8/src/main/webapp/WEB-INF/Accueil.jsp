<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<option value = "toutes">Toutes</option>
				<option value = "ameublement">Ameublement</option>
				<option value = "informatique">Informatique</option>
				<option value = "sportEtLoisir">Sport et loisir</option>
				<option value = "vetement">Vetement</option>
			</select>
			</p><br>
			<div class = "rechercher">
				<input type = "submit" name="Rechercher" value="Rechercher"/>
			</div>
			
		</form>
   </div>
	<br>
	<c:forEach items="${model.lstArticles}" var="art">
	<p>${art.nomArticle}<br>
	 prix de vente : ${art.prixVente}<br>
	 date de fin enchere : ${art.dateFinEncheres}<br>
	 vendeur : ${art.utilisateur.pseudo}</p>
	</c:forEach>

	<c:forEach items="${model.lstArticlesParCategorie}" var="artBy">
	<p>${artBy.nomArticle}<br>
	 prix de vente : ${artBy.prixVente}<br>
	 date de fin enchere : ${artBy.dateFinEncheres}<br>
	 vendeur : ${artBy.utilisateur.pseudo}</p>
	</c:forEach>
<br>

</body>
</html>