package pr1.a08;

import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;
import java.awt.Color;
import java.awt.Graphics;

public class Test {

	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		DirtyPainter painter2 = new DirtyPainter();
		Gitter Alpha =new Gitter(100,100,Color.yellow);
		painter.add(Alpha);
		Gitter Beta = new Gitter(Alpha);
		Beta.setColor(Color.RED);
		painter2.add(Beta);
		painter.showDrawing();
		painter2.showDrawing();

	}

}
