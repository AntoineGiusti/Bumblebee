<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Vente</title>
</head>
<body>
	<div class = "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<h2>Detail vente</h2>
		<div class = "img">
			<img  src="" >
		</div>
	<div class = "formulaire">	
		<form action="DetailVenteServlet" method="POST">
			<p>${articleVendu.nomArticle}</p>
			<p>Description : ${lstCategorie.categorie}</P><br>	
			<p>Catégorie : ${categorie.libelle}</p><br>
			<p>Meilleure offre : ${utilisateur.credit}par ${utilisateur.prenom}</p><br>				
			<p>Mise à prix : ${enchere.montantEnchere}</p><br>				
			<p>Fin de l'enchère : ${enchere.dateEnchere}</p><br>					
			<p>Retrait : ${utilisateur.rue} <br>			
			 ${utilisateur.codePostal} ${utilisateur.ville}</p><br>				
			<p>Vendeur : ${profilVendeur.utilisateur.pseudo}</p><br>				
			<p>Ma proposition : <input type = "number" name = "proposition"/></p>			
			<input type ="submit" name="encherir" value="Enchérir"/>
		</form>
	</div>	
</body>
</html>