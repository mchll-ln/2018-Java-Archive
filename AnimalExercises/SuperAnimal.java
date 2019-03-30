/*Author: Michelle Lin
 * File: SuperAnimal.java
 */
public class SuperAnimal extends Animal {
	boolean wings;
	boolean teleport;
	
	public SuperAnimal(String defaultName, String startHabitat, int startMass,String startEnergyLevel, int startAge, boolean startWings, boolean startTeleport){
		super(defaultName, startHabitat, startMass, startEnergyLevel, startAge);
		
		wings = startWings;
		teleport = startTeleport;
	}
	
	public void setName(String newName){
		super.setName(newName);
	}
	
	public String getName(){
		return super.getName();
	}

	public String fly(){
	if(wings == true){
		String canfly = name + " can fly. ";
	return canfly;
	}
	else{
		String nofly = name + " can't fly. ";
		return nofly;
	}
	}
	public String canTeleport(String toPlace){
		if(teleport == true){
			String cantel = name + " can teleport to " + toPlace;
		return cantel;
		}
		else if(teleport == false){
			String notel = name + " cannot teleport to " + toPlace;
			return notel;
		}
		else{
			return "error";
		}
	}
	//d
	public void noWings(){
		wings = false;
		}	
	}	