package no.hvl.dat100ptc.oppgave2;
import static java.lang.Integer.*;
import static java.lang.Double.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int hr=subStringInt(timestr, 11, 13);
		int min=subStringInt(timestr,14,16);
		int sec=subStringInt(timestr,17,19);
		
		int secs=(hr*3600)+(min*60)+sec;
		return secs;
	}
	public static int subStringInt(String s, int a, int b) {
		String sub=s.substring(a,b);
		int r=parseInt(sub);
		return r;
	}
	

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		
		GPSPoint gpspoint=new GPSPoint(toSeconds(timeStr),parseDouble(latitudeStr),parseDouble(longitudeStr),parseDouble(elevationStr));


	    return gpspoint;
	}
	
}
