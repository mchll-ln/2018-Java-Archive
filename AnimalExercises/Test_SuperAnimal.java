/*Author: Michelle Lin
 * File: Test_SuperAnimal.java
 */

import java.util.*;

public class Test_SuperAnimal {
	 public static void main (String[] args) 
	  {
	    //Declare an object using a constructor
	    SuperAnimal an1 = new SuperAnimal("Bobby", "ocean",120,"medium", 12, true, false);
	    //System.out.println(an1.booCheck());
	    //an1.noWings();
	    System.out.println(an1.fly());
	    System.out.println(an1.canTeleport("there"));
	    
	    an1.setName("Tom");
	    System.out.println(" changed to: "+ an1.getName());

	    SuperAnimal an2 = new SuperAnimal("Bobby", "ocean",120,"medium", 12, false, true);
	    System.out.println(an2.fly());
	    System.out.println(an2.canTeleport("there"));
	   	    
}
}