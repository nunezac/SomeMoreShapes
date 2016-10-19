import csci348.drawings.SimpleDrawing;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class Triangle implements FlowchartObject {
	
	private final int BASECENTERX;
	private final int BASECENTERY;
	private final int HALFWIDTH;
	
	public Triangle(int x1, int y1, int x2) {
		
		BASECENTERX = x1;
		BASECENTERY = y1;
		HALFWIDTH = Math.abs(x2 - x1);
	}
	
	@Override
	public void draw(SimpleDrawing pencil) {
		
		new Line(BASECENTERX - HALFWIDTH, BASECENTERY, BASECENTERX, BASECENTERY - HALFWIDTH).draw(pencil);
		new Line(BASECENTERX, BASECENTERY - HALFWIDTH, BASECENTERX + HALFWIDTH, BASECENTERY).draw(pencil);
		new Line(BASECENTERX + HALFWIDTH, BASECENTERY, BASECENTERX - HALFWIDTH, BASECENTERY).draw(pencil);
	}

	@Override
	public void setThirdParam(int x, int y) {
		// This method has no use in this object

	}

}
