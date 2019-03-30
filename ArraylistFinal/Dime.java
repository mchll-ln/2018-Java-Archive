/**
 * Author: Michelle Lin
 * File: Dime.java
 * Date: Wednesday April 4th, 2018
 * Description: Subclass <Dime> inherits from the class <Coin>
 */
public class Dime extends Coin{
	 private double individCoinValue;
	 

	 public Dime(double iValue) {
		 individCoinValue = iValue;
	 }

	 public double getValue() {// Gets value of a coin via an over-riding method 
	  return individCoinValue;
	 }
	}