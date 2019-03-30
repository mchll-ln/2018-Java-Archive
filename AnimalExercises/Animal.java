/*Author: Michelle Lin
 * File: Animal.java
 */

import java.util.*;

public class Animal {	  //Constructor method 
	static Scanner input = new Scanner(System.in);// Scanner class declared as global variable   

	//Characteristics
String name;
String habitat;
int mass;
String energyLevel;
int age;

public Animal(String defaultName, String startHabitat, int startMass, String startEnergyLevel, int startAge)
{
	    name = defaultName;
	    habitat = startHabitat;
	    mass = startMass;
	    energyLevel = startEnergyLevel;
	    age = startAge;
	  }
	  
	  //Behaviours: Communicators and behaviours
	  public String getName() //returns name of the object
	  {
	    return name;
	  }
	  
	  public void setName(String newName) //sets a new name for the object 
	  {
	    name = newName;

	  }
	  public int getMass() 
	  {
	    return mass;
	  }
	  
	  public void setMass(int newMass) 
	  {
	    mass = newMass;
	  }
	  
	  public String getHabitat()
	  {
	    return habitat;
	  }
	  
	  public void setHabitat(String newHabitat)
	  {
	    habitat = newHabitat;
	  }
	  public String getEnergyLevel() 
	  {
	    return energyLevel;
	  }
	  
	  public void setEnergyLevel(String newEnergyLevel) 
	  {
		  energyLevel = newEnergyLevel;
	  }
	  
	  public int getAge() 
	  {
	    return age;
	  }
	  
	  public void setAge(int newAge) 
	  {
		  age = newAge;
	  }
	  
	  public String searchFood(String energyLevel)
	  {
		  energyLevel = "low";
		  return energyLevel;
	  }
	  public void migrate(String newHabitat)
	  {
		    habitat = newHabitat;
	}
	  public int eat(int foodmass) 
	  {
		  mass = mass + foodmass;
		  return mass;
	  }
	  public String sleep()
	  {
		  return energyLevel = "restored";

	  }
	  public void die(int age){
		  age = 0;
	  }
	  }