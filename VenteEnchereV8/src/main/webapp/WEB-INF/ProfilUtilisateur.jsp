<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a class="eni" href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div><br>	
	<div class = "formulaire">
		<form action="ProfilUtilisateurServlet" method= "POST">	
			<p>Pseudo : ${utilisateur.pseudo}</p><br>			
			<p>Nom : ${utilisateur.nom}</p><br>			
			<p>Prenom : ${utilisateur.prenom}</p><br>			
			<p>Email : ${utilisateur.email}</p><br>			
			<p>Téléphone : ${utilisateur.telephone}</p><br>			
			<p>Rue : ${utilisateur.rue}</p><br>			
			<p>Code postal : ${utilisateur.codePostal}</p><br>			
			<p>Ville : ${utilisateur.ville}</p><br>	
			
		</form>
	</div>
	<div class = "bouton">				
		<input class= "btn" type = "submit" name="modifier" value="Modifier"/>
	</div>
</body>
</html>