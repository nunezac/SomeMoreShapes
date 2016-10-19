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
		
		int deltaX = x[1] - x[0];
		if (deltaX != 0) {
			int deltaY = y[1] - y[0];
			int d = (2 * deltaY) - deltaX;
			
			if (deltaX > Math.abs(deltaY)) {
				int currentY = y[0];
				if (deltaY > 0) {
					for (int currentX = x[0]; currentX < x[1]; currentX++) {
						pencil.showPoint(currentX, currentY);
						
						if (d >= 0) {
							currentY++;
							d -= deltaX;
						}
						
						d += deltaY;
					}
				} else {
					for (int currentX = x[0]; currentX < x[1]; currentX++) {
						pencil.showPoint(currentX, currentY);
						
						if (d <= 0) {
							currentY--;
							d += deltaX;
						}
						
						d += deltaY;
					}
				}
			} else {
				int currentX = x[0];
				if (deltaY > 0) {
					for (int currentY = y[0]; currentY < y[1]; currentY++) {
						pencil.showPoint(currentX, currentY);
						
						if (d >= 0) {
							currentX++;
							d -= deltaY;
						}
						
						d += deltaX;
					}
				} else {
					System.out.println("This happened");
					for (int currentY = y[0]; currentY < y[1]; currentY++) {
						pencil.showPoint(currentX, currentY);
						
						if (d <= 0) {
							System.out.println(x);
							currentX++;
							d += deltaY;
						}
						
						d += deltaX;
					}
				}
			}
		} else {
			for (int currentY = y[0]; currentY < y[1]; currentY++) {
				pencil.showPoint(x[0], currentY);
			}
		}
	}

	@Override
	public void setThirdParam(int x, int y) {
		// This method has no use in this object
		
	}
}
