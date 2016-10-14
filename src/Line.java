/**
 * 
 */

import java.util.ArrayList;
import csci348.drawings.SimpleDrawing;

/**
 * @author aclink4126
 *
 */
public class Line {

public static ArrayList<Line> allLines = new ArrayList<>();
	
	private int[] x = new int[2];
	private int[] y = new int[2];
	private double m;
	private int b;

	public Line(int x1, int y1, int x2, int y2) {
		if (x2 < x1 || (x1 == x2 && y2 < y1)) {
			x[0] = x2;
			x[1] = x1;
			y[0] = y2;
			y[1] = y1;
			
		} else {
			x[0] = x1;
			x[1] = x2;
			y[0] = y1;
			y[1] = y2;
		}
		
		if (x1 == x2) {
			m = 500;
		} else {
			m = (y[1] - y[0])/(x[1] - x[0]);
		}
		
		b = y1 - (int)(m * x1);
		
		allLines.add(this);
	}
	
	public int[] getXY(int index) {
		int[] xy = {x[index], y[index]};
		
		return xy;
	}
	
	public void setXY(int index, int x, int y) {
		
		if (index == 0) {
			if (x > this.x[1] || (x == this.x[1] && y > this.y[1])) {
				this.x[0] = this.x[1];
				this.y[0] = this.y[1];
				
				this.x[1] = x;
				this.y[1] = y;
			} else {
				this.x[index] = x;
				this.y[index] = y;
			}
		} else {
			if (x < this.x[0] || (x == this.x[0] && y < this.y[0])) {
				this.x[1] = this.x[0];
				this.y[1] = this.y[0];
				
				this.x[0] = x;
				this.y[0] = y;
			} else {
				this.x[index] = x;
				this.y[index] = y;
			}
		}
		
		m = (this.y[1] - this.y[0])/(this.x[1] - this.x[0]);
		b = y - (int)(m * x);
	}
	
	public void drawLine(SimpleDrawing pencil) {
		
		int currentX, currentY;
		if (m <= .5 && m >= -.5) {
			for(currentX = x[0]; currentX < x[1]; currentX++) {
				currentY = (int)(m * currentX) + b;
				pencil.showPoint(currentX, currentY);
			}
		} else if (m >= 500 || m <= -500) {
			currentX = x[0];
			for(currentY = y[0]; currentY < y[1]; currentY++) {
				pencil.showPoint(currentX, currentY);
			}
		} else {
			for(currentY = y[0]; currentY < y[1]; currentY++) {
				currentX = (int)((currentY - b) / m);
				pencil.showPoint(currentX, currentY);
			}
		}
	}
	
	public static void drawAllLines(SimpleDrawing pencil) {
		
		int max = allLines.size();
		
		for(int i = 0; i < max; i++) {
			allLines.get(i).drawLine(pencil);
		}
	}
}
