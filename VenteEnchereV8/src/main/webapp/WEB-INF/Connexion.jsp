<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connexion</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1 ><a class ="eni" href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<h2>${erreur}</h2>	
	<form class="formulaire" action="ConnexionServlet" method= "POST">
		<label for="pseudo">Identifiant :</label>
		<input type="text" name="pseudo" value="">
		<label for="motDePasse">Mot de passe :</label>
		<input type="password" name="motDePasse" value="">
		<input class="btn" type="submit" name="connexion" value= "Connexion">
		<input  class="btn"  type="submit" name="creer" value= "Créer un compte"><br>
		<input class= "ckbox" type="checkbox" id="memo" name="memo">
		<label id="souvenir" for="memo">Se souvenir de moi</label>
		<a id="mdpo" href="page.jsp">Mot de passe oublié</a>
		
	</form>



</body>
</html>