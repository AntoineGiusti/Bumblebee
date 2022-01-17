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
		<p>Mot de passe actuel <input type="password" name="motDePasseActuel" value=""/>
		<br>
		<p>Nouveau mot de passe <input type="password" name="NouveauMotDePasse" value=""/>
		<br>
		<p>Confirmation <input type="password" name="confirmation" value=""/>
		<br>
		<p>Crédits : ${utilisateur.credit}</p>
		<br>
		<input type = "submit" name="enregister" value="enregister"/>
		
		<input type = "submit" name="supprimer" value="Supprimer Compte"/>
	
	</form>
	
	<h3>${erreur}</h3>

</body>
</html>