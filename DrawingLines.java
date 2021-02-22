package week2.drawinglines;

import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

public class DrawingLines extends GraphicsProgram {
	//initializes the program with the listener
	public void init() {
		addMouseListeners();
	}
	//called on pressing the mouse to record the location of point where the mouse is pressed 
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
	}
	// called on dragging the mouse 
	public void mouseDragged(MouseEvent e) {
		if (line != null) {
			remove(line);                    // removes the previous line segment that was created on the path of dragging
		}
		end = new GPoint(e.getPoint());		 // records the coordinate of the mouse position 
		line = new GLine(last.getX(), last.getY(), end.getX(), end.getY());
		add(line);							// adds a line segment along the path of dragging
	}
	//called on releasing the mouse; so that the mouse is ready to be pressed again and draw another line
	//when mouse is released, the last position at which the mouse was dragged to, will be the end coordinates of the line
	public void mouseReleased(MouseEvent e) {
		 line = new GLine(last.getX(),last.getY(),end.getX(),end.getY()); 
		 add(line);	
	}
	//instance variables
	private GPoint last, end;
	private GLine line;
	
}
