import java.util.Scanner;

import java.util.ArrayList; //Import library

public class QuizPractice { 
  
  public static void main(String[] args) { 
    
    
    Scanner kb = new Scanner (System.in);
    //Arraylist with a type declaration
    
    Arraylist<String>a1 = new ArrayList<String>(); // implied in line22
    //Declare an arrayList called a1 that can store items                                                Quiz       10/ 12
   
                                        ;//Generic declaration      1.5/2
    
    
    
    String input; 
    
    //Fill in the answers for the blanks below
    
    System.out.println("Initial size of a1 after declaration is: "+ a1.size());   //Output would be 0______________   1/1
    System.out.println("Press a key to continue");
    input = kb.nextLine();
    
    //Adding items to the arraylist
    a1.add("C");// position 0
    a1.add("A");//1
    a1.add("E");//2
    a1.add("B");//3
    a1.add("D");
    a1.add("F");
    //Inserting an item A2 in the 2nd position of the array (in between C and A       
    a1.add(1,"A2")                                                                           //______________   1/2
    
    
    System.out.println("Size of a1 after adding 7 items  is: "+ a1.size()); //Output would be 7______________   2/2
    System.out.println("Press a key to continue");
    input = kb.nextLine();
    
    System.out.println("The contents of a1 is: "+ a1); //Output would be CA2AEBDF_____________________________   2/2
    System.out.println("Press a key to continue");
    input = kb.nextLine();
    
//Remove elements from the array
    a1.remove("F");
    a1.remove(2);
    
    System.out.println("Size of a1 after  deletions  is: "+ a1.size());//Output would be 5______________   1/1
    System.out.println("Press a key to continue");
    input = kb.nextLine();
    
    
    System.out.println("The contents of a1 after removing F and the 2nd item is: "+ a1);//Output would be CA2EBD _____________________________   1.5/2
    System.out.println("Press a key to continue");
    input = kb.nextLine();
    
    
  } 
} 
