package pr1.a03;

import java.io.PrintWriter;

import pr1.a02.Schachbrett;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

public class TestSchachbrett {

	public static void main(String[] args) {
	printSchachbrett("Schachbrett",false);	

	}
	public static void printSchachbrett(String filename, boolean isReverse){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter("./Data/"+filename+".txt"));
		
		if (isReverse){
			Schachbrett.printSchachbrettReverse(fout);
			
		}else{
			Schachbrett.printSchachbrett(fout);
		}
	}
}
