/**
 * Author: Michelle Lin
 * File: MySavings2.java
 * Date: Wednesday April 4th, 2018
 * Description: The main class that prompts the user to make a selection from a displayed menu of choices for entering nickels, 
 * dimes, quarters and loonies into a piggy bank.  
 */
import java.util.*;

public class MySavings2 {
 static Scanner input = new Scanner(System.in);
 static PiggyBank2 account = new PiggyBank2();//Declaring an ArrayList to store coins

public static void main(String[] args){
	int selection;
	Welcome();
do {
	mainMenu();//calls the method containing the options of the main menu
	selection = input.nextInt();
	if (selection == 1) {
		System.out.println("Current total amount: " + getAmountInPB());
	   } else if (selection == 2) {
	    account.addNickel();
	    System.out.println("A Nickel has been added to your account");
	   } else if (selection == 3) {
	    account.addDime();
	    System.out.println("A Dime has been added to your account");
	   } else if (selection == 4) {
	    account.addQuarter();
	    System.out.println("A Quarter has been added to your account");
	   } else if (selection == 5) {
	    account.addLoonie();
	    System.out.println("A Loonie has been added to your account");
	   } else if (selection == 6) {
	    System.out.println("Money will be withdrawn from your account.");
	    withdraw();
	   } else if (selection == 0) {
	    break;
	   } else {
	    System.out.println("Wrong input, try again");
	   }
	   System.out.println("You will be re-directed to the main menu");
	  } while (selection != 0);
	  System.out.println("Exit successful.");
	 }
public static void Welcome() {//Outputs a greeting to the user with their name
	String name;
	System.out.println("Please enter your name");
	name = input.nextLine();  
	System.out.println("Hello " + name + ". Please select an option by entering the corresponding number. ");
	 }
public static void mainMenu(){//displays the main menu instructing the user on how to use this program
	System.out.println("1.	Show total in bank");
	System.out.println("2.	Add a nickel.");
	System.out.println("3.	Add a dime.");
	System.out.println("4.	Add a quarter.");
	System.out.println("5.	Add a loonie");
	System.out.println("6.	Take money out of the bank.");
	System.out.println("Enter 0 to quit.");
	System.out.println("Enter your choice:  ");
}
public static double getAmountInPB() {//method returns the current balance in the account.
	  double totNickel = account.getCoinNum("Nickel") * 0.05;
	  double totDime = account.getCoinNum("Dime") * 0.1;
	  double totQuarter = account.getCoinNum("Quarter") * 0.25;
	  double totLoonie = account.getCoinNum("Loonie") * 1;
	  double sum = (totNickel + totDime + totQuarter + totLoonie);//stores the monetary sum value of all the nickels, dimes, quarters, and loonies 
	  return(double)Math.round(sum*100)/100;	//returns the amount in the piggybank by rounding the <sum> to two decimal places
}
public static void withdraw() {//method that uses conditional statements to withdraw individual coins based on the user's input
	int selection;
	  do {
	   withdrawMenu();
	   selection = input.nextInt();
	   if (selection == 1) {
	    System.out.println("Current total amount: " + getAmountInPB());
	   }else if (selection == 2) {
		   if (account.getCoinNum("Nickel") <= 0) {
	     System.out.println("There are no nickels. Unable to perform withdrawal.");
	    } else {
	     account.drawNickel();
	     System.out.println("A Nickel has been withdrawn from your account");
	    }
	   } else if (selection == 3) {
	    if (account.getCoinNum("Dime") <= 0) {
	     System.out.println("There are no dimes. Unable to perform withdrawal..");
	    } else {
	     account.drawDime();
	     System.out.println("A Dime has been withdrawn from your account");
	    }
	   } else if (selection == 4) {
	    if (account.getCoinNum("Quarter") <= 0) {
	     System.out.println("There are no quarters. Unable to perform withdrawal.");
	    } else {
	     account.drawQuarter();
	     System.out.println("A Quarter has been withdrawn from your account");
	    }
	   } else if (selection == 5) {
	    if (account.getCoinNum("Loonie") <= 0) {
	     System.out.println("There are no loonies. Unable to perform withdrawal.");
	    } else {
	     account.drawLoonie();
	     System.out.println("A Loonie has been withdrawn from your account");
	    }
	   }
	   else if (selection == 0) {
	    System.out.println("Returning to the main menu...");
	    break;
	   } else {
	    System.out.println("Invalid input. Please try again.");
	   }
	  } while (selection != 0);
	 }
	 public static void withdrawMenu() {//displays a sub-menu, instructing the user on how to withdraw money
			System.out.println("1. Display the total amount in the bank");
			System.out.println("2. Withdraw a nickel");
			System.out.println("3. Withdraw a dime");
			System.out.println("4. Withdraw a quarter");
			System.out.println("5. Withdraw a loonie");
			System.out.println("0. Return to the main menu");
			}
}
