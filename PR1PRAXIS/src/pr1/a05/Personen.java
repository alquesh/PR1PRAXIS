package pr1.a05;												//Alexander Biesdorf
																//820460
import java.io.PrintWriter;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2014ws.objectPlay.*;



public class Personen {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		
		//Aufgabe b)
		PersonList PersonenListe = new PersonList(Factory.createTestPersonliste()); 
		PersonSet testPersonen = new PersonSet();
		testPersonen.addAll(PersonenListe);
		
		//Aufgabe c)
		out.println("Aufgabe c)");
		printPersons(testPersonen,"./listen/testpersonen.txt");
		printPersons(testPersonen,out);
		out.println();
		
		//Aufgabe d)
		PersonSet leseTest = new PersonSet(getPersonsFrom("./listen/testpersonen.txt"));
		out.println("Aufgabe d)");
		printPersons(leseTest,out);
		out.println();
		
		//Aufgabe e)
		PersonSet Komilitonen = new PersonSet(getPersonsFrom("./listen/kommilitonen.txt"));
		PersonSet Sportfreunde = new PersonSet(getPersonsFrom("./listen/sportfreunde.txt"));
	
		//alle Sportfreunde die auch Kommilitonen sind
		PersonSet SundK = new PersonSet();
		SundK.addAll(Komilitonen);
		SundK.retainAll(Sportfreunde);
		printPersons(SundK, "./listen/SundK.txt");
		//alle Komilitonen die nicht Sportfreunde sind
		PersonSet KaberNichtS = new PersonSet();
		KaberNichtS.addAll(Komilitonen);
		KaberNichtS.removeAll(Sportfreunde);
		printPersons(KaberNichtS, "./listen/KaberNichtS.txt");
		//alle Testpersonen und Komilitonen
		PersonSet TvereinigtK = new PersonSet();
		TvereinigtK.addAll(Komilitonen);
		TvereinigtK.addAll(testPersonen);
		printPersons(TvereinigtK, "./listen/TvereinigtK.txt");
		
		
	}
	
	public static void printPersons(PersonSet persons, PrintWriter out){
		for(Person p:persons){
			out.println(p);
		}
		
	}
	
	public static void printPersons(PersonSet persons, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout);
		fout.close();
	}
	
	public static Person createPerson(Scanner dataSource){
		Person P = null;
		if (dataSource.hasNext()){
			P = new Person(dataSource.next(),dataSource.next(),dataSource.nextInt());
		}
		return P;
	}
	
	public static PersonSet getPersonsFrom(Scanner dataSource){
		PersonSet P = new PersonSet();
		while (dataSource.hasNext()){
			P.add(createPerson(dataSource));
		}
		
		return P;
	}
	
	public static PersonSet getPersonsFrom(String filename){
		Scanner in = new Scanner(new DirtyFileReader(filename));
		return getPersonsFrom(in);	
	}	
}
