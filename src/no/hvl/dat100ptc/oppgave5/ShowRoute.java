package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		return ystep;
	}

	public void showRouteMap(int ybase) {
		
		double xstep = xstep();
		double ystep = ystep();
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		setColor(0, 255, 0);
		
		int x, y, xprev, yprev;
		xprev = yprev = 0;
		for(int i = 0; i < gpspoints.length; i++) {
			x = MARGIN + (int) ((gpspoints[i].getLongitude() - minlon) * xstep);
			y = ybase - (int) ((gpspoints[i].getLatitude() - minlat) * ystep);

			if(i != 0)
				drawLine(xprev, yprev, x, y);

			if(i == gpspoints.length - 1) {
				setColor(0, 0, 255);
				fillCircle(x, y, 6);
			} else {
				fillCircle(x, y, 3);
			}

			xprev = x;
			yprev = y;
		}

	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		String drawStringArg;

		String totalTimeStr = GPSUtils.formatTime(gpscomputer.totalTime());
		drawStringArg = "Total Time     : " + totalTimeStr;
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE);

		double totalDistanceKm = gpscomputer.totalDistance() / 1000;
		String totalDistanceStr = GPSUtils.formatDouble(totalDistanceKm);
		drawStringArg = "Total distance : " + totalDistanceStr + " km";
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE * 2);

		String totalElevationStr = GPSUtils.formatDouble(gpscomputer.totalElevation());
		drawStringArg = "Total elevation: " + totalElevationStr + " m";
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE * 3);

		String maxSpeedStr = GPSUtils.formatDouble(gpscomputer.maxSpeed());
		drawStringArg = "Max speed      : " + maxSpeedStr + " km/t";
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE * 4);

		String averageSpeedStr = GPSUtils.formatDouble(gpscomputer.averageSpeed());
		drawStringArg = "Average speed  : " + averageSpeedStr + " km/t";
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE * 5);

		double weight = 80; // vi antar at syklisten er 80 kg
		String totalKcalStr = GPSUtils.formatDouble(gpscomputer.totalKcal(weight));
		drawStringArg = "Energy         : " + totalKcalStr + " kcal";
		drawString(drawStringArg, TEXTDISTANCE, TEXTDISTANCE * 6);
	}

}
