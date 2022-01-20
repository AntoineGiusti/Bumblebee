<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ma page utilisateur</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a class = "eni" href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<nav class = "navBar">	
		<a href="AccueilServlet">Enchères	</a>
		<a href="NouvelleVenteServlet">Vendre un article	</a>
		<a href="ProfilUtilisateurServlet">Mon profil	</a>
		<a href="MaPageUtilisateurServlet?deconnexion" >Déconnexion</a>
	</nav>
	<h2>Liste des enchères</h2>
	<form class="formulaire" action="">
		<h3>Filtres : </h3>	
		<div class = "searchBar">
		  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
		</div>	
		<p class = "cate">Categorie : 
		<select id="selectCat" name = "categorie">
			<option value = "Toutes">Toutes</option>
			<option value = "ameublement">Ameublement</option>
			<option value = "informatique">Informatique</option>
			<option value = "sportEtLoisir">Sport et loisir</option>
			<option value = "vetement">Vetement</option>
		</select></p>
		
		<div >
			<input class="search" type="submit" name="rechercher" value="Rechercher"><br>
		</div>
		<div class = "choix">			
		<div>
			<p id = "radio2"><input  type="radio" name="achat" value="Achats" id="achat" onclick="clickAchat()">Achats</p>		
			
		</div>
		<br>
		<div>
			<p id = "radio1"><input type="checkbox" id="ouvert" >enchères ouvertes<br>
			<input type="checkbox" id="mienne" >mes enchères<br>
			<input type="checkbox" id="win" >mes enchères remportées</p>
		</div>
		<br>
		<div>
		<p id = "radio2"><input  type="radio" name="achat" value="Mes ventes" id="vente" onclick="clickVente()">Mes ventes</p>
		</div>
		<br>
		<div>
			<p id = "radio1"><input type="checkbox" id="ventes" >mes ventes en cours<br>
			<input type="checkbox" id="nostart" >ventes non débutées<br>
			<input type="checkbox" id="termine" >ventes terminées</p>
		</div>
	</div>
	
		<c:forEach items="${model.lstAllArticles}" var="art">
	<p><a href = "<c:url value = "DetailVenteServlet?id=${art.noArticle}"/>">${art.nomArticle}</a><br>
	 prix de vente : ${art.prixVente}<br>
	 date de fin enchere : ${art.dateFinEncheres}<br>
	 vendeur : ${art.utilisateur.pseudo}</p>
	</c:forEach>

	<c:forEach items="${model.lstArticlesParCategorie}" var="artByCat">
	<p><a href="DetailVenteServlet">${artByCat.nomArticle}</a><br>
	 prix de vente : ${artByCat.prixVente}<br>
	 date de fin enchere : ${artByCat.dateFinEncheres}<br>
	 vendeur : ${artByCat.utilisateur.pseudo}</p>
	</c:forEach>
	
	<c:forEach items="${model.lstArticlesParMotClef}" var="artByMot">
	<p><a href="DetailVenteServlet">${artByMot.nomArticle}</a><br>
	 prix de vente : ${artByMot.prixVente}<br>
	 date de fin enchere : ${artByMot.dateFinEncheres}<br>
	 vendeur : ${artByMot.utilisateur.pseudo}</p>
	</c:forEach>
	
	</form>
	<a href = "<c:url value = "DetailVenteServlet?id=${art.noArticle}"/>">${article.nomArticle}</a>
	
	
	
	
	
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/MaPage.js"></script>
</html>


