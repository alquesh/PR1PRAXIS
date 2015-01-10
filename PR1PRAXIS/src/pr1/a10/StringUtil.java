package pr1.a10;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;

public class StringUtil {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		String test = "aB cD   eF gH  ";
		String[] teststrings = new String[6];
		teststrings = createTestStrings01(6);
		for(int i = 0; i <= 5 ;i++){
			out.println(teststrings[i]);
			out.printf("Uppercase Count  = %d\n", getUpperCaseCount(teststrings[i]));
			out.printf("Whitespace Ratio = %5.2f\n", getRatioWhitespace(teststrings[i])*100);
			out.println("----------------------------");
		}
//		out.println(getUpperCaseCount(test));
//		out.println(getRatioWhitespace(test));
//		File Testfile = new File("./testfiles/teststring.txt");
//		out.println(getUpperCaseCount(Testfile));
//		out.println(getRatioWhitespace(Testfile));
	}
	public static int getUpperCaseCount(String s){
		int ergebnis = 0;
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			if (Character.isUpperCase(c)){
				ergebnis++;
			}
		}
		return ergebnis;
	}
	
	public static double getRatioWhitespace(String s){
		double countWhiteSpace=0;
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if (Character.isWhitespace(c)){
				countWhiteSpace++;
			}
		}
		return countWhiteSpace/s.length();
	}
	
	public static String[] createTestStrings01(int i){
		String[] ergebnis = new String[i];
		Random generator = new Random();
		for (int counter = 0; counter <= i-1; counter++){
			ergebnis[counter] = createTestString(generator.nextInt(15)+10,generator); 
		}
		return ergebnis;
	}
	
	public static String createTestString(int i, Random generator){
		String ergebnis = "";
		for (int counter = 1; counter <= i; counter++){
			ergebnis = ergebnis + createTestchar(generator);
			if (counter % (generator.nextInt(5)+1) == 0){
				ergebnis = ergebnis + ' ';
				counter++;
			}
		}
		return ergebnis;
	}
	
	public static char createTestchar(Random generator){
		boolean uppercase = generator.nextBoolean();
		char ergebnis ='a'; 
		if (uppercase){
			ergebnis = (char) ('A'+ generator.nextInt(25));
		} else {
			ergebnis = (char) ('a'+ generator.nextInt(25));
		}
		return ergebnis;
	}
	
	public static int getUpperCaseCount(File textfile){
		Scanner in = new Scanner(new DirtyFileReader(textfile));
		int ergebnis = 0;
		while (in.hasNextLine()){
			String batch = in.nextLine();
			ergebnis = ergebnis + getUpperCaseCount(batch);
		}
		in.close();
		return ergebnis;
	}
	
	public static double getRatioWhitespace(File textfile){
		Scanner in = new Scanner(new DirtyFileReader(textfile));
		double whitespacesum = 0;
		int	iterrationcounter = 0;
		while (in.hasNextLine()){
			String batch = in.nextLine();
			whitespacesum = whitespacesum + getRatioWhitespace(batch);
			iterrationcounter++;
	 		}
		in.close();
		return whitespacesum / iterrationcounter;
	}
}