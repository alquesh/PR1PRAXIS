package pr1.a09;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Baum extends Pflanze {

	protected int radius;										//Radius der Krone
	protected int monat;
	//protected BasePoint basePoint = new BasePoint(0,0);
	protected BasePoint center;									//Mittelpunkt der Krone 
	protected Color braun = new Color(222,184,135);
	protected Color[] bl�tterfarbe = new Color[12];
	
	protected Color winterSpringTransition= new Color(190,250,125);
	protected Color spring = new Color(124, 252, 0);
	protected Color summer = new Color(34,139,34);
	protected Color summerAutumTransition = new Color(122,122,32);
	protected Color autum = new Color(210, 105, 30);
	protected Color snow = new Color(255,250,250);
	protected Color currentColor;
	protected int activity;
	protected ArrayList<BasePoint> Fr�chte = new ArrayList<BasePoint>(); 
	protected int wachstumsrate;
	protected final int maxWachstum= 80;
	protected int fr�chtecounter;
	
	public Baum(int x, int wachs, Random generator){
		radius=4;
		center=new BasePoint(x,(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.75));
		wachstumsrate = wachs;
		bl�tterfarbe[0]=snow;
		bl�tterfarbe[1]=winterSpringTransition;
		bl�tterfarbe[2]=spring;
		bl�tterfarbe[3]=spring;
		bl�tterfarbe[4]=spring;
		bl�tterfarbe[5]=summer;
		bl�tterfarbe[6]=summer;
		bl�tterfarbe[7]=summerAutumTransition;
		bl�tterfarbe[8]=autum;
		bl�tterfarbe[9]=autum;
		bl�tterfarbe[10]=autum;
		bl�tterfarbe[11]=snow;
		currentColor=snow;
		//ArrayList<BasePoint> Fr�chte= new ArrayList<BasePoint>(); 
		activity = 0;
		monat = 0;
		decay=0;
		reference=maxWachstum;
		this.generator=generator;
		fr�chtecounter = 0;
	}
	
	
	@Override
	public void draw(Graphics g) {
		this.drawStamm(g);
		this.drawKrone(g);
		
//		g.setColor(this.braun);
//		g.fillRect(center.x-(radius/4), 
//				   center.y+(radius/4), 
//				   radius/2, 
//				   (radius*2-radius/4));
//		g.setColor(this.currentColor);
//		g.fillOval(center.x-radius, 
//				   center.y-radius, 
//				   			radius*2, 
//				   			radius*2);
		g.setColor(Color.red);
		for (BasePoint p : Fr�chte){
			g.fillOval(p.x-4, p.y-4, 9, 9);
		}
	}
	
	public void drawKrone(Graphics g){		//draws a filled circle based on the center point and the radius
		g.setColor(this.currentColor);
		g.fillOval(center.x-radius, 
				   center.y-radius, 
				   			radius*2, 
				   			radius*2);
	}
	
	public void drawStamm(Graphics g){		//draws a filled rectangle based on the center point and the radius
		g.setColor(this.braun);
		g.fillRect(center.x-(radius/4), 
				   center.y+(radius/4), 
				   radius/2, 
				   (radius*2-radius/4));
	}
	
	public void waechst(){					//increases the size of the radius by the growth rate if maximum growth
		if (radius<maxWachstum){			//hasn't been achieved
			radius += wachstumsrate;
			center.moveRel(0, -wachstumsrate*2);
		}
	}
	
	public void changeActivityTo(int i){			//advances the time for the tree if a "month" has passed it will change  
		activity=i;							//the color of the leaves to the appropriate one
		if (activity%12==0){
			this.setMonth(activity);
			this.setLeaveColor(monat);
		}
		this.growthCheck();
	}
	
	public int getXCoordinate(){
		return this.center.x;
	}
	
	public int getYCoordinate(){
		return this.center.y;
	}
	
	public void setLeaveColor(int i){
		this.currentColor=bl�tterfarbe[i];
	}
	
	public void growthCheck(){
		if (this.monat >= 2 && this.monat <= 5){
			this.waechst();
		}
		if (this.monat >= 6 && this.monat <= 8){
			this.addFrucht();
		}
		if (this.monat >= 8 && this.monat <= 10){
			this.removeFrucht();
		}
	}
	
	public void setMonth(int i){
		this.monat=activity/12;
	}
	
	public void addFrucht(){
		boolean notdone = true;
		while (notdone){
			if(this.Fr�chte.size()<radius/4-(decay/4)){
				BasePoint Candidate = new BasePoint(this.generator, this.center.x-radius, this.center.x+radius, this.center.y-radius, this.center.y+radius);
				if (Math.pow((Candidate.x - this.center.x), 2)  + Math.pow((Candidate.y - this.center.y), 2) < Math.pow(this.radius-5, 2)){
					this.Fr�chte.add(Candidate);
					notdone = false;				
				}
			}else{
				notdone = false;
			}
		}
	}
	public void addFrucht(int i){
		for (int n=1;n<=i;n++){
			boolean notdone = true;
			while (notdone){
				BasePoint Candidate = new BasePoint(this.generator, this.center.x-radius, this.center.x+radius, this.center.y-radius, this.center.y+radius);
				if (Math.pow((Candidate.x - this.center.x), 2)  + Math.pow((Candidate.y - this.center.y), 2) < Math.pow(this.radius, 2)){
					this.Fr�chte.add(Candidate);
				}
			}
		}
	}
	
	public void removeFrucht(){
		for(int i = 1 ; i <= 2; i++){
			if (this.Fr�chte.size()-1<0) break;
			this.Fr�chte.remove(this.Fr�chte.size()-1);
		}
		
		
	}
	
	public void clearFrucht(){
		this.Fr�chte.clear();
	}
	
	public boolean maxgrowth() {
		if (this.radius==this.maxWachstum){
			return true;
		}
		return false;
	}


	@Override
	public void decay() {
		
			decay+=2-generator.nextInt(2);
			
	}


	@Override
	public boolean dead() {
		if(radius/4-decay<0){
			return true;
		}
		return false;
	}


	@Override
	public String getSubtype() {
		return "Baum";
	}
	
	
	
}



