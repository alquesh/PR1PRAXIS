package pr1.a09;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import pr1.a06.Person;
import pr1.a08.Gitter;
import schimkat.berlin.lernhilfe2014ws.graphics.DirtyPainter;

public class Test {

	public static void main(String[] args) {
		Random generator= new Random();
		
		DirtyPainter painter = new DirtyPainter();
		Background bg = new Background();
		Park testWald = new Park(3,generator);
		painter.add(bg);
		painter.add(testWald);
		painter.showDrawing();
		painter.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		painter.showDrawingAfterWaiting(1);
		while(true) {
			for(int i=0; i<121; i++){
				testWald.changeActivityTo(i);
				if (i%12==0){
					testWald.manage();
				}
				painter.showDrawingAfterWaiting(1);
				
			}
		}		
	}		
}


