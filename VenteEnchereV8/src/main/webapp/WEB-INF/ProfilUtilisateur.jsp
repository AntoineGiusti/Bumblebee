<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
	<h1>ENI_Enchères</h1>
	<br>
	<br>
	<form action="ProfilUtilisateurServlet" method= "POST">

	<p>Pseudo : ${utilisateur.pseudo}</p>
	<br>
	<p>Nom : ${utilisateur.nom}</p>
	<br>
	<p>Prenom : ${utilisateur.prenom}</p>
	<br>
	<p>Email : ${utilisateur.email}</p>
	<br>
	<p>Téléphone : ${utilisateur.telephone}</p>
	<br>
	<p>Rue : ${utilisateur.rue}</p>
	<br>
	<p>Code postal : ${utilisateur.codePostal}</p>
	<br>
	<p>Ville : ${utilisateur.ville}</p>
	<br>
	
	<input type = "submit" name="modifier" value="Modifier"/>
	</form>
</body>

</html>