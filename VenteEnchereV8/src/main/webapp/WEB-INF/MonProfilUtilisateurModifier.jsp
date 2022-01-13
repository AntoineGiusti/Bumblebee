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
	<form action="CreationProfilServlet" method="POST">
		<p>Pseudo: <input type="text" name="pseudo" value="${utilisateur.pseudo}"/>
		<br>
		<p>Nom: <input type="text" name="nom" value="${model.utilisateur.nom}"/>
		<br>
		<p>Prenom: <input type="text" name="prenom" value="${model.utilisateur.prenom}"/>
		<br>
		<p>Email: <input type="text" name="email" value="${model.utilisateur.email}"/>
		<br>
		<p>Téléphone: <input type="text" name="telephone" value="${model.utilisateur.telephone}"/>
		<br>
		<p>Rue: <input type="text" name="rue" value="${model.utilisateur.rue}"/>
		<br>
		<p>Code postal <input type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
		<br>
		<p>Ville <input type="text" name="ville" value="${model.utilisateur.ville}"/>
		<br>
		<p>Mot de passe actuel <input type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
		<br>
		<p>Nouveau mot de passe <input type="text" name="NouveauMotDePasse"/>
		<br>
		<p>Confirmation <input type="text" name="confirmation"/>
		<br>
		<p>Crédits : ${utilisateur.credit}</p>
		<br>
		<input type = "submit" name="enregister" value="enregister"/>
		
		<input type = "submit" name="supprimer" value="Supprimer Compte"/>
	
	</form>

</body>
</html>