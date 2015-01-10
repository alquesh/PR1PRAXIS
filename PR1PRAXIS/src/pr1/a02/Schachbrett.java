package pr1.a02;

import java.io.PrintWriter;

public class Schachbrett {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("#------Spieler1-------#");
		printSchachbrett(out);
		out.println("#---------------------#");
		printSchachbrettReverse(out);
		out.println("#------Spieler2-------#");
	}
	
	public static void printSchachbrett(PrintWriter out){
		for(char c='H';c >='A';c--){
			for(int i=1;i<=8;i++){
				out.print(c);
				out.print(i+" ");
				out.flush();
			}
			out.println();
		}
	}
	
	public static void printSchachbrettReverse(PrintWriter out){
		for(char c='A';c <='H';c++){
			for(int i=8;i>=1;i--){
				out.print(c);
				out.print(i+" ");
				out.flush();
			}
			out.println();
		}
	}
}

