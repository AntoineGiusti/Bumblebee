<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creer Mon Profil</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>

<body>
	<div class = "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<h2>Mon profil</h2>
	<div class = "formulaire">
		<form action="CreationProfilServlet" method="POST">
			<p>Pseudo: <input class="block" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/></p><br>		
			<p>Nom: <input class="block" type="text" name="nom" value="${model.utilisateur.nom}"/></p><br>		
			<p>Prenom: <input class="block" type="text" name="prenom" value="${model.utilisateur.prenom}"/></p><br>		
			<p>Email: <input class="block" type="text" name="email" value="${model.utilisateur.email}"/></p><br>		
			<p>T�l�phone: <input class="block" type="text" name="telephone" value="${model.utilisateur.telephone}"/></p><br>		
			<p>Rue: <input class="block" type="text" name="rue" value="${model.utilisateur.rue}"/></p><br>		
			<p>Code postal <input class="block" type="text" name="codePostal" value="${model.utilisateur.codePostal}"/></p><br>		
			<p>Ville <input class="block" type="text" name="ville" value="${model.utilisateur.ville}"/></p><br>		
			<p>Mot de passe <input class="block" type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/></p><br>		
			<p>Confirmation <input class="block" type="password" name="confirmation"/></p>
			<div class= "bouton">
				<input type = "submit" name="valider" value="Cr�er"/>		
				<input type = "submit" name="annuler" value="Annuler"/>
			</div>
		<h3 class = "erreur">${erreur}</h3>		
		</form>
	</div>	
	
</body>
</html>