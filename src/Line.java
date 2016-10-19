import csci348.drawings.SimpleDrawing;

/**
 * @author aclink4126
 *
 */
public class Line implements FlowchartObject {
	
	private int[] x = new int[2];
	private int[] y = new int[2];

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
	}

	@Override
	public void draw(SimpleDrawing pencil) {
		
		int currentX = x[0];
		int currentY = y[0];
		double dx = x[1] - x[0];
		int sx;
		double dy = y[1] - y[0];
		int sy;
		if (dx < 0) {
			sx = -1;
		} else {
			sx = 1;
		}
		if (dy < 0) {
			sy = -1;
		} else {
			sy = 1;
		}
		double slope;
		double pitch;
				
		if(Math.abs(dy) < Math.abs(dx)) {
			slope = dy / dx;
			pitch = currentY - (slope * (double)currentX);
			while ((int)currentX != x[1]) {
				pencil.showPoint(currentX, (int)(slope * currentX + pitch));
				currentX += sx;
			}
		} else {
			slope = dx / dy;
			pitch = currentX - (slope * (double)currentY);
			while (currentY != y[1]) {
				pencil.showPoint((int)(slope * currentY + pitch), currentY);
				currentY += sy;
			}
		}
		
		pencil.showPoint(x[1], y[1]);
	}

	@Override
	public void setThirdParam(int x, int y) {
		// This method has no use in this object
		
	}
}
