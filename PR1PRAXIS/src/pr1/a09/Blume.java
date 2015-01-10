package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class Blume extends Pflanze{
	protected int radius;										//Radius der Krone
	protected BasePoint center;									//Mittelpunkt der Krone 
	protected int wachstumsrate;
	protected final int maxWachstum= 8;
	
	protected Color[] blätterfarbe = new Color[12];
	protected Color braun = new Color(222,184,135);
	protected Color winterSpringTransition= new Color(190,250,125);
	protected Color spring = new Color(124, 252, 0);
	protected Color summer = new Color(34,139,34);
	protected Color summerAutumTransition = new Color(122,122,32);
	protected Color autum = new Color(210, 105, 30);
	protected Color snow = new Color(255,250,250);
	protected Color test = new Color(0,0,0,0);
	protected Color currentColor;
	
	
	protected ArrayList<BasePoint> Früchte = new ArrayList<BasePoint>(); 
	
	//protected int früchtecounter;
	
	protected int activity;
	protected int monat;
	protected int alter;
	
	
	public Blume(int x, int wachs, Random generator){
		radius=2;
		center=new BasePoint(x,(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.8+radius));
		wachstumsrate = wachs;
		blätterfarbe[0]=test;
		blätterfarbe[1]=snow;
		blätterfarbe[2]=snow;
		blätterfarbe[3]=snow;
		blätterfarbe[4]=Color.YELLOW;
		blätterfarbe[5]=Color.YELLOW;
		blätterfarbe[6]=Color.YELLOW;
		blätterfarbe[7]=Color.red;
		blätterfarbe[8]=Color.red;
		blätterfarbe[9]=Color.red;
		blätterfarbe[10]=test;
		blätterfarbe[11]=test;
		currentColor=test;
		activity = 0;
		monat = 0;
		alter=0;
		decay=0;
		reference=2*maxWachstum;
		this.generator=generator;
	}
	
	public Blume(int x, int wachs, Random generator,int monat){
		radius=2;
		center=new BasePoint(x,(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.8+radius));
		wachstumsrate = wachs;
		this.monat = monat;
		blätterfarbe[0]=test;
		blätterfarbe[1]=snow;
		blätterfarbe[2]=Color.blue;
		blätterfarbe[3]=Color.blue;
		blätterfarbe[4]=Color.YELLOW;
		blätterfarbe[5]=Color.YELLOW;
		blätterfarbe[6]=Color.YELLOW;
		blätterfarbe[7]=Color.red;
		blätterfarbe[8]=Color.red;
		blätterfarbe[9]=Color.red;
		blätterfarbe[10]=test;
		blätterfarbe[11]=test;
		currentColor=blätterfarbe[monat];
		activity = 0;
		
		alter=0;
		decay=0;
		reference=2*maxWachstum;
		this.generator=generator;
	}
	
	@Override
	public void draw(Graphics g) {
		
		if (this.monat>=1 && this.monat <=10){
			this.drawStamm(g);
			this.drawKrone(g);
			g.setColor(Color.blue);
			for (BasePoint p : Früchte){
				g.fillOval(p.x-4, p.y-4, 5, 5);
			}
		}
	}
		
	public void drawKrone(Graphics g){				//draws a filled circle based on the center point and the radius
		g.setColor(Color.white);
		g.fillOval(center.x-radius, 
				   center.y-radius, 
				   			radius*2, 
				   			radius*2);
		g.setColor(currentColor);
		g.fillOval(center.x-(radius+1), 
				   center.y-(radius+1), 
				   			radius, 
				   			radius);
		g.fillOval(center.x+1, 
				   center.y+1, 
				   			radius, 
				   			radius);
		g.fillOval(center.x+1, 
				   center.y-(radius+1), 
				   			 radius, 
				   			 radius);
		g.fillOval(center.x-(radius+1), 
				   center.y+1, 
				   			 radius, 
				   			 radius);
		g.fillOval(center.x-radius/2, 
				   (int)(center.y-1.5*radius), 
				   			 radius, 
				   			 radius);
		g.fillOval(center.x-radius/2, 
				   (int)(center.y+0.5*radius), 
				   			 radius, 
				   			 radius);
		g.fillOval((int)(center.x+0.5*radius), 
				   center.y-radius/2, 
				   			 radius, 
				   			 radius);
		g.fillOval((int)(center.x-1.5*radius), 
				   center.y-radius/2, 
				   			 radius, 
				   			 radius);
		
//		g.fillOval(center.x+radius, 
//				   center.y-radius, 
//				   			radius, 
//				   			radius);
//		g.fillOval(center.x-radius, 
//				   center.y+radius, 
//				   			radius, 
//				   			radius);
		
	}
	
	public void drawStamm(Graphics g){				//draws a filled rectangle based on the center point and the radius
		g.setColor(this.spring);
		g.fillRect(center.x-(radius/4), 
				   center.y+(radius/4), 
				   radius/2, 
				   (radius*4-radius/4));
	}

	@Override
	public void waechst() {							//increases the size of the radius by the growth rate if maximum growth
		if (radius<maxWachstum){					//hasn't been achieved
			radius += wachstumsrate;
			center.moveRel(0, -wachstumsrate*2);
		}
	}

	@Override
	public void changeActivityTo(int x) {			//advances the time for the tree if a "month" has passed it will change  
		activity=x;									//the color of the leaves to the appropriate one
		if (activity%12==0){
			this.setMonth(activity);
			this.setLeaveColor(monat);
		}
		 	this.growthCheck();
						
	}
	
	public void growthCheck(){
		if (this.monat >= 1 && this.monat <= 10){
			this.waechst();
		}
//		if (this.monat >= 6 && this.monat <= 8){
//			this.addFrucht();
//		}
//		if (this.monat >= 8 && this.monat <= 10){
//			this.removeFrucht();
//		}
	}
	
	public void setMonth(int i){
		this.monat=activity/12;
	}

	@Override
	public int getXCoordinate() {
		return this.center.x;
	}

	@Override
	public int getYCoordinate() {
		return this.center.y;
	}

	public void setLeaveColor(int i){
		
	}
	
	public boolean maxgrowth() {
		if (this.radius==this.maxWachstum){
			return true;
		}
		return false;
	}

	@Override
	public void decay() {
		decay+=generator.nextInt(2);
		
	}

	@Override
	public boolean dead() {
		if(decay>1){
			return true;
		}
		return false;
	}

	@Override
	public String getSubtype() {
		// TODO Auto-generated method stub
		return "Blume";
	}
	
	
//	public void addFrucht(){
//		boolean notdone = true;
//		while (notdone){
//			BasePoint Candidate = new BasePoint(this.generator, this.center.x-+radius, this.center.x+radius, this.center.y-3*radius, this.center.y+radius);
//			if (this.validBoundary(Candidate)){
//				this.Früchte.add(Candidate);
//				notdone = false;
//				
//			}
//		}
//	}
//	
//	public void removeFrucht(){
//		for(int i = 1 ; i <= 2; i++){
//			if (this.Früchte.size()-1<0) break;
//			this.Früchte.remove(this.Früchte.size()-1);
//		}
//		
//		
//	}
//	
//	public boolean validBoundary(BasePoint b){
//		if (Math.pow((b.x - this.center.x - 3), 2) / Math.pow(this.radius, 2)  + Math.pow((b.y - this.center.y - 3), 2) / Math.pow(2*radius, 2) < 1){
//			return true;
//		}
//		return false;
//	}
}
