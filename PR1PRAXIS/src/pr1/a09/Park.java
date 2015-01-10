package pr1.a09;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

public class Park implements Drawable {

	public ArrayList<Pflanze> Park;
	protected Random generator;
	protected int maxBlumen;
	protected int maxStr�ucher;
	protected int maxB�ume;
	protected int currentBlumen;
	protected int currentStr�ucher;
	protected int currentB�ume;
	protected int activity;

	public Park(ArrayList<Pflanze> park) {
	Park = park;
	}
	
	public Park(int anzahl,Random generator){
		maxB�ume=anzahl;
		maxStr�ucher=2*anzahl;
		maxBlumen=3*anzahl;
		Park= new ArrayList<Pflanze>();
		this.generator=generator;
		currentBlumen=0;
		currentStr�ucher=0;
		currentB�ume=0;
		generateB�ume();
		generateStr�ucher();
		generateBlumen();
		activity=0;
	
	
	}

	public void generateB�ume(){																									//generiert einen Baum, der sofern er einen
		int out=0;																													//geeigneten abstand zu allen anderen pflanzen hat
		while(currentB�ume<maxB�ume){																								//dem wald hinzugef�gt wird
			Baum Candidate = new Baum(generator.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width-80)+80,1,generator);
			out++;
			if (this.validproximity(Candidate)){
				this.add(Candidate);
				currentB�ume++;
			}
			if(out >=100) break;
		}
	}
	
	public void generateStr�ucher(){																								// wie oben
		int out=0;
		while(currentStr�ucher<maxStr�ucher){
			Strauch Candidate = new Strauch(generator.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width-80)+80,1,generator);
			out++;
			if (this.validproximity(Candidate)){
				this.add(Candidate);
				currentStr�ucher++;
			}
			if(out >=100) break;
		}
	}	
	
	public void generateBlumen(){																									//wie oben
		int out=0;
		while(currentBlumen<=maxBlumen){
			Blume Candidate = new Blume(generator.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width-80)+80,1,generator);
			out++;
			if (this.validproximity(Candidate)){
				this.add(Candidate);
				currentBlumen++;
			}
			if(out >=100) break;
		}
	}
	
	public void generateBlumen(int monat){																							// wie oben nur mit monatsparameter f�r neubev�lkerung
		int out=0;																													//am jahresbeginn
		while(currentBlumen<=maxBlumen){
			Blume Candidate = new Blume(generator.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width-80)+80,1,generator,monat);
			out++;
			if (this.validproximity(Candidate)){
				this.add(Candidate);
				currentBlumen++;
			}
			if(out >=100) break;
		}
	}
	
	public void add(Pflanze pflanze){
		this.Park.add(pflanze);
	}

	public void changeActivityTo(int x){
		activity=x;
		for(Pflanze b : this.Park){
			b.changeActivityTo(x);
		}
		if (activity==120){
			clearBlumen();
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Pflanze b : this.Park){
			b.draw(g);
		}
		
	}
	public boolean validproximity(Pflanze b){
		boolean result=true;
		if (this.Park==null){
			return result;
		}
		for (Pflanze a : this.Park){
			
			int xproximity = a.getXCoordinate()-b.getXCoordinate();
			if (xproximity < 0) {
				xproximity = b.getXCoordinate()-a.getXCoordinate();
			}
			int yproximity = a.getYCoordinate()-b.getYCoordinate();
			if (yproximity < 0) {
				yproximity = b.getYCoordinate()-a.getYCoordinate();
			}
			if (a.getSubtype()==b.getSubtype()){
				yproximity=0	;
			}
			int proximity = (int) Math.sqrt(Math.pow(xproximity, 2)+Math.pow(yproximity, 2));
			if (proximity <= a.reference+b.reference){
				result=false;
			}
		}
		return result;
	}
	
	public void manage(){												
		ArrayList<Pflanze> deadElements = new ArrayList<Pflanze>();
		for (Pflanze a : this.Park){
			if(a.maxgrowth()){
				a.decay();
			}
			if(a.dead()){
				deadElements.add(a);
			}
		}
		for (Pflanze a : deadElements){
			String type = a.getSubtype();
			switch (type){
				case "Baum" :{
					currentB�ume--;
					this.Park.remove(a);
					generateB�ume();
					break;
				}
				case "Strauch" :{
					currentStr�ucher--;
					this.Park.remove(a);
					generateStr�ucher();
					break;
				}
				case "Blume" :{
					currentBlumen--;
					this.Park.remove(a);
					generateBlumen(activity/12);
					break;
				}
			}
			
		}
		
		if (activity/12>1){
			generateB�ume();
			generateStr�ucher();

		}
		
	}
	
	public void clearBlumen(){											//f�gt alle Pflanzen des Typs Blume einer Arrayliste hinzu und l�scht diese aus dem Park
		ArrayList<Pflanze> deadElements = new ArrayList<Pflanze>();		//Blumen werden daraufhin neu generiert
		for (Pflanze a : this.Park){
			if (a.getSubtype()=="Blume"){
				deadElements.add(a);
			}
		}
		for (Pflanze a : deadElements){
			currentBlumen--;
			this.Park.remove(a);
			generateBlumen(activity/12);
			
		}
	}

}
