/**
 * Author: Michelle Lin
 * File: PiggyBank2.java
 * Date: Wednesday April 4th, 2018
 */
import java.util.ArrayList;
public class PiggyBank2 {
 //declaring and initializing static variables to keep track of the numbers of each coin
 private static int numNickel= 0;
 private static int numDime= 0;
 private static int numQuarter= 0;
 private static int numLoonie= 0;

 ArrayList <Coin> coinList = new ArrayList <Coin> ();//declaring an ArrayList with the new object type
 
 //methods add specified coins to the new ArrayList
 public void addNickel() {
	 coinList.add(new Nickel(0.05));
  numNickel++;
 }public void addDime() {
	 coinList.add(new Dime(0.1));
  numDime++;
 }
 public void addQuarter() {
	 coinList.add(new Quarter(0.25));
  numQuarter++;
 }
 public void addLoonie() {
	 coinList.add(new Loonie(1));
  numLoonie++;
 }
 
 //methods for withdrawing coins
 public void drawNickel() {
	 coinList.remove(new Nickel(0.05));
  numNickel--;
 }public void drawDime() {
	 coinList.remove(new Dime(0.1));
  numDime--;
 }
 public void drawQuarter() {
	 coinList.remove(new Quarter(0.25));
  numQuarter--;
 }
 public void drawLoonie() {
	 coinList.remove(new Loonie(1));
  numLoonie--;
 }
 
 public void setNumOfCoin(String coin,int newNum) {
  boolean type = true;//Ensures the type of coin is valid. (ie. nickel, dime, quarter, loonie)
  do {
   if (coin.equals("Nickel")) {
    numNickel = newNum;
   }
   else if (coin.equals("Dime")) {
    numDime = newNum;
   }
   else if (coin.equals("Quarter")) {
    numQuarter = newNum;
   }
   else if (coin.equals("Loonie")) {
    numLoonie = newNum;
   }
   else {
    type = false;
   }
  }while(type==true);
 }
 
 public static int getCoinNum(String coin) {
  boolean type = true; //Ensures the type of coin is valid. (ie. nickel, dime, quarter, loonie)
  do {
   if (coin.equals("Nickel")) {
    return numNickel;
   }
   else if (coin.equals("Dime")) {
    return numDime;
   }
   else if (coin.equals("Quarter")) {
    return numQuarter;
   }
   else if (coin.equals("Loonie")) {
    return numLoonie;
   }
   else {
    type = false;
    return 0;//Ensures return type is compilable
   }
  }while(type==true);  
 }
 
}
