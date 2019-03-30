
/*Author: Michelle Lin
 * File: Test_Shapes.java	
 */
import java.util.*;

public class Test_Shapes {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		Shapes[] myShapes = new Shapes[1];
		char response;
		for (int i = 0; i < myShapes.length; i++) {
			System.out.println("What kind of shape would you like to draw? c: circle, s: square, t: triangle");
			//String response = myScanner.nextLine();
			response = myScanner.nextLine().charAt(0);
			if (response == 'c') {
				myShapes[i] = new Circles();
			} else if (response == 't') {
				myShapes[i] = new Triangle();
			} else if (response == 's') {
				myShapes[i] = new Square();
			}
		} // end for
		 System.out.println("Here are the shapes you entered");
		for (int i = 0; i < myShapes.length; i++) {
			myShapes[i].draw();
		}
		}
}
