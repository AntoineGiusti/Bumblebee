<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a class=eni href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<div class="connexion">
		<a href="ConnexionServlet">S'inscrire - Se connecter</a>
	</div>
	<h2>Liste des enchères</h2>	
	<div class ="formulaire">
		<h3>Filtres:</h3>	
		<form action="AccueilServlet" method="POST">
			<input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
			<p class = "option"><select name = "categorie">
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
			
		
	<br>
	
		<c:forEach items="${model.lstArticles}" var="art">
	<div class= liste>	
		<p class = "nomArt">${art.nomArticle}</p><br>
		<p class = "detailArt"> prix de vente : ${art.prixVente}<br>
		 date de fin enchere : ${art.dateFinEncheres}<br>
		 vendeur : ${art.utilisateur.pseudo}</p>
	</div>	 
		</c:forEach>
	
		<c:forEach items="${model.lstArticlesParCategorie}" var="artByCat">
		<div class= liste>
		<p class = "nomArt">${artByCat.nomArticle}</p><br>
		<p class = "detailArt">prix de vente : ${artByCat.prixVente}<br>
		 date de fin enchere : ${artByCat.dateFinEncheres}<br>
		 vendeur : ${artByCat.utilisateur.pseudo}</p>
		 </div>
		</c:forEach>
		
		<c:forEach items="${model.lstArticlesParMotClef}" var="artByMot">
		<div class= liste>
		<p class = "nomArt">${artByMot.nomArticle}<br></p>
		<p class = "detailArt">prix de vente : ${artByMot.prixVente}<br>
		 date de fin enchere : ${artByMot.dateFinEncheres}<br>
		 vendeur : ${artByMot.utilisateur.pseudo}</p>
		 </div>
		</c:forEach>
	</form>
	<br>
</div>


   

</body>
</html>