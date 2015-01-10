package pr1.a09;

import java.awt.Graphics;
import java.util.Random;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

public abstract class Pflanze implements Drawable {
	
	protected int reference;
	protected Random generator;
	protected int decay;

	@Override
	public abstract void draw(Graphics g);
	public abstract void waechst();
	public abstract void changeActivityTo(int x);
	public abstract int getXCoordinate();
	public abstract int getYCoordinate();
	public abstract boolean maxgrowth();
	public abstract void decay();
	public abstract boolean dead();
	public abstract String getSubtype();
}
