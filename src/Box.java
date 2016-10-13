/**
 * 
 */

import java.util.ArrayList;
import csci348.drawings.*;

/**
 * @author aclink4126
 *
 */
public class Box {
	
public static ArrayList<Box> allBoxes = new ArrayList<>();
	
	private final int NO = 0;
	private final int YES = 1;
	
	private int centerX;
	private int centerY;
	private int height;
	private int width;
	
	private int oddHeight;
	private int oddWidth;
	
	public Box(int x, int y, int height, int width) {
		
		centerX = x;
		centerY = y;
		this.height = height;
		this.width = width;
		
		if ((height % 2) == 0) {
			oddHeight = NO;
		} else {
			oddHeight = YES;
		}
		if ((width % 2) == 0) {
			oddWidth = NO;
		} else {
			oddWidth = YES;
		}
		
		allBoxes.add(this);
	}
	
	public int[] getCenter() {
		
		int[] center = {centerX, centerY};
		return center;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public void setCenter(int x, int y) {
		
		centerX = x;
		centerY = y;
	}
	
	public void setHeight(int height) {
		
		this.height = height;
		
		if ((height % 2) == 0) {
			oddHeight = NO;
		} else {
			oddHeight = YES;
		}
	}
	
	public void setWidth(int width) {
		
		this.width = width;
		
		if ((width % 2) == 0) {
			oddWidth = NO;
		} else {
			oddWidth = YES;
		}
	}
	
	public void drawBox(Drawing pencil) {
		
		int startX = centerX - ((width - oddWidth) / 2);
		int startY = centerY - ((height - oddHeight) / 2);
		
		for(int x = 0; x < width; x++) {
			pencil.showPoint(startX + x, startY);
			pencil.showPoint(startX + x, startY + height);
		}
		
		for(int y = 0; y <= height; y++) {
			pencil.showPoint(startX, startY + y);
			pencil.showPoint(startX + width, startY + y);
		}
	}
	
	public static void drawAllBoxes(Drawing pencil) {
		
		int max = allBoxes.size();
		
		for(int i = 0; i < max; i++) {
			allBoxes.get(i).drawBox(pencil);
		}
	}
}
