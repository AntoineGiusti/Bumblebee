<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Mon Profil</title>
<link rel="stylesheet" href="VenteEnchereV8/CSS/MaPage.css" >
</head>
<body>
	<div class = "logo">
		<h1><a href = "ConnexionServlet"> ENI-Encheres </a></h1>
	</div>
	<h2>Modifier Mon profil</h2>	
	<h3>${verifMp}</h3>
	<div class = "formulaire">	
		<form action="ProfilUtilisateurModifierServlet" method="POST">
			<p>Pseudo: <input type="text" name="pseudo" value="${model.utilisateurUdapte.pseudo}"/></p><br>			
			<p>Nom: <input type="text" name="nom" value="${model.utilisateurUdapte.nom}"/></p><br>			
			<p>Prenom: <input type="text" name="prenom" value="${model.utilisateurUdapte.prenom}"/></p><br>			
			<p>Email: <input type="text" name="email" value="${model.utilisateurUdapte.email}"/></p><br>			
			<p>Téléphone: <input type="text" name="telephone" value="${model.utilisateurUdapte.telephone}"/></p><br>			
			<p>Rue: <input type="text" name="rue" value="${model.utilisateurUdapte.rue}"/></p><br>			
			<p>Code postal <input type="text" name="codePostal" value="${model.utilisateurUdapte.codePostal}"/></p><br>			
			<p>Ville <input type="text" name="ville" value="${model.utilisateurUdapte.ville}"/></p><br>			
			<p>Mot de passe actuel <input type="text" name="motDePasseActuel" /></p><br>			
			<p>Nouveau mot de passe <input type="text" name="NouveauMotDePasse" value="${model.utilisateurUdapte.motDePasse}"/></p><br>			
			<p>Confirmation <input type="text" name="confirmation" value="${model.utilisateurUdapte.motDePasse}"/></p><br>			
			<p>Crédits : ${utilisateurUdapte.credit}</p><br>
			<div class = "bouton">			
				<input type = "submit" name="enregister" value="enregister"/>			
				<input type = "submit" name="supprimer" value="Supprimer Compte"/>
			</div>
		</form>
	</div>
	<h3>${erreur}</h3>
</body>
</html>