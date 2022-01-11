<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
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
<p>Pseudo: <input type="text" name="pseudo" value="${model.participant.pseudo}"/>
<br>
<p>Nom: <input type="text" name="nom" value="${model.participant.nom}"/>
<br>
<p>Prenom: <input type="text" name="prenom" value="${model.participant.prenom}"/>
<br>
<p>Email: <input type="text" name="email" value="${model.participant.email}"/>
<br>
<p>Téléphone: <input type="text" name="telephone" value="${model.participant.telephone}"/>
<br>
<p>Rue: <input type="text" name="rue" value="${model.participant.rue}"/>
<br>
<p>Code postal <input type="text" name="codePostal" value="${model.participant.codePostal}"/>
<br>
<p>Ville <input type="text" name="ville" value="${model.participant.ville}"/>
<br>
<p>Mot de passe <input type="text" name="motDePasse" value="${model.participant.motDePasse}"/>
<br>
<p>Confirmation <input type="text" name="confirmation" value="${model.participant.confirmation}"/>
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