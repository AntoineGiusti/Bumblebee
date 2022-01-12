<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connexion</title>
</head>
<body>
	<form action="ConnexionServlet" method= "POST">
		<label for="pseudo">pseudo</label>
		<input type="text" name="pseudo" value="">
		<label for="motDePasse">mot de passe</label>
		<input type="text" name="motDePasse" value="">
		<input type="submit" name="connexion" value= "connexion">
		<input type="submit" name="creer" value= "creer compte">
	</form>



</body>
</html>