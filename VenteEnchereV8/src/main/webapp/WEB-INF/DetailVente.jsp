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
		
			<p>${model.article.nomArticle}</p>
			<p>Description : ${model.article.description}</p><br>	
			<p>Catégorie : ${model.article.categorie.libelle}</p><br>
			<p>Meilleure offre : </p><br>				
			<p>Mise à prix : ${model.article.miseAPrix}</p><br>				
			<p>Fin de l'enchère : ${model.article.dateFinEncheres}</p><br>					
			<p>Retrait : ${model.article.utilisateur.rue} <br>			
			 ${model.article.utilisateur.codePostal} ${model.article.utilisateur.ville}</p><br>				
			<p>Vendeur : ${model.article.utilisateur.pseudo}</p><br>				
			<p>Ma proposition : <input type = "number" name = "proposition"/></p>			
			<input type ="submit" name="encherir" value="Enchérir"/>
			<input type ="hidden" name="id" value="${model.article.noArticle}"/>
		</form> 
		</div>
		<h2>${erreur}</h2>
</body>
</html>