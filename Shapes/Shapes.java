
/*Author: Michelle Lin
 * File: Shapes.java	
 * 1) characteristics, private double x,y
 * 2) 2 Abstract methods: draw(), erase()
 * 3) Circle extends Shape| public void draw(); output("this is a circle")
 * 4) Create class Square..draw() erase()
 * 5) Create Triangle Class
 * 	� Try to create the superclass and all its subclasses.
	� For the draw method, use character graphics
	� Identify attributes that would be common to all and organize them into the hierarchy
	� Then create the main method and test the program
 */
public abstract class Shapes {

		private double x,y;
		
		public abstract void draw();
		
		public abstract void erase();
		}


