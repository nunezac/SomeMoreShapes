/**
 * 
 */

//import csci348.drawings.*;
//import java.util.Scanner;

/**
 * @author aclink4126
 *
 */
public class Draw {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/** In order to add organization, and to have a "menu" that can be repeatedly called
		this instance variable is created access all of the private methods within Draw*/
//		Draw instance = new Draw();
//		instance.presentMenu();
	}
	
	/*
private void presentMenu() {
		
		System.out.println("Welcome to Draw! Please type an option number below, followed by the Enter key");
		System.out.println(" 1 - ADD BOX");
        System.out.println(" 2 - ADD LINE");
        System.out.println(" 3 - CHANGE BOX");
        System.out.println(" 4 - CHNAGE LINE");
        System.out.println(" 5 - PREVIEW");
        System.out.println(" 6 - DRAW!");
        System.out.println();
        System.out.print("Command: ");
        
        Scanner keyboard = new Scanner(System.in);
        int response = testInt(keyboard);
        
        switch (response)
        {
            case 1: // Add box
            	addBox();
                break;
            case 2:
                addLine();
                break;
            case 3:
                changeBox();
                break;
            case 4:
            	changeLine();
            	break;
            case 5:
            	showDrawings();
            	presentMenu();
            	break;
            case 6:
            	showDrawings();
                System.out.println("Here is your drawing. Bye!");
                break;
            case -1:
            	System.out.println("Thank you for using our system. Good bye!");
            	break;
            default:
                System.out.println("Unrecognized option.");
                presentMenu();
                break;
        }
        
        keyboard.close();
	}
	
	private void addBox() {
		
		Scanner keyboard = new Scanner(System.in);
        System.out.print("Center X-Coordinate: ");
        int centerX = testInt(keyboard);
        System.out.print("Center Y-Coordinate: ");
        int centerY = testInt(keyboard);
        System.out.print("Side Height: ");
        int height = testInt(keyboard);
        System.out.print("Side Width: ");
        int width = testInt(keyboard);
        
        if (centerX != -1 && centerY != -1 && height != -1 && width != -1) {
        	new Box(centerX, centerY, height, width);
        }
        
        presentMenu();
	}
	
	private void addLine() {
		
		Scanner keyboard = new Scanner(System.in);
        System.out.print("X-Coordinate 1: ");
        int x1 = testInt(keyboard);
        System.out.print("Y-Coordinate 1: ");
        int y1 = testInt(keyboard);
        System.out.print("X-Coordinate 2: ");
        int x2 = testInt(keyboard);
        System.out.print("Y-Coordinate 2: ");
        int y2 = testInt(keyboard);
        
        if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
        	new Line(x1, y1, x2, y2);
        }
        
        presentMenu();
	}
	
	private void changeBox() {
		
		int max = Box.allBoxes.size();
		Scanner keyboard = new Scanner(System.in);
		
		if (max == 0) {
			
			System.err.println("There are no boxes to edit. Press 1 on main menu to create your first box.");
			
			presentMenu();
		} else {
			
			System.out.println("In total there have been " + max + " box(es) created.\n");
			System.out.println("Choose one of the following to edit:");
			
			for(int i = 0; i < max; i++) {
				int[] center = Box.allBoxes.get(i).getCenter();
				System.out.println((i + 1) + ".");
				System.out.println("   Center: (" + center[0] + ", " + center[1] + ")");
				System.out.println("   Height: " + Box.allBoxes.get(i).getHeight());
				System.out.println("   Width: " + Box.allBoxes.get(i).getWidth());
			}
			
			int selectedBox = testInt(keyboard) - 1;
			
			while (selectedBox < 0 || selectedBox > (max - 1)) {
				System.err.println("The number you entered is not an option. Choose one of the boxes above.");
				
				selectedBox = testInt(keyboard) - 1;
			}
			
			boolean repeat = true;
			int[] center = Box.allBoxes.get(selectedBox).getCenter();
			
			while(repeat == true) {
				
				System.out.println("What would you like to change?");
				System.out.println("  1.  Center: (" + center[0] + ", " + center[1] + ")");
				System.out.println("  2.  Height: " + Box.allBoxes.get(selectedBox).getHeight());
				System.out.println("  3.  Width: " + Box.allBoxes.get(selectedBox).getWidth());
			
				switch (testInt(keyboard)) {
				case 1:
					
					System.out.print("         X-Coordinate: ");
					int x = center[0] = testInt(keyboard);
					System.out.print("         Y-Coordinate: ");
					int y = center[1] = testInt(keyboard);
					Box.allBoxes.get(selectedBox).setCenter(x, y);
					break;
				case 2:
					
					System.out.print("         Height: ");
					int height = testInt(keyboard);
					Box.allBoxes.get(selectedBox).setHeight(height);
					break;
				case 3:
					
					System.out.print("         Width: ");
					int width = testInt(keyboard);
					Box.allBoxes.get(selectedBox).setHeight(width);
					break;
				default:
					
					System.out.println("I'm sorry, that was not a valid option.");
					break;
				}
				
				System.out.println("Would you like to change something else? (y/n)");
				String nextString = keyboard.next();
				if (nextString.equals("n")) {
					repeat = false;
				} else if (!nextString.equals("y")){
					System.out.println("That is not a valid response. Quitting editor now.");
					repeat = false;
				}
			}
			
			System.out.println("Your final box after changes is:");
			System.out.println("   Center: (" + center[0] + ", " + center[1] + ")");
			System.out.println("   Height: " + Box.allBoxes.get(selectedBox).getHeight());
			System.out.println("   Width: " + Box.allBoxes.get(selectedBox).getWidth());
			
			System.out.println("Would you like to continue editting boxes? (y/n)");
			String nextString = keyboard.next();
			if (nextString.equals("y")) {
				changeBox();
			} else if (!nextString.equals("y")){
				System.out.println("That is not a valid response. Quitting editor now.");
				
				presentMenu();
			} else {
				presentMenu();
			}
		}
	}
	
	private void changeLine() {
		
		int max = Line.allLines.size();
		Scanner keyboard = new Scanner(System.in);
		
		if (max == 0) {
			System.err.println("There are no lines to edit. Press 2 on main menu to create your first line.");
			
			presentMenu();
		} else {
			
			System.out.println("In total there have been " + max + " line(s) created.\n");
			System.out.println("Choose one of the following to edit:");
			
			for(int i = 0; i < max; i++) {
				int[] startPoint = Line.allLines.get(i).getXY(0);
				int[] endPoint = Line.allLines.get(i).getXY(1);
				System.out.println((i + 1) + ".");
				System.out.println("   Start Point: (" + startPoint[0] + ", " + startPoint[1] + ")");
				System.out.println("   End Point: (" + endPoint[0] + ", " + endPoint[1] + ")");
			}
			
			int selectedLine = testInt(keyboard) - 1;
			
			while (selectedLine < 0 || selectedLine > (max - 1)) {
				System.err.println("The number you entered is not an option. Choose one of the Lines above.");
				
				selectedLine = testInt(keyboard) - 1;
			}
			
			boolean repeat = true;
			int[] startPoint = Line.allLines.get(selectedLine).getXY(0);
			int[] endPoint = Line.allLines.get(selectedLine).getXY(1);
			
			while(repeat == true) {
				
				System.out.println("What would you like to change?");
				System.out.println("  1.  Start Point: (" + startPoint[0] + ", " + startPoint[1] + ")");
				System.out.println("  2.  End Point: (" + endPoint[0] + ", " + endPoint[1] + ")");
				
				switch (testInt(keyboard)) {
				case 1:
					
					System.out.print("         X-Coordinate: ");
					int x = startPoint[0] = testInt(keyboard);
					System.out.print("         Y-Coordinate: ");
					int y = startPoint[1] = testInt(keyboard);
					Line.allLines.get(selectedLine).setXY(0, x, y);
					break;
				case 2:
					
					System.out.print("         X-Coordinate: ");
					x = endPoint[0] = testInt(keyboard);
					System.out.print("         Y-Coordinate: ");
					y = endPoint[1] = testInt(keyboard);
					Line.allLines.get(selectedLine).setXY(1, x, y);
					break;
				default:
					
					System.out.println("I'm sorry, that was not a valid option.");
					break;
				}
				
				System.out.println("Would you like to change something else? (y/n)");
				String nextString = keyboard.next();
				if (nextString.equals("n")) {
					repeat = false;
				} else if (!nextString.equals("y")){
					System.out.println("That is not a valid response. Quitting editor now.");
					repeat = false;
				}
			}
			
			System.out.println("Your final line after changes is:");
			System.out.println("   Start Point: (" + startPoint[0] + ", " + startPoint[1] + ")");
			System.out.println("   End Point: (" + endPoint[0] + ", " + endPoint[1] + ")");
			
			System.out.println("Would you like to continue editting lines? (y/n)");
			String nextString = keyboard.next();
			if (nextString.equals("y")) {
				changeLine();
			} else if (!nextString.equals("y")){
				System.out.println("That is not a valid response. Quitting editor now.");
				
				presentMenu();
			} else {
				presentMenu();
			}
		}
	}
	
	private void showDrawings() {

		Drawing pencil = new SimpleDrawing();
		Box.drawAllBoxes(pencil);
		Line.drawAllLines(pencil);
	}
	
	
	private int testInt(Scanner keyboard) {
		
		int nextInt = -1;
		
		if (keyboard.hasNextInt()) {
        	nextInt = keyboard.nextInt();
        } else {
        	
        	String temp = keyboard.next();
        	if(!temp.equals("q")) {
        		System.err.println("The value you entered was not an integer, please try again.");
            	System.err.println("If you wish to quit type 'q' and then press enter.");
        		
        		testInt(keyboard);
        	}
        }
		
		return nextInt;
	}*/
}
