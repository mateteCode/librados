package utils;

public class Distancia {
	public static String haversine(double lon1, double lat1, double lon2, double lat2) {
		final double earthRadius = 6371; // km

		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		double sinlat = Math.sin((lat2 - lat1) / 2);
		double sinlon = Math.sin((lon2 - lon1) / 2);

		double a = (sinlat * sinlat) + Math.cos(lat1)*Math.cos(lat2)*(sinlon*sinlon);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		double distanceInMeters = earthRadius * c * 1000;
		String strDistancia;
		if(distanceInMeters < 1000) strDistancia = String.valueOf(Math.round(distanceInMeters)) + "m";
		else strDistancia = String.format( "%.1f", (distanceInMeters/1000)) + "km";
		return strDistancia;
		}
	public static void main(String [] args) {
		double lon1 = 58.48624563;
		double lat1 = 34.58134516;
		double lon2 = 58.48624563;
		double lat2 = 34.58134516;
		System.out.println(Distancia.haversine(lon1, lat1, lon2, lat2));
	}
}
