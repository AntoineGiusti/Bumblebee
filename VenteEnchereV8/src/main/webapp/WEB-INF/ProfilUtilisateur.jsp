<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ENI_Enchères</h1>
	<br>
	<br>
	<form action="ProfilUtilisateurServlet" method= "POST">
	<p>Pseudo: <input type="text" name="pseudo" value="${utilisateur.pseudo}"/>
	<br>
	<p>Nom: <input type="text" name="nom" value="${utilisateur.nom}"/>
	<br>
	<p>Prenom: <input type="text" name="prenom" value="${utilisateur.prenom}"/>
	<br>
	<p>Email: <input type="text" name="email" value="${utilisateur.email}"/>
	<br>
	<p>Téléphone: <input type="text" name="telephone" value="${utilisateur.telephone}"/>
	<br>
	<p>Rue: <input type="text" name="rue" value="${utilisateur.rue}"/>
	<br>
	<p>Code postal <input type="text" name="codePostal" value="${utilisateur.codePostal}"/>
	<br>
	<p>Ville <input type="text" name="ville" value="${utilisateur.ville}"/>
	<br>
	<p>Mot de passe <input type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<br>
	
	<input type = "submit" name="modifier" value="Modifier"/>
	</form>

	
</body>
</html>