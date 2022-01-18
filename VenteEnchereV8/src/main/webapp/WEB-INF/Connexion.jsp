<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connexion</title>
</head>
<body>
	<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	<h2>${erreur}</h2>
	<form action="ConnexionServlet" method= "POST">
		<label for="pseudo">Identifiant :</label>
		<input type="text" name="pseudo" value="">
		<label for="motDePasse">Mot de passe :</label>
		<input type="text" name="motDePasse" value="">
		<input type="submit" name="connexion" value= "Connexion">
		<input type="checkbox" id="memo" name="memo">
		<label for="memo">Se souvenir de moi</label>
		<a href="page.jsp">Mot de passe oublié</a>
		<input type="submit" name="creer" value= "Créer un compte">
	</form>



</body>
</html>