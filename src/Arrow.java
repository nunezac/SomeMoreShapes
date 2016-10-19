import csci348.drawings.SimpleDrawing;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class Arrow implements FlowchartObject {
	
	private int[] lineX = new int[2];
	private int[] lineY = new int[2];
	private final double OFFSET;
	private final int ARROWLENGTH;
	
	public Arrow(int x0, int y0, int x1, int y1) {
		lineX[0] = x0;
		lineX[1] = x1;
		lineY[0] = y0;
		lineY[1] = y1;
		
		OFFSET = Math.toRadians(35);
		ARROWLENGTH = 10;
	}
	
	@Override
	public void draw(SimpleDrawing pencil) {
		
		int dx = lineX[0] - lineX[1];
		int dy = lineY[0] - lineY[1];
		double theta = Math.atan2(dy, dx);
		
		double[] leftPoint = {
				lineX[0] - ARROWLENGTH * Math.cos(theta + OFFSET),
				lineY[0] - ARROWLENGTH * Math.sin(theta + OFFSET)
		};
		double[] rightPoint = {
				lineX[0] - ARROWLENGTH * Math.cos(theta - OFFSET),
				lineY[0] - ARROWLENGTH * Math.sin(theta - OFFSET)
		};
		
		new Line(lineX[0], lineY[0], lineX[1], lineY[1]).draw(pencil);
		new Line(lineX[0], lineY[0], (int)leftPoint[0], (int)leftPoint[1]).draw(pencil);
		new Line(lineX[0], lineY[0], (int)rightPoint[0], (int)rightPoint[1]).draw(pencil);
	}

	@Override
	public void setThirdParam(int x, int y) {
		// TODO Auto-generated method stub

	}

}
