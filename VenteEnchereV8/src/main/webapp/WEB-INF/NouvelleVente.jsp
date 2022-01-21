<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a class = "eni" a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>

	<h2>Nouvelle Vente</h2>
	<div class = "formulaire">
		<form action="NouvelleVenteServlet" method = "POST">
			<p>Article : <input class ="block" type = "text" name= "nomArticle"/></p><br>
			<p>Description : <input class ="block" type = "text" name= "description"/></p><br>
			<p>Categorie :
				<select class ="block" name = "categorie">
					<option value = "ameublement">Ameublement</option>
					<option value = "informatique">Informatique</option>
					<option value = "sportEtLoisir">Sport et loisir</option>
					<option value = "vetement">Vetement</option>
				</select>
			</p><br>
			<p>Photo de l'article 
				<label for = "imageUpload" >Selectionner image</label>
				<input class ="block" type= "file" id="imageUpload" name = "imageUpload" accept = ".png , .jpeg">
			</p><br>
			<p>Mise a prix : <input class ="block"  type = "number" name = "miseAPrix" /> point(s)</p><br>
			<p>Debut de l'enchere : <input class ="block" type = "date" name = "dateDebutEnchere"/></p><br>
			<p>Fin de l'enchere : <input class ="block" type = "date" name = "dateFinEnchere"/></p><br>
		<fieldset>
			<legend>Retrait</legend>
				<p>Rue : <input class ="block"  type = "text" name= "rue" value = "${utilisateur.rue}"/></p><br>
				<p>Code Postal : <input class ="block" type = "text" name= "codePostal" value = "${utilisateur.codePostal}"/></p><br>
				<p>Ville : <input class ="block" type = "text" name= "ville" value = "${utilisateur.ville}"/></p><br>
			</fieldset>
			<div class = "bouton">
				<input class="btn" type = "submit" name = "enregistrer" value = "Enregistrer"/>
				<input class= "btn" type = "submit" name = "annuler" value = "Annuler"/>
			</div>
		</form>
		
	</div>
	
	
</body>
</html>