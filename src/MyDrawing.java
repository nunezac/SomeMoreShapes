import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class MyDrawing extends csci348.drawings.SimpleDrawing {
	
	private final static int ICONSIZE = 40;
	
	private ArrayList<FlowchartObject> objectList;
	private static Icon selectedIcon;
	private boolean isDrawing;
	private boolean isThirdPoint;
	private int[] savedPoint = {0, 0};
	
	private enum Icon {
		POINTER, CIRCLE, BOX, PARALLELAGRAM,
		DIAMOND, TRIANGLE, ARROW, LINE, TRASH;
		
		private final int[][] POINTERDESIGN = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 1, 2, 3,
				4, 5, 5, 6, 6, 7, 8, 9, 9, 8,
				8, 7, 7, 8, 9, 10, 11, 11, 10,
				9, 8, 7, 6, 5, 4, 3, 2, 1},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 16, 15, 14,
				13, 14, 15, 16, 17, 18, 18, 17, 16, 15,
				14, 13, 12, 12, 12, 12, 12, 11, 10, 9,
				8, 7, 6, 5, 4, 3, 2, 1}};
		private final int[][] CIRCLEDESIGN = {
				{0, 0, 0, 0, 1, 1, 1, 2, 2, 3,
				4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 19, 20, 20, 20,
				21, 21, 21, 21, 20, 20, 20, 19, 19, 18,
				17, 16, 15, 14, 13, 12, 11, 10, 9, 8,
				7, 6, 5, 4, 3, 2, 2, 1, 1, 1},
				{9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 19, 20, 20, 20, 21, 21, 21, 21, 20,
				20, 20, 19, 19, 18, 17, 16, 15, 14, 13,
				12, 11, 10, 9, 8, 7, 6, 5, 4, 3,
				2, 2, 1, 1, 1, 0, 0, 0, 0, 1,
				1, 1, 2, 2, 3, 4, 5, 6, 7, 8}};
		private final int[][] BOXDESIGN = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10, 11, 12, 13, 14, 15, 16, 17, 17,
				17, 17, 17, 17, 17, 17, 17, 17, 17, 17,
				16, 15, 14, 13, 12, 11, 10, 9, 8, 7,
				6, 5, 4, 3, 2, 1},
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 11, 11, 11, 11, 11, 11, 11, 11,
				11, 11, 11, 11, 11, 11, 11, 11, 11, 10,
				9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0}
		};
		private final int[][] PARALLELAGRAMDESIGN = {
				{6, 6, 5, 5, 4, 4, 3, 3, 2, 2,
					1, 1, 0, 0, 1, 2, 3, 4, 5, 6,
					7, 8, 9, 10, 11, 12, 13, 14, 15, 15,
					16, 16, 17, 17, 18, 18, 19, 19, 20, 20,
					21, 21, 20, 19, 18, 17, 16, 15, 14, 13,
					12, 11, 10, 9, 8, 7},
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
						11, 12, 13, 14, 15, 15, 15, 15, 15, 15,
						15, 15, 15, 15, 15, 15, 15, 15, 14, 13,
						12, 11, 10, 9, 8, 7, 6, 5, 4, 3,
						2, 1, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0}
		};
		private final int[][] DIAMONDDESIGN = {
				{0, 1, 1, 2, 3, 3, 4, 5, 5, 6,
					7, 7, 8, 9, 9, 10, 11, 11, 12, 11,
					11, 10, 9, 9, 8, 7, 7, 6, 5, 5,
					4, 3, 3, 2, 1, 1},
				{9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
						17, 16, 15, 14, 13, 12, 11, 10, 9, 8,
						7, 6, 5, 4, 3, 2, 1, 0, 1, 2,
						3, 4, 5, 6, 7, 8}
		};
		private final int[][] TRIANGLEDESIGN = {
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
					10, 11, 12, 13, 14, 14, 13, 12, 12, 11,
					10, 10, 9, 8, 8, 7, 6, 6, 5, 4,
					4, 3, 2, 2, 1, 0},
				{11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
						11, 11, 11, 11, 11, 10, 9, 8, 7, 6,
						5, 4, 3, 2, 1, 0, 1, 2, 3, 4,
						5, 6, 7, 8, 9, 10}
		};
		private final int[][] ARROWDESIGN = {
				{0, 1, 1, 2, 2, 2, 3, 3, 3, 3,
					4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4, 4, 5, 5, 5, 5, 6, 6,
					6, 7, 7, 8},
				{4, 3, 4, 2, 3, 4, 1, 2, 3, 4,
						0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
						10, 11, 12, 13, 1, 2, 3, 4, 2, 3,
						4, 3, 4, 4}
		};
		private final int[][] LINEDESIGN = {
				{0, 0, 1, 1, 1, 2, 2, 2, 3, 3,
					3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
					7, 7, 7, 8, 8},
				{16, 15, 15, 14, 13, 13, 12, 11, 11, 10,
						9, 9, 8, 7, 7, 6, 5, 5, 4, 3,
						3, 2, 1, 1, 0}
		};
		private final int[][] TRASHDESIGN = {
				{0, 0, 0, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 2, 3, 4, 5,
					6, 7, 8, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9, 8, 7, 6, 5,
					4, 3, 2, 3, 3, 3, 3, 3, 5, 5,
					5, 5, 7, 7, 7, 7, 7, 4, 3, 3,
					3, 4, 5, 6, 7, 7, 7, 6, 10, 10,
					10, 1, 2, 3, 4, 5, 6, 7, 8, 9,
					3, 4, 5, 6, 7},
				{3, 4, 5, 5, 6, 7, 8, 9, 10, 11,
						12, 13, 14, 15, 16, 17, 17, 17, 17, 17,
						17, 17, 17, 17, 16, 15, 14, 13, 12, 11,
						10, 9, 8, 7, 6, 5, 5, 5, 5, 5,
						5, 5, 5, 11, 12, 13, 14, 15, 12, 13,
						14, 15, 11, 12, 13, 14, 15, 7, 7, 8,
						9, 9, 9, 9, 9, 8, 7, 7, 5, 4,
						3, 2, 2, 2, 2, 2, 2, 2, 2, 2,
						1, 0, 0, 0, 1}
		};
		
		public static void setHighlight(int width) {
			if (width < POINTER.rightBound()) {
				selectedIcon = POINTER;
			} else if (width < CIRCLE.rightBound()) {
				selectedIcon = CIRCLE;
			} else if (width < BOX.rightBound()) {
				selectedIcon = BOX;
			} else if (width < PARALLELAGRAM.rightBound()) {
				selectedIcon = PARALLELAGRAM;
			} else if (width < DIAMOND.rightBound()) {
				selectedIcon = DIAMOND;
			} else if (width < TRIANGLE.rightBound()) {
				selectedIcon = TRIANGLE;
			} else if (width < ARROW.rightBound()) {
				selectedIcon = ARROW;
			} else if (width < LINE.rightBound()) {
				selectedIcon = LINE;
			} else {
				selectedIcon = TRASH;
			}
		}
		
		public int leftBound() {
			switch(this) {
			case POINTER:
				return 0;
			case CIRCLE:
				return ICONSIZE;
			case BOX:
				return ICONSIZE * 2;
			case PARALLELAGRAM:
				return ICONSIZE * 3;
			case DIAMOND:
				return ICONSIZE * 4;
			case TRIANGLE:
				return ICONSIZE * 5;
			case ARROW:
				return ICONSIZE * 6;
			case LINE:
				return ICONSIZE * 7;
			case TRASH:
				return ICONSIZE * 8;
			default:
				return -1;
			}
		}
		
		public int rightBound() {
			switch(this) {
			case POINTER:
				return ICONSIZE;
			case CIRCLE:
				return ICONSIZE * 2;
			case BOX:
				return ICONSIZE * 3;
			case PARALLELAGRAM:
				return ICONSIZE * 4;
			case DIAMOND:
				return ICONSIZE * 5;
			case TRIANGLE:
				return ICONSIZE * 6;
			case ARROW:
				return ICONSIZE * 7;
			case LINE:
				return ICONSIZE * 8;
			case TRASH:
				return ICONSIZE * 9;
			default:
				return -1;
			}
		}
		
		public int[][] design() {
			switch(this) {
			case POINTER:
				return POINTERDESIGN;
			case CIRCLE:
				return CIRCLEDESIGN;
			case BOX:
				return BOXDESIGN;
			case PARALLELAGRAM:
				return PARALLELAGRAMDESIGN;
			case DIAMOND:
				return DIAMONDDESIGN;
			case TRIANGLE:
				return TRIANGLEDESIGN;
			case ARROW:
				return ARROWDESIGN;
			case LINE:
				return LINEDESIGN;
			case TRASH:
				return TRASHDESIGN;
			default:
				return POINTERDESIGN;
			}
		}
	}
	
	public MyDrawing() {
		super();
		
		objectList = new ArrayList<>();
		selectedIcon = Icon.POINTER;
		isDrawing = false;
		isThirdPoint = false;
		
		redrawPage();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
		
		int x = event.getX();
		int y = event.getY();
		
		if (y < ICONSIZE && x < Icon.TRASH.rightBound()) {
			
			Icon.setHighlight(x);
			isDrawing = false;
			isThirdPoint = false;
			
		} else if (isDrawing) {
			
			isDrawing = false;
			drawObject(event, event.getX(), event.getY());
		} else if (selectedIcon != Icon.POINTER && selectedIcon != Icon.TRASH) {
			
			savedPoint[0] = event.getX();
			savedPoint[1] = event.getY();
			isDrawing = true;	
		}
		
		redrawPage();
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {
		super.mouseMoved(event);
		
		System.out.println("Mouse Moved happened.");
	}
	
	public void drawObject(MouseEvent event, int x, int y) {
		
		switch(selectedIcon) {
		case POINTER:
			break;
		case CIRCLE:
			break;
		case BOX:
			if (!isThirdPoint) {
				isDrawing = true;
				objectList.add(new Box(savedPoint[0], savedPoint[1], x));
				isThirdPoint = true;
			} else {
				objectList.get(objectList.size() - 1).setThirdParam(x, y);
				isThirdPoint = false;
			}
			break;
		case PARALLELAGRAM:
			break;
		case DIAMOND:
			break;
		case TRIANGLE:
			objectList.add(new Triangle(savedPoint[0], savedPoint[1], x));
			break;
		case ARROW:
			break;
		case LINE:
			objectList.add(new Line(savedPoint[0], savedPoint[1], x, y));
			break;
		case TRASH:
			break;
		}
	}
	
	private void redrawPage() {
		
		hideAllPoints();
		
		for (int i = 0; i < Icon.TRASH.rightBound(); i++) {
			for (int j = 0; j < ICONSIZE; j++) {
				showPoint(0 + i, 0 + j);
			}
		}
		
		drawIcon(Icon.POINTER);
		drawIcon(Icon.CIRCLE);
		drawIcon(Icon.BOX);
		drawIcon(Icon.PARALLELAGRAM);
		drawIcon(Icon.DIAMOND);
		drawIcon(Icon.TRIANGLE);
		drawIcon(Icon.ARROW);
		drawIcon(Icon.LINE);
		drawIcon(Icon.TRASH);
		
		if (isDrawing) {
			drawPoint(savedPoint[0], savedPoint[1]);
		}
		
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).draw(this);
		}
	}
	
	private void drawPoint(int x, int y) {
		
		int translateX = x - 1;
		int translateY = y - 1;
		for (int i = 0; i < 9; i++) {
			showPoint(translateX + (i % 3), translateY + (i / 3));
		}
	}
	
	private void drawIcon(Icon icon) {
		int[][] design = icon.design();
		int displaceX = ((ICONSIZE - maxInt(design[0])) / 2) + icon.leftBound();
		int displaceY = ((ICONSIZE - maxInt(design[1])) / 2);
		
		if (selectedIcon == icon) {
			toggleHighlighting(icon.leftBound(), 0, true);
			
			for (int i = 0; i < design[0].length; i++) {
				hidePoint(displaceX + design[0][i], displaceY + design[1][i]);
			}
		} else {
			toggleHighlighting(icon.leftBound(), 0, false);
			
			for (int i = 0; i < design[0].length; i++) {
				showPoint(displaceX + design[0][i], displaceY + design[1][i]);
			}
		}
	}
	
	private int maxInt(int[] intArray) {
		int max = 0;
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > max) {
				max = intArray[i];
			}
		}
		
		return max;
	}
	
	private void toggleHighlighting(int startX, int startY, boolean isHighlighted) {
		
		if (isHighlighted) {
			for (int i = 2; i < ICONSIZE - 2; i++) {
				for (int j = 2; j < ICONSIZE - 2; j++) {
					showPoint(startX + i, startY + j);
				}
			}
		} else {
			for (int i = 2; i < ICONSIZE - 2; i++) {
				for (int j = 2; j < ICONSIZE - 2; j++) {
					hidePoint(startX + i, startY + j);
				}
			}
		}
	}
}
