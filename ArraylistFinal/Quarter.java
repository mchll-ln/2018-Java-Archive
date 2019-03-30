/**
 * Author: Michelle Lin
 * File: Quarter.java
 * Date: Wednesday April 4th, 2018
 * Description: Subclass <Quarter> inherits from the class <Coin>
 */
public class Quarter extends Coin {
 private double individCoinValue;
	 
	 public Quarter(double iValue) {
		 individCoinValue = iValue;
	 }

	 public double getValue() {// Gets value of a coin via an over-riding method 
	  return individCoinValue;
 }
}
