package pr1.a06;

import java.io.PrintWriter;

public class PersonTest {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		Person vollK = new Person("Alexander","Biesdorf",1987);
		Person copyK = new Person(vollK);
		schimkat.berlin.lernhilfe2014ws.objectPlay.Person konvS = 
				new schimkat.berlin.lernhilfe2014ws.objectPlay.Person("Alexander","Biesdorf",1987);
		Person konvK = new Person(konvS);
		out.println(vollK.toString());
		out.println(copyK.toString());
		out.println(konvK.toString());
	}	
}
