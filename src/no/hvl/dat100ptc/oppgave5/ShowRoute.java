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

//		playRoute(MARGIN + MAPYSIZE);
		
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
	
		double ystep;
		
		// TODO - START
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		double[] latitudes = GPSUtils.getLatitudes(gpspoints); 
		double[] longitudes = GPSUtils.getLongitudes(gpspoints); 
		
		for(int i = 0; i<gpspoints.length-1; i++) {
		    double y = latitudes[i];
		    double x = longitudes[i]; 
		    double y2 = latitudes[i+1];
		    double x2 = longitudes[i+1]; 
		    
		    int xpos = (int)((x - GPSUtils.findMin(longitudes))* xstep()); 
		    int ypos = (int)((GPSUtils.findMax(latitudes)-y)* ystep()); 
		    
		    int xpos2 = (int)((x2 - GPSUtils.findMin(longitudes))* xstep()); 
		    int ypos2 = (int)((GPSUtils.findMax(latitudes)-y2)* ystep()); 
		    
		    if(i==gpspoints.length-2) {
		        setColor(0,0,255); 
		        fillCircle(xpos,MARGIN+ypos,3);
		        drawLine(xpos, ypos, xpos2, ypos2); 
		    }else {
		        setColor(0,255,0); 
		        fillCircle(xpos, MARGIN+ypos,3); 
		        drawLine(xpos, ypos, xpos2, ypos2); 
		    }
		    
		}
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		drawString("Total Time     :" + GPSUtils.formatTime(gpscomputer.totalTime()), TEXTDISTANCE, 60);  
        drawString(("Total Distance :" + GPSUtils.formatDouble(gpscomputer.totalDistance()) + " km"), TEXTDISTANCE, 70);
        drawString(("Total Elevation:" +GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m" ), TEXTDISTANCE, 80);
		drawString(("Max Speed      :" +GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t"), TEXTDISTANCE, 90);
		drawString(("Average Speed  :" +GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t"), TEXTDISTANCE, 100);
		drawString(("Energy         :" + GPSUtils.formatDouble(gpscomputer.totalKcal(80.0)) + " kcal"), TEXTDISTANCE, 110);
		// TODO - SLUTT;
	}

//	public void playRoute(int ybase) {
//
//		// TODO - START
//		for(int i=0; i < gpspoints.length; i++) {
//			
//		}
//		
//		// TODO - SLUTT
//	}

}
