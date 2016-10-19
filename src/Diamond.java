import csci348.drawings.SimpleDrawing;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class Diamond implements FlowchartObject {

	private int centerX;
	private int centerY;
	private int halfHeight;
	private int halfWidth;
	
	public Diamond(int x1, int y1, int x2) {
		
		centerX = x1;
		centerY = y1;
		
		halfWidth = Math.abs(x2 - x1);
		halfHeight = -1;
	}
	
	@Override
	public void draw(SimpleDrawing pencil) {
		
		if (halfHeight == -1) {
			new Line(centerX - halfWidth, centerY - 400, centerX - halfWidth, centerY + 400).draw(pencil);
			new Line(centerX + halfWidth, centerY - 400, centerX + halfWidth, centerY + 400).draw(pencil);
		} else {
			new Line(centerX - halfWidth, centerY, centerX, centerY - halfHeight).draw(pencil);
			new Line(centerX, centerY - halfHeight, centerX + halfWidth, centerY).draw(pencil);
			new Line(centerX + halfWidth, centerY, centerX, centerY + halfHeight).draw(pencil);
			new Line(centerX, centerY + halfHeight, centerX - halfWidth, centerY).draw(pencil);
		}
	}

	@Override
	public void setThirdParam(int x, int y) {
		
		halfHeight = Math.abs(centerY - y);
	}

}
