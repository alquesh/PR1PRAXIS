package pr1.a09;

import java.awt.Point;
import java.util.Random;

public class BasePoint extends Point {
	
	
	
	public BasePoint(int x, int y) {
		super(x, y);
	}

	public BasePoint(Point p) {
		super(p);	
	}
	
	public BasePoint (Random generator, int minx, int maxx, int miny, int maxy){
		super(generator.nextInt(maxx)+minx,generator.nextInt(maxy)+miny);
	}

	public void moveRel(int xrel, int yrel){
		this.x += xrel;
		this.y += yrel;
	}
}
