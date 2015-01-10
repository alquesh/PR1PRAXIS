package pr1.a04;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

public class FirstInput {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		scannerAusprobieren();

	}
	
	public static void scannerAusprobieren(){
		String intNumbers="1 2 3 4 5 6 7 8 9";
		String doubleNumbers="1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0";
		String mixedNumbers="1 2.0 2 5.0 7 9.0";
		DirtyFileReader DFR = new DirtyFileReader("./testfiles/zahlen01.txt");
		Scanner in1 = new Scanner(intNumbers);
		Scanner in2 = new Scanner(doubleNumbers);
		Scanner in3 = new Scanner(mixedNumbers);
		Scanner in4 = new Scanner(DFR);
		PrintWriter out = new PrintWriter(System.out,true);
		Scanner in5 = new Scanner(new DirtyFileReader("./Data/Text2.txt"));
		printScannerTable(in1, out);
		printScannerTable(in2, out);
		printScannerTable(in3, out);
		printScannerTable(in4, out);
		//out.println(countSumOf(in1));
		printNumbersFrom(in5, 7, 2, out);
		//copyNumberFile(in5, 8, 3, "test3");
	}
	public static void printScannerTable(Scanner input, PrintWriter output){
		int count=0;
		while (input.hasNext()){
			
			if (input.hasNextInt()){
				count++;
				 output.printf("%2d. Zahl %2d%n",count , input.nextInt());
				//output.println(count+". Zahl : "+input.nextInt());
				continue;
			
			} else {
				count++;
				output.printf("%2d. Zahl %5.2f%n",count , input.nextDouble());
				//output.println(count+". Zahl : "+input.nextDouble());
			}
			
		}
		input.close();
		output.println();
	}
	
	public static int countSumOf(Scanner in){
		double result = 0;
		while (in.hasNext()){
			if (in.hasNextInt()){
				result=result+in.nextInt();
			}else{
				result=result+in.nextDouble();
			}
		}
		return (int)result;
	}
	
	public static int countSumOf(String filename){
		DirtyFileReader DFR = new DirtyFileReader(filename);
		Scanner in = new Scanner(DFR);
		return countSumOf(in);
	}
	
	public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out){
		while (in.hasNext()){
			for(int i=1;i<=10;i++){
				if (in.hasNextInt()){
					out.printf("%"+width+"d", in.nextInt());
				}else{
					out.printf("%"+width+"."+precision+"f", in.nextDouble());
				}
			}
			out.println();
			
		}
		in.close();
	}
	
	public static void copyNumberFile(Scanner in, int newwidth, int newprecision, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter("./testfiles/"+filename+".txt"));
		while (in.hasNext()){
			for(int i=1;i<=10;i++){
				if (in.hasNextInt()){
					fout.printf("%"+newwidth+"d", in.nextInt());
				}else{
					fout.printf("%"+newwidth+"."+newprecision+"f", in.nextDouble());
				}
			}
			fout.println();
			
		}
		fout.close();
		in.close();
	}


}
