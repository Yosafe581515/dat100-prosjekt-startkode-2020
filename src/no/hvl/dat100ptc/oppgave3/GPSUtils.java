package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {
		double min; 
		min = da[0];
			for (double d : da) {
				if (d < min) {
					min = d;
				}
			}
		return min;
	}
	

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double [] gpspointsLa=new double[gpspoints.length];
		
		for (int i=0;i< gpspointsLa.length;i++) {
			gpspointsLa[i]=gpspoints[i].getLatitude();
		}
		
		return gpspointsLa;
	}

	
	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double [] gpspointsLo=new double[gpspoints.length];
		
		for (int i=0;i< gpspointsLo.length;i++) {
			gpspointsLo[i]=gpspoints[i].getLongitude();
		}
		
		return gpspointsLo;
	}
	
	

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		
		double d;
		double latitude1, longitude1, latitude2, longitude2;
		latitude1=toRadians(gpspoint1.getLatitude());
		longitude1=toRadians(gpspoint1.getLongitude());
		latitude2=toRadians(gpspoint2.getLatitude());
		longitude2=toRadians(gpspoint2.getLongitude());
		
		double q=latitude2-latitude1;
		double l=longitude2-longitude1;
		
		double a= pow(sin(q/2), 2)+cos(latitude1)*cos(latitude2)*pow(sin(l/2),2);
		double c=2*atan2(sqrt(a),sqrt(1-a));
		d=R*c;
		
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
