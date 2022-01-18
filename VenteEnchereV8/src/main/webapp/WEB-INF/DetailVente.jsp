<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	
	<h2>Détail vente</h2>
	
	<img  src="" alt=>
	
	<form action="DetailVenteServlet" method="POST">
	<h2>${articleVendu.nomArticle}</h2>
		
	<h2>Description:</h2>
	<P>${lstcategorie.categorie}</P>
		
	<h2>Catégorie: </h2>
	<p>${categorie.libelle}</p>
		
	<h2>Meilleure offre:</h2>
	<p>${utilisateur.credit}par ${utilisateur.prenom}</p>
		
	<h2>Mise à prix</h2>
	<p>${enchere.montantEnchere}</p>
		
	<h2>Fin de l'enchère:</h2>
	<p>${enchere.dateEnchere}</p>
		
	<h2>Retrait:</h2>
	<p>${utilisateur.rue} ${utilisateur.codePostal} ${utilisateur.ville}</p>
		
	<h2>Vendeur</h2>
	<p>${profilVendeur.utilisateur.pseudo}</p>
		
	<h2>Ma proposition:</h2>
	<menu>--chiffre--</menu>
	<input type="submit" name="encherir" value="Enchérir"/>
	</form>
	
</body>
</html>