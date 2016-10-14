import java.awt.event.MouseEvent;
//import java.awt.Color;

/**
 * 
 */

/**
 * @author aclink4126
 *
 */
public class MyDrawing extends csci348.drawings.SimpleDrawing {
	
	private final static int ICONSIZE = 40;
	private static Icon selectedIcon = Icon.POINTER;
	
	private enum Icon {
		POINTER, CIRCLE, BOX, PARALLELAGRAM,
		DIAMOND, TRIANGLE, ARROW, LINE, TRASH;
		
		public static void setHighlight(int width) {
			if (width < ICONSIZE) {
				selectedIcon = Icon.POINTER;
			} else if (width < 2 * ICONSIZE) {
				selectedIcon = Icon.CIRCLE;
			} else if (width < 3 * ICONSIZE) {
				selectedIcon = Icon.BOX;
			} else if (width < 4 * ICONSIZE) {
				selectedIcon = Icon.PARALLELAGRAM;
			} else if (width < 5 * ICONSIZE) {
				selectedIcon = Icon.DIAMOND;
			} else if (width < 6 * ICONSIZE) {
				selectedIcon = Icon.TRIANGLE;
			} else if (width < 7 * ICONSIZE) {
				selectedIcon = Icon.ARROW;
			} else if (width < 8 * ICONSIZE) {
				selectedIcon = Icon.LINE;
			} else {
				selectedIcon = Icon.TRASH;
			}
		}
	}
	
	MyDrawing() {
		super();
		
		for (int i = 0; i < ICONSIZE * 9; i++) {
			for (int j = 0; j < ICONSIZE; j++) {
				showPoint(0 + i, 0 + j);
			}
		}
		
		drawIcons();
	}
	
//	MyDrawing(int width, int height) {
//		super(width, height);
//	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		if (y < ICONSIZE && x < ICONSIZE * 9) {
			Icon.setHighlight(x);
			drawIcons();
		}
	}
	
	private void drawIcons() {
		
		drawPointerIcon(0, 0);
		drawCircleIcon(ICONSIZE, 0);
		drawBoxIcon(ICONSIZE * 2, 0);
		drawParallelIcon(ICONSIZE * 3, 0);
		drawDiamondIcon(ICONSIZE * 4, 0);
		drawTriangleIcon(ICONSIZE * 5, 0);
		drawArrowIcon(ICONSIZE * 6, 0);
		drawLineIcon(ICONSIZE * 7, 0);
		drawTrashIcon(ICONSIZE * 8, 0);
	}
	
	private void drawPointerIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 11) / 2) + startX;
		int displaceY = ((ICONSIZE - 18) / 2) + startY;
		
		int[] designX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 1, 2, 3,
				4, 5, 5, 6, 6, 7, 8, 9, 9, 8,
				8, 7, 7, 8, 9, 10, 11, 11, 10,
				9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] designY = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 16, 15, 14,
				13, 14, 15, 16, 17, 18, 18, 17, 16, 15,
				14, 13, 12, 12, 12, 12, 12, 11, 10, 9,
				8, 7, 6, 5, 4, 3, 2, 1};
		
		if (selectedIcon == Icon.POINTER) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
		
		
	}
	
	private void drawCircleIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 21) / 2) + startX;
		int displaceY = ((ICONSIZE - 21) / 2) + startY;
		
		int[] designX = {0, 0, 0, 0, 1, 1, 1, 2, 2, 3,
				4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 19, 20, 20, 20,
				21, 21, 21, 21, 20, 20, 20, 19, 19, 18,
				17, 16, 15, 14, 13, 12, 11, 10, 9, 8,
				7, 6, 5, 4, 3, 2, 2, 1, 1, 1};
		int[] designY = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 19, 20, 20, 20, 21, 21, 21, 21, 20,
				20, 20, 19, 19, 18, 17, 16, 15, 14, 13,
				12, 11, 10, 9, 8, 7, 6, 5, 4, 3,
				2, 2, 1, 1, 1, 0, 0, 0, 0, 1,
				1, 1, 2, 2, 3, 4, 5, 6, 7, 8};
		
		if (selectedIcon == Icon.CIRCLE) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawBoxIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 17) / 2) + startX;
		int displaceY = ((ICONSIZE - 11) / 2) + startY;
		
		int[] designX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10, 11, 12, 13, 14, 15, 16, 17, 17,
				17, 17, 17, 17, 17, 17, 17, 17, 17, 17,
				16, 15, 14, 13, 12, 11, 10, 9, 8, 7,
				6, 5, 4, 3, 2, 1};
		int[] designY = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 11, 11, 11, 11, 11, 11, 11, 11,
				11, 11, 11, 11, 11, 11, 11, 11, 11, 10,
				9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0};
		
		if (selectedIcon == Icon.BOX) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawParallelIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 21) / 2) + startX;
		int displaceY = ((ICONSIZE - 15) / 2) + startY;
		
		int[] designX = {6, 6, 5, 5, 4, 4, 3, 3, 2, 2,
				1, 1, 0, 0, 1, 2, 3, 4, 5, 6,
				7, 8, 9, 10, 11, 12, 13, 14, 15, 15,
				16, 16, 17, 17, 18, 18, 19, 19, 20, 20,
				21, 21, 20, 19, 18, 17, 16, 15, 14, 13,
				12, 11, 10, 9, 8, 7};
		int[] designY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 15, 15, 15, 15, 15,
				15, 15, 15, 15, 15, 15, 15, 15, 14, 13,
				12, 11, 10, 9, 8, 7, 6, 5, 4, 3,
				2, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0};
		
		if (selectedIcon == Icon.PARALLELAGRAM) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawDiamondIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 12) / 2) + startX;
		int displaceY = ((ICONSIZE - 18) / 2) + startY;
		
		int[] designX = {0, 1, 1, 2, 3, 3, 4, 5, 5, 6,
				7, 7, 8, 9, 9, 10, 11, 11, 12, 11,
				11, 10, 9, 9, 8, 7, 7, 6, 5, 5,
				4, 3, 3, 2, 1, 1};
		int[] designY = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				17, 16, 15, 14, 13, 12, 11, 10, 9, 8,
				7, 6, 5, 4, 3, 2, 1, 0, 1, 2,
				3, 4, 5, 6, 7, 8};
		
		if (selectedIcon == Icon.DIAMOND) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawTriangleIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 14) / 2) + startX;
		int displaceY = ((ICONSIZE - 11) / 2) + startY;
		
		int[] designX = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 14, 13, 12, 12, 11,
				10, 10, 9, 8, 8, 7, 6, 6, 5, 4,
				4, 3, 2, 2, 1, 0};
		int[] designY = {11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
				11, 11, 11, 11, 11, 10, 9, 8, 7, 6,
				5, 4, 3, 2, 1, 0, 1, 2, 3, 4,
				5, 6, 7, 8, 9, 10};
		
		if (selectedIcon == Icon.TRIANGLE) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawArrowIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 8) / 2) + startX;
		int displaceY = ((ICONSIZE - 13) / 2) + startY;
		
		int[] designX = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3,
				4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
				4, 4, 4, 4, 5, 5, 5, 5, 6, 6,
				6, 7, 7, 8};
		int[] designY = {4, 3, 4, 2, 3, 4, 1, 2, 3, 4,
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 1, 2, 3, 4, 2, 3,
				4, 3, 4, 4};
		
		if (selectedIcon == Icon.ARROW) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawLineIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 8) / 2) + startX;
		int displaceY = ((ICONSIZE - 16) / 2) + startY;
		
		int[] designX = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3,
				3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
				7, 7, 7, 8, 8};
		int[] designY = {16, 15, 15, 14, 13, 13, 12, 11, 11, 10,
				9, 9, 8, 7, 7, 6, 5, 5, 4, 3,
				3, 2, 1, 1, 0};
		
		if (selectedIcon == Icon.LINE) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
	}
	
	private void drawTrashIcon(int startX, int startY) {
		
		int displaceX = ((ICONSIZE - 10) / 2) + startX;
		int displaceY = ((ICONSIZE - 17) / 2) + startY;
		
		int[] designX = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 2, 3, 4, 5,
				6, 7, 8, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 8, 7, 6, 5,
				4, 3, 2, 3, 3, 3, 3, 3, 5, 5,
				5, 5, 7, 7, 7, 7, 7, 4, 3, 3,
				3, 4, 5, 6, 7, 7, 7, 6, 10, 10,
				10, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				3, 4, 5, 6, 7};
		int[] designY = {3, 4, 5, 5, 6, 7, 8, 9, 10, 11,
				12, 13, 14, 15, 16, 17, 17, 17, 17, 17,
				17, 17, 17, 17, 16, 15, 14, 13, 12, 11,
				10, 9, 8, 7, 6, 5, 5, 5, 5, 5,
				5, 5, 5, 11, 12, 13, 14, 15, 12, 13,
				14, 15, 11, 12, 13, 14, 15, 7, 7, 8,
				9, 9, 9, 9, 9, 8, 7, 7, 5, 4,
				3, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				1, 0, 0, 0, 1};
		
		if (selectedIcon == Icon.TRASH) {
			toggleHighlighting(startX, startY, true);
			
			for (int i = 0; i < designX.length; i++) {
				hidePoint(displaceX + designX[i], displaceY + designY[i]);
			}
		} else {
			toggleHighlighting(startX, startY, false);
			
			for (int i = 0; i < designX.length; i++) {
				showPoint(displaceX + designX[i], displaceY + designY[i]);
			}
		}
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
