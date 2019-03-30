//corrected version
import java.util.ArrayList;
import java.util.*;

public class ArrayTest_B {
 
 static Scanner input = new Scanner(System.in);

 public static void main(String[] args) {
  ArrayList <String>tasks = new ArrayList<String>();
  String done;
  //int end;
  int n;
  System.out.println("How many items would you like to enter?");
  int max= input.nextInt();
  
 
  enterItem(tasks, max);
  do{
	  System.out.println("");
  System.out.println("Menu: Enter a number");
  System.out.println("0: Exit");
  System.out.println("1: Display items");
  System.out.println("2: Mark items as bought");
  System.out.println("3: Check if all items are bought");
  System.out.println("4: sort your shopping list alphabetically");
  n= input.nextInt();
  input.nextLine();
  
  
 if(n==1){
  displayItems(tasks);
  //break;
  }
  else if(n==2){
  System.out.println("Enter an item to mark as done");
  done = input.nextLine();

  markBought(tasks, done);
  //break;
  }
  else if(n==3){
  areItemsBought(tasks);
 //break;
  }
  else if(n==4){
  sort(tasks);
 //break;
  }
  }while(n!=0);
 }
 
 public static void enterItem(ArrayList<String> tasks, int max){
//String item;
int i;
//System.out.println("How many items would you like to enter?");
//max= input.nextInt();
//tasks.size(max);

for(i =0; i<max;i++){
 System.out.println("Enter items for the Shopping List");
 String item= input.next();
 tasks.add(item);
 }
 }
 
 public static void displayItems(ArrayList<String> tasks){
	System.out.print("[");	 
	 for(int j=0; j < tasks.size();j++){
			 	System.out.print(" "+ tasks.get(j)+",");
		 }
	 System.out.print("]");	
 }
 
 public static void markBought(ArrayList<String> tasks, String done){
int a = 0;	 

boolean alt = true;
for(int i =0; i<tasks.size();i++){
	if(tasks.get(i).equals(done) && !tasks.get(i+1).equals("****")){
		tasks.add(i+1, "****");
		alt =false;
	}
}
if(alt==true){
	 System.out.println("The item does not exist or has already been marked.");
	
}
displayItems(tasks); 
	 /**for(int i =0; i<tasks.size();i++){
		 if(tasks.get(i).compareToIgnoreCase(done)==0 && tasks.get(i+1).equals("****")){
			 System.out.println("Item is already marked as bought");
			 break;
	 }
		 else if(tasks.get(i).compareToIgnoreCase(done)==0){
			 tasks.add(i+1, "****");
			 break;
}
		 a++;
 }
	 displayItems(tasks);
	 
	 if(tasks.size()==a){
	 System.out.println("The item does not exist.");
	 }
	 **/
 }
 
 public static boolean areItemsBought(ArrayList<String> tasks){
	 boolean all = true;

	 for(int i =0; i<tasks.size();i+=2){
		 if(tasks.get(i).compareToIgnoreCase("****")<0){
			 all = true;
			 }
		 else{
			 all= false;
		 }
 }
	  return all;
 
}
 public static void sort(ArrayList<String> tasks){
	 boolean swap;
	 int j =1;
	 String temp;
	 
	 do{
		 swap=false;
	 for(int i =0; i<tasks.size()-j;i++){
		 swap= true;
		 if(tasks.get(i).compareToIgnoreCase(tasks.get(i+1))>0){
			 temp = tasks.get(i);
			 tasks.set(i, tasks.get(i+1)); 
			 tasks.set(i+1, temp);
	 }
	 }
		 j++;
 }while(swap==true);
	
	 System.out.println(" Alphabetical list: ");
	 displayItems(tasks);
	 /**for(int i =0; i<tasks.size();i++){
 System.out.print(" "+ tasks.get(i)+",");
 }
**/
 }
}