package utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class Tiempo {
	public static String periodo(LocalDateTime dt) {
		String strTiempo;
		Duration duracion = Duration.between(dt, LocalDateTime.now());
		if(duracion.toMinutes() < 60) strTiempo = duracion.toMinutes() + "m";
		else if(duracion.toHours() < 24) strTiempo = duracion.toHours() + "h";
		else if(duracion.toDays() < 365) strTiempo = duracion.toDays() + "d";
		else {
			int tiempoTemp = Math.round(duracion.toDays()/365);
			strTiempo = String.valueOf(tiempoTemp);
		}
		return strTiempo;
	}
}
