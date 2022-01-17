/**
 * 


 */function clickAchat() {
	
	console.log("entrée dans clickAchat");
var cours = document.getElementbyId("cours");
cours.checked = false;
cours.disabled = true;
var nostart = document.getElementbyId("nostart");
nostart.checked = false;
nostart.disabled = true;
var termine = document.getElementbyId("termine");
termine.checked = false;
termine.disabled = true;
}

function clickVente() {
	
	console.log("entrée dans clickVente");
	var ouvert = document.getElementbyId("ouvert");
	ouvert.checked = false;
	ouvert.disabled = true;
	var mienne = document.getElementbyId("mienne");
	mienne.checked = false;
	mienne.disabled = true;
	var win = document.getElementbyId("win");
	win.checked = false;
	win.disabled = true;
}

