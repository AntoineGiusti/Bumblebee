<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	<h2>Détail vente</h2>
	
	<img alt="#" src="fichier****">
	
	<form action="DetailVenteServlet" method="POST">
	<h2>--Nom de L'article--</h2>
		
	<h2>Description:</h2>
	<P>$(categorie.libelle)</P>
		
	<h2>Catégorie: </h2>
	<p>$(categorie.)</p>
		
	<h2>Meilleure offre:</h2>
	<p>$(utilisateur.credit)par $(utlisiateur.prenom)</p>
		
	<h2>Mise à prix</h2>
	<p>$(???????.credit)</p>
		
	<h2>Fin de l'enchère:</h2>
	<p>$(???????.LocalDateTime)</p>
		
	<h2>Retrait:</h2>
	<p>$(utilisateur.rue) $(utilisateur.codePostal) $(utilisateur.ville)</p>
		
	<h2>Vendeur</h2>
	<p>$(utilisateur.pseudo)</p>
		
	<h2>Ma proposition:</h2>
		
		
	<input type="submit" name="encherir" value="Enchérir"/>
	</form>
	
</body>
</html>