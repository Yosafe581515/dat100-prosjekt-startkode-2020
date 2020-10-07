package no.hvl.dat100ptc.oppgave2;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class DataMetode {

	public static void main(String[] args) {
		int t=1;
		int t2=2;
		double la=30;
		double lo=60;
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
		boolean p3=T1.insert("2017-08-13T08:55:36.000Z", "60.385490", "5.217317", "62.5");
		GPSPoint P3=T1.getGPSAntall((T1.antall-1));
		System.out.print("P3= "+P3.toString());
		
		System.out.println(p1+"\n"+p2+"\n"+p3);
		skriveUtTab(T1.getGPSPoints());
			
		T1.print();
		
		
		
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

}
