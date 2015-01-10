package pr1.a02;

import java.io.PrintWriter;

public class SomeFunctions {
	
	public static void main(String[] args) {
	PrintWriter out = new PrintWriter(System.out, true);
	int x=5;
	int y=6;
	out.println("Der Umfang eines Kreises mit dem Radius "+x+"cm ist "+kreisUmfang(x)+"cm.");
	out.println("Der Umfang eines Rechteckes mit den Seitenlängen "+x+"cm und "+y+"cm ist "+rechteckUmfang(x,y)+"cm.");
	out.println("Die Fläche eines Rechtecks mit den Seitenlängen "+x+"cm und "+y+"cm ist "+rechteckFlaeche(x,y)+"cm².");
	}
	
	public static double kreisUmfang(double radius){
		
		return 2*Math.PI*radius;
	}
	
	public static double rechteckUmfang(double a, double b){
		
		
		return (2*a)+(2*b);
	}
	
	public static double rechteckFlaeche(double a, double b){
		
		return a*b;
	}
}
