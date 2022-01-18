<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>

	<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
		<div class = "imgArticle">
			<img alt="image aticle" />
		</div>
	<div class = "formulaire">
	<h2>Nouvelle Vente</h2>
	<form action="NouvelleVenteServlet" method = "POST">
		<p>Article : <input type = "text" name= "nomArticle"/></p><br>
		<p>Description : <input type = "text" name= "description"/></p><br>
		<p>Categorie :
			<select name = "categorie">
				<option value = "ameublement">Ameublement</option>
				<option value = "informatique">Informatique</option>
				<option value = "sportEtLoisir">Sport et loisir</option>
				<option value = "vetement">Vetement</option>
			</select>
		</p>
		<br>
		<p>Photo de l'article 
			<label for = "imageUpload" >Selectionner image</label>
			<input type= "file" id="imageUpload" name = "imageUpload" accept = ".png , .jpeg">
		</p>
		<br>
			<p>Mise a prix : <input type = "number" name = "miseAPrix" /> point(s)</p><br>
			<p>Debut de l'enchere : <input type = "date" name = "dateDebutEnchere"/></p><br>
<p>Fin de l'enchere : <input type = "date" name = "dateFinEnchere"/></p><br>
		<fieldset>
			<legend>Retrait</legend>
			<p>Rue : <input type = "text" name= "rue" value = "${Utilisateur.rue}"/></p><br>
			<p>Code Postal : <input type = "text" name= "codePostal" value = "${Utilisateur.codePostal}"/></p><br>
			<p>Ville : <input type = "text" name= "ville" value = "${Utilisateur.ville}"/></p><br>
		</fieldset>
		<div class = "bouton">
			<input type = "submit" name = "enregistrer" value = "Enregistrer"/>
			<input type = "submit" name = "annuler" value = "Annuler"/>
		</div>
	</form>



</div>

</body>
</html>