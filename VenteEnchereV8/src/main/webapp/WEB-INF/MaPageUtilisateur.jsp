<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ma page utilisateur</title>

</head>
<body>
<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>

<a href="AccueilServlet">Enchères</a>
<a href="NouvelleVenteServlet">Vendre un article</a>
<a href="ProfilUtilisateurServlet">Mon profil</a>
<a href="MaPageUtilisateurServlet?deconnexion" >Déconnexion</a>
<h2>Liste des enchères</h2>
<form action="">
<h2>Filtres : </h2>

<div>
  <input type="text" id="filtre" name="filtre" placeholder="Le nom de l'article contient">
</div>

<p>Catégorie : 
<select name = "categorie">
	<option value = "Toutes">Toutes</option>
	<option value = "ameublement">Ameublement</option>
	<option value = "informatique">Informatique</option>
	<option value = "sportEtLoisir">Sport et loisir</option>
	<option value = "vetement">Vetement</option>
</select></p>
<input type="submit" name="rechercher" value="Rechercher">
<br>
<script type="text/javascript" src="<%=request.getContextPath()%>/MaPage.js"></script>
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
</html>
<script src="WEB-INF/MaPage.js" type="application/javascript"></script>
</html>

