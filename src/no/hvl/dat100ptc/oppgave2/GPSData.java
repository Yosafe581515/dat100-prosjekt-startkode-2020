package no.hvl.dat100ptc.oppgave2;
import static java.lang.Integer.*;
import static java.lang.Double.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;
	
	public GPSData() {

		GPSPoint[] gpspoints;
		antall=0;
	}

	public GPSData(int n) {

		gpspoints=new GPSPoint[n];
		antall=0;
	}

	public GPSPoint[] getGPSPoints() {
		return gpspoints;
	}
	
	public GPSPoint getGPSAntall(int antall) {
		return gpspoints[antall];
	}
	
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		if(antall < gpspoints.length) {
			gpspoints[antall]=gpspoint;
			antall++;
			inserted = true;
		}	
		return inserted;
	}
	

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint= GPSDataConverter.convert(time,latitude,longitude,elevation);
		boolean sattinn=insertGPS(gpspoint);
		
		return sattinn;
	}
	

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for(GPSPoint v: gpspoints) {
			System.out.println(v.toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
