/**
 * Author: Michelle Lin
 * File: Loonie.java
 * Date: Wednesday April 4th, 2018
 * Description: Subclass <Loonie> inherits from the class <Coin>
 */
public class Loonie extends Coin {
 private double individCoinValue;
	 

	 public Loonie(double iValue) {
		 individCoinValue = iValue;
	 }

	 public double getValue() {// Gets value of a coin via an over-riding method 
	  return individCoinValue;
 }
}