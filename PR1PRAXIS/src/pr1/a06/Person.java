package pr1.a06;

public class Person {
	protected String vorname;
	protected String nachname;
	protected int geburtsjahr;
	
	public Person (String vorname, String nachname, int geburtsjahr){
		this.vorname=vorname;
		this.nachname=nachname;
		this.geburtsjahr=geburtsjahr;
	}
	
	public Person (Person that){
		this(that.vorname,that.nachname,that.geburtsjahr);
	}
	
	public Person (schimkat.berlin.lernhilfe2014ws.objectPlay.Person that){
		this(that.getVorname(),that.getNachname(),that.getGeburtsjahr());
	}
	
	public String getVorname(){
		return this.vorname;
	}
	
	public String getNachname(){
		return this.nachname;
	}
	
	public int getGeburtsjahr(){
		return this.geburtsjahr;
	}
	
	public String toString(){
		return this.vorname+" "+this.nachname+" "+this.geburtsjahr;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	public static void main(String[] args) {
		

	}
	
	

}
