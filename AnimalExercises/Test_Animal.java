/*Author: Michelle Lin
 * File: Test_Animal.java
 */

import java.util.*;

public class Test_Animal {
	 public static void main (String[] args) 
	  {
	    //Declare an object using a constructor
	    Animal an1 = new Animal("Bobby", "ocean",120,"medium", 12);
	    System.out.println(an1.getName());
	    	    an1.setName("Tom");
	    System.out.println(" changed to: "+ an1.getName());
	    System.out.println(" Energy level after sleep changed to: " + an1.sleep());
	    
	    Animal an2 = new Animal("Bobby", "ocean",120,"medium", 12);

	   	    
}
}