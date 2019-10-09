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

		// TODO - START
		min = da[0];
		
		for(double d : da) {
			if(d < min) {
				min = d;
			}
		}
		return min;
		// TODO - SLUT
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] ny = new double[gpspoints.length];
		for(int i=0; i < gpspoints.length; i++) {
			ny[i] = gpspoints[i].getLatitude();
		}
		return ny;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] ny = new double[gpspoints.length];
		for(int i=0; i < gpspoints.length; i++) {
			ny[i] = gpspoints[i].getLongitude();
		}
		return ny;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		int r = 6371000;
		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		double theta1 = toRadians(latitude1);
		double theta2 = toRadians(latitude2);
		double delta1 = latitude2 - latitude1;
		double delta2 = longitude2 - longitude1;
		double a = pow(sin(delta1/2),2) + cos(theta1) * cos(theta2) * pow(sin(delta2/2),2);
		double c = 2* atan2(sqrt(a), sqrt(1-a));
		d = r * c;
		return d;
		// TODO - SLUTT

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
