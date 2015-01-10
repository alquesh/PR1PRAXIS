package pr1.a07.mitSet;												//Alexander Biesdorf
																//820460
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import pr1.a06.Person;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
//import schimkat.berlin.lernhilfe2014ws.objectPlay.*;



public class Personen {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		
		//Aufgabe b)
		ArrayList<Person> PersonenListe = new ArrayList<Person>(createTestPersonliste()); 
		Set<Person> testPersonen = new HashSet<Person>();
		testPersonen.addAll(PersonenListe);
		
		//Aufgabe c)
		out.println("Aufgabe c)");
		printPersons(testPersonen,"./listen/testpersonen.txt");
		printPersons(testPersonen,out);
		out.println();
		
		//Aufgabe d)
		Set<Person> leseTest = new HashSet<Person>(getPersonsFrom("./listen/testpersonen.txt"));
		out.println("Aufgabe d)");
		printPersons(leseTest,out);
		out.println();
		
		//Aufgabe e)
		Set<Person> Komilitonen = new HashSet<Person>(getPersonsFrom("./listen/kommilitonen.txt"));
		Set<Person> Sportfreunde = new HashSet<Person>(getPersonsFrom("./listen/sportfreunde.txt"));
	
		//alle Sportfreunde die auch Kommilitonen sind
		Set<Person> SundK = new HashSet<Person>();
		SundK.addAll(Komilitonen);
		SundK.retainAll(Sportfreunde);
		printPersons(SundK, "./listen/SundK.txt");
		//alle Komilitonen die nicht Sportfreunde sind
		Set<Person> KaberNichtS = new HashSet<Person>();
		KaberNichtS.addAll(Komilitonen);
		KaberNichtS.removeAll(Sportfreunde);
		printPersons(KaberNichtS, "./listen/KaberNichtS.txt");
		//alle Testpersonen und Komilitonen
		Set<Person> TvereinigtK = new HashSet<Person>();
		TvereinigtK.addAll(Komilitonen);
		TvereinigtK.addAll(testPersonen);
		printPersons(TvereinigtK, "./listen/TvereinigtK.txt");
		
		
	}
	
	public static void printPersons(Set<Person> persons, PrintWriter out){
		for(Person p:persons){
			out.println(p);
		}
		
	}
	
	public static void printPersons(Set<Person> persons, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout);
		fout.close();
	}
	
	public static Person createPerson(Scanner dataSource){
		Person p = null;
		if (dataSource.hasNext()){
			p = new Person(dataSource.next(),dataSource.next(),dataSource.nextInt());
		}
		return p;
	}
	
	public static Set<Person> getPersonsFrom(Scanner dataSource){
		Set<Person> P = new HashSet<Person>();
		while (dataSource.hasNext()){
			P.add(createPerson(dataSource));
		}
		
		return P;
	}
	
	public static Set<Person> getPersonsFrom(String filename){
		Scanner in = new Scanner(new DirtyFileReader(filename));
		Set<Person> result = new HashSet<Person>(getPersonsFrom(in));
		in.close();
		return result;	
	}	
	
	public static ArrayList<Person> createTestPersonliste(){
		schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList p = new schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList(schimkat.berlin.lernhilfe2014ws.objectPlay.Factory.createTestPersonliste());
		ArrayList<Person> result = new ArrayList<Person>();
		for(schimkat.berlin.lernhilfe2014ws.objectPlay.Person pe:p){
			result.add(new Person(pe));
		}
		return result;
	}
}
