<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Mon Profil</title>
</head>
<h1>ENI-Enchères</h1>
<body>

<h2>Mon profil</h2>

<form action="MonProfilServlet" method="POST">
<p>Pseudo: <input type="text" name="pseudo" value="${model.utilisateur.pseudo}"/>
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
<p>Mot de passe <input type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
<br>
<p>Confirmation <input type="text" name="confirmation" value="${model.utilisateur.confirmation}"/>
<br>


<br>
<input type = "submit" name="Créer" value="creer"/>
<br>

<br>
<input type = "submit" name="Annuler" value="annuler"/>
<br>

</form>

</body>

</html>