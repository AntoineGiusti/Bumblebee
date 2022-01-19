<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vous avez remporter la vente</title>
</head>
<body>
	<div class= "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<div class = "img">
		<img  src="" >
	</div>
	<h2>Vous avez remporter la vente</h2>
	<div class = "formulaire">
		<form action="" method = "POST">
			<p>${articleVendu.nomArticle}</p><br>
			<p>Description : ${categorie.libelle}</p><br>
			<p>Meilleure offre : <!-- ${enchere.meilleurEnchere} à la date de fin enchere. --></p><br>
			<p>Mise a prix : ${enchere.montantEnchere}<!-- a verifier --></p><br>
			<p>Retrait : ${utilisateur.rue} <br>
			 	${utilisateur.codePostal} ${utilisateur.ville}</p><br>
			<p>Vendeur : ${utilisateur.pseudo}</p><br> 
			<p>Tel : ${utilisateur.telephone }</p><br>
			<input type = "submit" name = "retour" value = "Back"/>
		</form>
	</div>
</body>
</html>