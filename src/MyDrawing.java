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
	
	MyDrawing() {
		super();
		
		drawPointerIcon(50, 50);
		drawCircleIcon(100, 50);
		drawBoxIcon(150, 50);
		drawParallelIcon(250, 50);
		drawDiamondIcon(300, 50);
		drawTriangleIcon(350, 50);
		drawArrowIcon(400, 50);
		drawLineIcon(450, 50);
		drawTrashIcon(500, 50);
	}
	
//	MyDrawing(int width, int height) {
//		super(width, height);
//	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		System.out.println(x + " , " + y);
		
//		setForegroundColor(Color.BLUE);
	}
	
	private void drawPointerIcon(int startX, int startY) {
		
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
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawCircleIcon(int startX, int startY) {
		
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
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawBoxIcon(int startX, int startY) {
		
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
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawParallelIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawDiamondIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawTriangleIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawArrowIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawLineIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
	
	private void drawTrashIcon(int startX, int startY) {
		
		int[] designX = {};
		int[] designY = {};
		
		for (int i = 0; i < designX.length; i++) {
			this.showPoint(startX + designX[i], startY + designY[i]);
		}
	}
}
