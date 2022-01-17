<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Mon Profil</title>
</head>
<body>
	<h2>Modifier Mon profil</h2>
	
	<h3>${verifMp}</h3>
	
	<form action="ProfilUtilisateurModifierServlet" method="POST">
		<p>Pseudo: <input type="text" name="pseudo" value="${model.utilisateurUdapte.pseudo}"/>
		<br>
		<p>Nom: <input type="text" name="nom" value="${model.utilisateurUdapte.nom}"/>
		<br>
		<p>Prenom: <input type="text" name="prenom" value="${model.utilisateurUdapte.prenom}"/>
		<br>
		<p>Email: <input type="text" name="email" value="${model.utilisateurUdapte.email}"/>
		<br>
		<p>Téléphone: <input type="text" name="telephone" value="${model.utilisateurUdapte.telephone}"/>
		<br>
		<p>Rue: <input type="text" name="rue" value="${model.utilisateurUdapte.rue}"/>
		<br>
		<p>Code postal <input type="text" name="codePostal" value="${model.utilisateurUdapte.codePostal}"/>
		<br>
		<p>Ville <input type="text" name="ville" value="${model.utilisateurUdapte.ville}"/>
		<br>
		<p>Mot de passe actuel <input type="text" name="motDePasseActuel" />
		<br>
		<p>Nouveau mot de passe <input type="text" name="NouveauMotDePasse" value="${model.utilisateurUdapte.motDePasse}"/>
		<br>
		<p>Confirmation <input type="text" name="confirmation" value="${model.utilisateurUdapte.motDePasse}"/>
		<br>
		<p>Crédits : ${utilisateurUdapte.credit}</p>
		<br>
		<input type = "submit" name="enregister" value="enregister"/>
		
		<input type = "submit" name="supprimer" value="Supprimer Compte"/>
	
	</form>
	
	<h3>${erreur}</h3>

</body>
</html>