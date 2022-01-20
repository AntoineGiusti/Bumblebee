<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Mon Profil</title>
<link rel="stylesheet" href="/VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a class = "eni" href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<h2>Modifier Mon profil</h2>	
	<h3>${verifMp}</h3>
	<div class = "formulaire">	
		<form action="ProfilUtilisateurModifierServlet" method="POST">
			<p>Pseudo: <input class = "block" type="text" name="pseudo" value="${model.utilisateurUdapte.pseudo}"/></p><br>			
			<p>Nom: <input class = "block" type="text" name="nom" value="${model.utilisateurUdapte.nom}"/></p><br>			
			<p>Prenom: <input class = "block" type="text" name="prenom" value="${model.utilisateurUdapte.prenom}"/></p><br>			
			<p>Email: <input class = "block" type="text" name="email" value="${model.utilisateurUdapte.email}"/></p><br>			
			<p>Téléphone: <input class = "block" type="text" name="telephone" value="${model.utilisateurUdapte.telephone}"/></p><br>			
			<p>Rue: <input class = "block" type="text" name="rue" value="${model.utilisateurUdapte.rue}"/></p><br>			
			<p>Code postal <input class = "block"  type="text" name="codePostal" value="${model.utilisateurUdapte.codePostal}"/></p><br>			
			<p>Ville <input class = "block" type="text" name="ville" value="${model.utilisateurUdapte.ville}"/></p><br>			
			<p>Mot de passe actuel <input class = "block" type="password" name="motDePasseActuel" /></p><br>			
			<p>Nouveau mot de passe <input class = "block" type="password" name="NouveauMotDePasse" value="${model.utilisateurUdapte.motDePasse}"/></p><br>			
			<p>Confirmation <input class = "block" type="password" name="confirmation" value="${model.utilisateurUdapte.motDePasse}"/></p><br>			
			<p>Crédits : ${model.utilisateurUdapte.credit}</p><br>
			<div class = "bouton">			
				<input type = "submit" name="enregister" value="enregister"/>			
				<input type = "submit" name="supprimer" value="Supprimer Compte"/>
			</div>
		</form>
	</div>
	<h3 class = "erreur">${erreur}</h3>
</body>
</html>