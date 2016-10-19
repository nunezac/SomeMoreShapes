import csci348.drawings.SimpleDrawing;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class Circle implements FlowchartObject {
	
	private int centerX;
	private int centerY;
	private double radius;
	
	public Circle(int x0, int y0, int x1, int y1) {
		
		centerX = x0;
		centerY = y0;
		radius = Math.sqrt(Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2));
	}
	
	@Override
	public void draw(SimpleDrawing pencil) {
		
		int x = (int)radius;
		int y = 0;
		int err = 0;
		
		while(x >= y) {
			pencil.showPoint(centerX + x, centerY + y);
			pencil.showPoint(centerX + y, centerY + x);
			pencil.showPoint(centerX - y, centerY + x);
			pencil.showPoint(centerX - x, centerY + y);
			pencil.showPoint(centerX - x, centerY - y);
			pencil.showPoint(centerX - y, centerY - x);
			pencil.showPoint(centerX + y, centerY - x);
			pencil.showPoint(centerX + x, centerY - y);
			
			y++;
			err += 1 + (2 * y);
			if (2 * (err - x) + 1 > 0) {
				x--;
				err += 1 - (2 * x);
			}
		}
	}

	@Override
	public void setThirdParam(int x, int y) {
		// This method has no use in this object

	}

}
