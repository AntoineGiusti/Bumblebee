/**
 * 
 */


function clickAchat() {
	
	var cours = document.getElementById("ventes");
	cours.checked = false;
	cours.disabled = true;
	var nostart = document.getElementById("nostart");
	nostart.checked = false;
	nostart.disabled = true;
	var termine = document.getElementById("termine");
	termine.checked = false;
	termine.disabled = true;
	
	var cours = document.getElementById("ouvert");
	cours.disabled = false;
	
	var nostart = document.getElementById("mienne");
	nostart.disabled = false;
	
	var termine = document.getElementById("win");
	termine.disabled = false;

}


function clickVente() {
	
	var ouvert = document.getElementById("ouvert");
	ouvert.checked = false;
	ouvert.disabled = true;
	var mienne = document.getElementById("mienne");
	mienne.checked = false;
	mienne.disabled = true;
	var win = document.getElementById("win");
	win.checked = false;
	win.disabled = true;
	
	var cours = document.getElementById("ventes");
	cours.disabled = false;
	
	var nostart = document.getElementById("nostart");
	nostart.disabled = false;
	
	var termine = document.getElementById("termine");
	termine.disabled = false;

}

