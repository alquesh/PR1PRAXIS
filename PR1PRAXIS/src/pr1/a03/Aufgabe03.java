package pr1.a03;

import java.io.PrintWriter;
import java.util.Locale;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

public class Aufgabe03 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		writeIntNumberFile("Text1",1000);
		writeMixedNumberFile("Text2",1000,10);
	}

	public static void writeIntNumberFile(String filename, int numbercount){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter("./Data/"+filename+".txt"));
		int count=evenNumber(numbercount);
		
		for (int i=1;i<=count;i++){
			fout.printf("%5d",i);
			if(i%10==0){
				fout.println();
			}
		}
		fout.close();
	}
	
	public static void writeMixedNumberFile(String filename, int numbercount, int width){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter("./Data/"+filename+".txt"));
		int count=evenNumber(numbercount);
		
		for (int i=1;i<=count;i++){
			if (coinFlip()){
				fout.printf("%"+width+"d ",randomInt(1,count));
			}else{
				fout.printf("%"+width+"."+2+"f ", randomDouble(1,count));
			}
			if(i%10==0){
				fout.println();
			}
		}
		fout.close();
	}
	
	public static boolean coinFlip(){
	int coin=(int)(Math.random()*2);
	if (coin==0){
		return true;
	}else{
		return false;	
	}
	}
	
	public static int randomInt(int min, int max){
		return (int)(Math.random()*(max-min)+min);
	}
	
	public static double randomDouble(int min, int max){
		return (Math.random()*(max-min)+min);
	}
	
	public static int evenNumber(int number){
		if (number%2==1){
			number++;
		}
		return number;
	}
	
	}
	

