package pr1.ue02;

import java.io.PrintWriter;

public class HelloNumbers {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		//someWhileLoops(out);
		for(int i=1;i<5;i++){
			someExpressions(out,i);
		}
		
	}
	
	public static void someWhileLoops(PrintWriter out){
		int x = 7;
		while (x>0){
			out.print(", x: "+x);
			out.flush();
			x/= 2;
		}
		out.println(" ***");
		
		x=19;
		while (x>5){
			out.print("x: "+x);
			out.flush();
			x--;
			x=x+3;
			x/=2;
			x=x+3;
		}
		out.println("b b b");
		}
	
	public static void someExpressions(PrintWriter out,int x){
	double A1 = Math.pow(7,5);
	double A2 = Math.pow(7,5+3);
	double A3 = Math.pow(7,Math.pow(9,4));
	double A6 = Math.exp(x)+Math.sin(x)+Math.sqrt(x);
	out.println("7 hoch 5 ist "+A1);
	out.println("7 hoch (5+3) ist "+A2);
	out.println("7 hoch (9 hoch 4) ist "+A3);
	out.println("e^"+x+" + sin("+x+")+ cos("+x+") ist "+A6);
	}
	
}
