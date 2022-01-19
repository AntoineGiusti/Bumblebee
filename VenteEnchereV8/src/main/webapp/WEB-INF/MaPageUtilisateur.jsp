<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ma page utilisateur</title>
<link rel="stylesheet" href="VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<nav class = "navBar">	
		<a href="AccueilServlet">Enchères</a>
		<a href="NouvelleVenteServlet">Vendre un article</a>
		<a href="ProfilUtilisateurServlet">Mon profil</a>
		<a href="MaPageUtilisateurServlet?deconnexion" >Déconnexion</a>
	</nav>
	<h2>Liste des enchères</h2>
	<form action="">
		<h2>Filtres : </h2>	
		<div class = "searchBar">
		  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
		</div>	
		<p>Categorie : 
		<select name = "categorie">
			<option value = "Toutes">Toutes</option>
			<option value = "ameublement">Ameublement</option>
			<option value = "informatique">Informatique</option>
			<option value = "sportEtLoisir">Sport et loisir</option>
			<option value = "vetement">Vetement</option>
		</select></p>
		<div class = "rechercher">
			<input type="submit" name="rechercher" value="Rechercher"><br>
		</div>			
		<div>
			<input type="radio" name="achat" value="Achats" id="achat" onclick="clickAchat()">Achats		
			<input type="radio" name="achat" value="Mes ventes" id="vente" onclick="clickVente()">Mes ventes
		</div>
		<br>
		<div>
			<input type="checkbox" id="ouvert" >enchères ouvertes<br>
			<input type="checkbox" id="mienne" >mes enchères<br>
			<input type="checkbox" id="win" >mes enchères remportées
		</div>
		<br>
		<div>
			<input type="checkbox" id="ventes" >mes ventes en cours<br>
			<input type="checkbox" id="nostart" >ventes non débutées<br>
			<input type="checkbox" id="termine" >ventes terminées
		</div>
	</form>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/MaPage.js"></script>
</html>


