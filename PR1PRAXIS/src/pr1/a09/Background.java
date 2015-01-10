package pr1.a09;

import java.awt.*;

import schimkat.berlin.lernhilfe2014ws.graphics.Drawable;

public class Background implements Drawable {
	
	Color Dirt = new Color(155,118,83);
	Color Sky = new Color(135,206,255);

	public Background() {
		super();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Sky);
		g.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		g.setColor(Dirt);
		g.fillRect(0, 
				   (int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.75), 
				   Toolkit.getDefaultToolkit().getScreenSize().width, 
				   (int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.75));
	
	}

}
