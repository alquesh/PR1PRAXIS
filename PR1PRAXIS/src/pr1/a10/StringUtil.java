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
		File testfile = new File("./testfiles/teststring.txt");
		
		
		out.println("aB cD   eF gH  ");
		out.printf("Uppercase Count  = %d\n", getUpperCaseCount(test));
		out.printf("Whitespace Ratio = %5.2f\n", getRatioWhitespace(test)*100);
		out.println("----------------------------");
		
		out.println("aB cD   eF gH  ");
		out.printf("Uppercase Count  = %d\n", getUpperCaseCount(testfile));
		out.printf("Whitespace Ratio = %5.2f\n", getRatioWhitespace(testfile)*100);
		out.println("----------------------------");
		
		
		String[] teststrings = createTestStrings01(6, 15, 25);
		for(String s : teststrings){
			out.println(s);
			out.printf("Uppercase Count  = %d\n", getUpperCaseCount(s));
			out.printf("Whitespace Ratio = %5.2f\n", getRatioWhitespace(s)*100);
			out.println("----------------------------");
		}
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
	
	public static String[] createTestStrings01(int i, int min, int max){				
		//creates a String[] with i elements with min - max range of length,
		//a random amount of Uppercase Letters and Whitespaces in random intervals 
		
		String[] ergebnis = new String[i];												
		Random generator = new Random();												
		for (int counter = 0; counter <= i-1; counter++){								
			ergebnis[counter] = createTestString(generator.nextInt(max-min)+min,generator); 
		}
		return ergebnis;
	}
	
	public static String createTestString(int i, Random generator){	
		String ergebnis = "";
		for (int counter = 1; counter <= i; counter++){
			ergebnis = ergebnis + createTestchar(generator);
			if (counter % (generator.nextInt(3)+3) == 0){
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