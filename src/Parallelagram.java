import csci348.drawings.SimpleDrawing;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class Parallelagram implements FlowchartObject {
	
	private int[] baseX = new int[2];
	private int baseY;
	private int height;
	private int deltaX;
	
	public Parallelagram(int x0, int y0, int x1, int y1) {
		if (x0 < x1) {
			baseX[0] = x0;
			baseX[1] = x1;
			baseY = y0;
		} else {
			baseX[0] = x1;
			baseX[1] = x0;
			baseY = y1;
		}
		
		height = -1;
		deltaX = -1;
	}
	
	@Override
	public void draw(SimpleDrawing pencil) {
		if (height == -1) {
			new Line(baseX[0], baseY, baseX[1], baseY).draw(pencil);
		} else {
			new Line(baseX[0], baseY, baseX[1], baseY).draw(pencil);
			new Line(baseX[1], baseY, baseX[1] + deltaX, baseY + height).draw(pencil);
			new Line(baseX[1] + deltaX, baseY + height, baseX[0] + deltaX, baseY + height).draw(pencil);
			new Line(baseX[0] + deltaX, baseY + height, baseX[0], baseY).draw(pencil);
		}
	}

	@Override
	public void setThirdParam(int x, int y) {
		
		height = y - baseY;
		deltaX = x - baseX[1];
	}

}
