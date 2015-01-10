package pr1.a07.mitCollection;

import java.util.Comparator;

import pr1.a06.Person;

public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person S1, Person S2) {
		int comp=(S1.getNachname()).compareTo(S2.getNachname());
		if (comp != 0){
			return comp;	
		}
		comp=S1.getVorname().compareTo(S2.getVorname());
		if (comp != 0){
			return comp;	
		}
		comp = S1.getGeburtsjahr()-S2.getGeburtsjahr();	
		return comp;
	}

	
}
