package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

public class Gitter implements Drawable {
	protected int dx;
	protected int dy;
	protected Color lColor;
	
	public Gitter(){
		this.dx = 100;
		this.dy = 100;
		this.lColor= Color.yellow;
	}
	
	public Gitter(int breitex, int breitey) {
		this.dx=breitex;
		this.dy=breitey;
	}
	
	public Gitter(int breitex, int breitey, Color linecolor) {
		this.dx=breitex;
		this.dy=breitey;
		this.lColor = linecolor;
	}
	
	public Gitter(Gitter that){
		this.dx=that.dx;
		this.dy=that.dy;
		this.lColor=that.lColor;
	}
	
	public void draw(Graphics g) {
		g.setColor(lColor);
		for(int x=0;x<=1000; x=x+dx){
			g.drawLine(0, x, 1000, x);
			
		}
		for(int y=0;y<1000;y=y+this.dy){
			g.drawLine(y, 0, y, 1000);
		}
		g.setColor(Color.BLUE);
		g.drawLine(500, 0, 500, 1000);
		g.drawLine(0, 500, 1000, 500);
	}
	
	public int getDx(){
		return this.dx;
	}
	
	public int getDy(){
		return this.dy;
	}
	
	public Color getColor(){
		return this.lColor;
	}
	
	public void setColor(Color c){
		this.lColor=c;
	}

}
