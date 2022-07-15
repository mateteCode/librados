var elemLatitud = document.getElementById("latitud");
var elemLongitud = document.getElementById("longitud");
var latitudMax = -34.5;
var latitudMin = -34.6;
var longitudMax = -58.45;
var longitudMin = -58.57;
function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  }
}

function showPosition(position) {
	elemLatitud.value = position.coords.latitude;
  	elemLongitud.value = position.coords.longitude;
}
function getFakeLocation() {
	elemLatitud.value = (Math.random() * (latitudMax - latitudMin) + latitudMin).toFixed(8);
	elemLongitud.value = (Math.random() * (longitudMax - longitudMin) + longitudMin).toFixed(8);
}