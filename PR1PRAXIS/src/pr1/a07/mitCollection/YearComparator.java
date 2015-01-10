package pr1.a07.mitCollection;

import java.util.Comparator;

import pr1.a06.Person;

public class YearComparator implements Comparator<Person>{

	@Override
	public int compare(Person S1, Person S2) {
		
		return S1.getGeburtsjahr()- S2.getGeburtsjahr();
	}

}
