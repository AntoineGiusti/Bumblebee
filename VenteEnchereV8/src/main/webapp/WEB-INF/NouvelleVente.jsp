<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
<h1>ENI-Encheres</h1>
<div class = "imgArticle"></div>
<img alt="pentalon vert" src="WEB-INF/img/pentalon.png">
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
</p><br>
<p>Photo de l'article <input type = "submit" name = "upload" value = "UPLOADER"/></p><br>
<p>Mise a prix : <input type = "number" name = "miseAPrix" /> euros</p><br>
<p>Debut de l'enchere : <input type = "date" name = "dateDebutEnchere"/></p><br>
<p>Fin de l'enchere : <input type = "date" name = dateFinEnchere/></p><br>
<fieldset>
	<legend>Retrait</legend>
	<p>Rue : <input type = "text" name= "rue"/></p><br>
	<p>Code Postal : <input type = "text" name= "codePostal"/></p><br>
	<p>Ville : <input type = "text" name= "ville"/></p><br>
</fieldset>
<div class = "bouton">
<input type = "submit" name = "enregistrer" value = "Enregistrer"/>
<input type = "submit" name = "annuler" value = "Annuler"/>
</div>
</form>
</div>

</body>
</html>