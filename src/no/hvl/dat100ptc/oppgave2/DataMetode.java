package no.hvl.dat100ptc.oppgave2;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class DataMetode {

	public static void main(String[] args) {
		int t=31890;
		int t2=31910;
		double la=60.3853800;
		double lo=5.217207;
		double elv=5;
		
		GPSPoint P1=new GPSPoint(t,la,lo,elv);
		System.out.print("P1= "+P1.toString());
		System.out.println(P1.getTime());
		P1.setTime(t2);
		System.out.print(P1.toString());
		System.out.println(P1.getTime()+"\n");
		
		GPSDataConverter C1=new GPSDataConverter();
		String time="2017-08-13T08:52:26.000Z";
		String latitude="60.385390";
		String longitude="5.217217";
		String elevation="61.9";
		System.out.println(C1.toSeconds(time));
		GPSPoint P2= C1.convert(time, latitude, longitude,elevation);
		System.out.println("P2= "+P2.toString());
		
		int n=3;
		GPSData T1=new GPSData(n);
//		GPSData[] T2=new GPSData[n];
		skriveUtTab(T1.getGPSPoints());
		boolean p1=T1.insertGPS(P1);
		boolean p2=T1.insertGPS(P2);
		boolean p3=T1.insert("2017-08-13T08:55:35.000Z", "60.385405", "5.217237", "62.5");
		GPSPoint P3=T1.getGPSAntall((T1.antall-1));
		System.out.print("P3= "+P3.toString());
		
		System.out.println(p1+"\n"+p2+"\n"+p3);
		skriveUtTab(T1.getGPSPoints());
			
		T1.print();
		
		skriveUtTab1(GPSUtils.getLatitudes(T1.getGPSPoints()));
		skriveUtTab1(GPSUtils.getLongitudes(T1.getGPSPoints()));
//		System.out.println("distance=\t"+GPSUtils.distance(P2,P3)+" meter");
//		System.out.println("speed= \t\t"+GPSUtils.speed(P2,P3)+" Km/h");
		
//		System.out.println(String.format("distance= %10.2f meter",GPSUtils.distance(P2,P3)));
//		System.out.println(String.format("speed   = %10.2f Km/h\n",GPSUtils.speed(P2,P3)));
		
//		System.out.println(GPSUtils.formatDouble(GPSUtils.distance(P2,P3)));
//		System.out.println(GPSUtils.formatDouble(GPSUtils.speed(P2,P3)));
		
		String d= (GPSUtils.formatDouble(GPSUtils.distance(P1,P3)));
		String s=(GPSUtils.formatDouble(GPSUtils.speed(P1,P3)));
		System.out.println(String.format("distance= "+d+" meter"));
		System.out.println(String.format("speed   = "+s+" Km/h\n"));
		
		GPSComputer GC=new GPSComputer(T1.getGPSPoints());
		skriveUtTab(GC.getGPSPoints());
		double td= GC.totalDistance();
		String tds=(GPSUtils.formatDouble(td));
		System.out.println(String.format("tottal d= "+tds+" meter"));
		
		double te=GC.totalElevation();
		String tes=(GPSUtils.formatDouble(te));
		System.out.println(String.format("tottal e= "+tes+" meter"));
		
		double tt=GC.totalTime();
		String tts=(GPSUtils.formatDouble(tt));
		System.out.println(String.format("tottal t= "+tts+" seconds"));
		
		System.out.println();
		double[]GCspeedT=GC.speeds();
		skriveUtTab1(GCspeedT);
		
		System.out.println();
		double maxs=GC.maxSpeed();
		String maxss=(GPSUtils.formatDouble(maxs));
		System.out.println(String.format("maxspeed="+maxss+" Km/h\n"));
		
		System.out.println();
		double avs=GC.averageSpeed();
		String avss=(GPSUtils.formatDouble(avs));
		System.out.println(String.format("avarageS="+avss+" Km/h\n"));
		
		System.out.println();
		double w=80;
		int secs=C1.toSeconds(time);
		double spd=maxs;
		double GCKcal=GC.kcal(w, secs, spd);
		String GCKcals=(GPSUtils.formatDouble(GCKcal));
		System.out.println(String.format("GCKcal  =  "   +GCKcals));
		
		System.out.println();
		double tKcal= GC.totalKcal(w);
		String tKcals=(GPSUtils.formatDouble(tKcal));
		System.out.println(String.format("tKcal  =  "   +tKcals));
		
		System.out.println();
		GC.displayStatistics();
		
		
		
	}
	
	public static void skriveUtTab(GPSPoint[] gpsPoints) {
		System.out.print("[");
		for (int i=0; i<gpsPoints.length;i++) {
			if(i<gpsPoints.length-1) {
				System.out.print(gpsPoints[i]+ ",\t");	
			}else 
				{System.out.print(gpsPoints[i]+ "");
			}
		}System.out.print("]");
		System.out.println("\n");
	}
	public static void skriveUtTab1(double[] gpsPoints) {
		System.out.print("[");
		for (int i=0; i<gpsPoints.length;i++) {
			if(i<gpsPoints.length-1) {
				System.out.print(GPSUtils.formatDouble(gpsPoints[i])+ ",\t");	
			}else 
				{System.out.print(GPSUtils.formatDouble(gpsPoints[i])+ "");
			}
		}System.out.print("]");
		System.out.println("\n");
	}
} 
