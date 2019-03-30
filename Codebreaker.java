import java.util.*;
import java.util.Random;

public class Codebreaker {
	// main method - Testing & Debugging purposes only
	public static void main(String[] args) {
		final String str = "GRBYOP";
		final int n=4;
		String[] code = {"Y","G","B","O"}; 
		String[] guess = {"P","B","R","O"}; 
		
		createCode(str, n); //call <createCode> method and return String[] list
		findFullyCorrect(code, guess); //call <findFullyCorrect> method and return String[] correct
		findColourCorrect(code, guess); //call <findColouryCorrect> method and return String[] coCorrect
	}

	/**
	 * File: Codebreaker.java
	 * Method: createCode(String str,int n)
	 * Date: Thursday March 8th, 2018
	 * Author: Michelle Lin
	 * Description: Randomly generated numbers are used to return a randomly generated array,
	 * the length size of the input n. The values of the array are comprised of the characters of the input str.
	 * 
	 * Algorithm: 
	 * Declare and initialize array <list>  with size<n>.
	 * Declare random number generator. 
	 * Create for loop of int i=0; i<n; i++.
	 * In for loop: declare and set int <num> as any integer between 0 and the length of <str>
	 * 	Declare and initialize char <hold> as the character of string at position <num>
	 *  Set list[i] as <hold>
	 * return <list>
	 * 
	 * @param String str
	 * @param int n
	 * @return String[] list
	 */
	public static String[] createCode(String str,int n){ //method will return String array
	String[] list = new String[n]; //Declare String array to hold randomly generated array of length <n> and comprised of the character of str
	Random ran = new Random(); //Declare random number generator <ran>
	
	for(int i=0; i<n; i++){ //Loop for <n> number of times
		int num = ran.nextInt(str.length()); //set int <num> as any integer between 0 and the length of <str>
		char hold = str.charAt(num); //Set <hold> as the character of string at position <num>
		list[i] = Character.toString(hold); //Set list[i] as <hold> char
			}
return list; //String array will be returned
	}

	/**File: Codebreaker.java
	 * Method: findFullyCorrect(String[] code, String[] guess)
	 * Date: Thursday March 8th, 2018
	 * Author: Michelle Lin
	 * Description: Compare String array <code> with String array <guess> values, return the number of "b"s equal to 
	 * the number of values in <code> that are the same in <guess> and in the same positions.  
	 * 
	 * Algorithm:
	 * Declare counter <b> for # correctly positioned colours
	 * Use for loop with int i =0; i< code.length; i++
	 * Inside for loop: sequentially compare if <code>[i] == <guess>[i], if true: increment <b>
	 * Declare <correct> array.I
	 * Initialize <correct> array as <b>
	 * Create for loop with a maximum number of loops equal to length of <correct>.
	 * Within for loop set correct[i] = "b";
	 * 
	 * @param String[] code
	 * @param String[] guess
	 * @return String[] correct
	 */

	public static String[] findFullyCorrect(String[] code, String[] guess) { //method will return String array
		int b = 0; //Declare and initialize counter to hold the # of correct guesses correctly positioned colours of guesses
		
		for(int i =0; i< code.length; i++){ //loop for (the length of <code>) number of times
			if(code[i].equals(guess[i])){ //Compare <code> and <guess> both at position i
				b++; //increment <b>
			}
	}
		String[] correct = new String[b]; //Declare and initialize <correct> as length <b> to list using "b" the number of correct guesses
		for(int i =0; i<b;i++){ //loop <b> number of times
			correct[i] = "b"; //set index <i> of <correct> as "b"
		}
		return correct; //return number of correct guesses as a String array of "w"s
		}

	/**
	 * File: Codebreaker.java
	 * Method: findColourCorrect(String[] code, String[] guess)
	 * Date: Thursday March 8th, 2018
	 * Author: Michelle Lin
	 * Description: Compare String array <code> with String array <guess> values, return the number of "w"s equal to 
	 * the number of values in <code> that are the same in <guess> but in different positions.  
	 * 
	 * Algorithm:
	 * Declare & initialize counter w as 0
	 * Create for loop as int i=0; i<guess.length; i++ and nest for loop of int j=0; j<code.length; j++ inside
	 * If guess[i].equals(j), increment w;  
	 * Declare <coCorrect> array. 
	 * Initialize <coCorrect> array as size <w>
	 * Create for loop of int i=0; i<coCorrect.length; i++. Within loop set coCorrect[i] as "w";
	 * return w array
	 * 
	 * @param String[] code
	 * @param String[] guess
	 * @return String[] coCorrect
	 */
	public static String[] findColourCorrect(String[] code, String[] guess) {//method will return String array
		int w =0;// Declare & initialize counter w as 0
		for(int i=0; i<guess.length; i++){ // 1st for loop, loops <guess> for(the length of <guess>) number of times
				for(int j=0; j<code.length; j++){ //Nested for loop, loops for (the length of <guess>) number of times
					if(guess[i].equals(code[j])){ //Sequentially compares <guess> at index <i> with <code> at index <j>
						w++; //increment <w>
					}
				}
		}
		String[] coCorrect = new String[w];//String array of size <w> to hold number of correct colour guesses as a list of "w"s
		for(int i=0; i<coCorrect.length; i++)//loop for (the number of correct colour guesses)times/(the length of <code>) number of times 
		{
		coCorrect[i] = "w"; //set index <i> of <coCorrect> as "w"
		}
		return coCorrect;//return number of correct colour guesses as a String array of "w"s
	}
	
}