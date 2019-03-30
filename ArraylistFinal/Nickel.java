/**
 * Author: Michelle Lin
 * File: Nickel.java
 * Date: Wednesday April 4th, 2018
 * Description: Subclass <Nickel> inherits from the class <Coin>
 */
public class Nickel extends Coin {
 private double individCoinValue;
 

 public Nickel(double iValue) {
	 individCoinValue = iValue;
 }

 public double getValue() {// Get value of a coin via an over-riding method 
  return individCoinValue;
 }
}