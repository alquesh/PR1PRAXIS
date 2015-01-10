package pr1.a03;

import java.io.PrintWriter;

public class Hypothenuse {
	
	public static void main(String[] args) {
	PrintWriter out = new PrintWriter(System.out, true);
	printHypothenuse(5,5,5,5,out);
	out.println();
	testHypothenuse(7,2,out);
	}
	
	public static double hypothenuse(double k1, double k2){
		return(Math.sqrt(Math.pow(k1, 2)+Math.pow(k2, 2)));
	}
	
	public static void printHypothenuse(double k1, double k2, int width, int precision, PrintWriter out){
		
		out.printf("%"+width+"."+precision+"f",hypothenuse(k1,k2));
	}
	
	public static void testHypothenuse(int width, int precision, PrintWriter out){
		for(int y=0;y<=10;y++){
			for(int x=0;x<=10;x++){
				
				printHypothenuse(x,y, width, precision, out);
			}
			out.println();
		}
	}
}
