
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class Arrays2D {
	  
	  private static Scanner myScanner = new Scanner(System.in); 
	 
	  public static void main(String[] args) throws FileNotFoundException {
	 //Q2 
		  int marks[][] = new int[30][9]; // create a 2D array called marks  
    populateMarks(marks);
   
    //Q10   
    int call;
    do
    {
      System.out.println("1: exit");
      System.out.println("3: Display Student Marks");
      System.out.println("4: Get mean & median");
      System.out.println("5: Display class average");
      System.out.println("6: calculate overall average");
      System.out.println("7: Display class marks");
      System.out.println("8: Get max");
      System.out.println("9: Edit mark");
      System.out.println("");
      call=myScanner.nextInt();
      
      if (call==1){
        break;
      } 
      else if(call==3){
    	    displayStudentMarks(marks);
      }
      else if(call==4){
    	    getMean(marks);
     	   getMedian(marks);
      }
      else if(call==5){
    	   classAverage(marks);
      }
      else if(call==6){
  overallAverage(marks); 
      }
      else if(call==7){
displayClassMarks(marks);
      }
      else if(call==8){
        getMax(marks); 
      }
      else if(call==9){
    	  editMark(marks);
      }
      else{
        System.out.println("wrong option. try again.");
      }
      
    }while (call!=1);
    
    System.out.println("thank you");
  }
  
	  
    public static void populateMarks(int[][] marks) throws FileNotFoundException {
      Scanner file = new Scanner(new File("marks.csv")); 
      
      int index = 0;
      while (file.hasNext()) {
        String line = file.nextLine();
        Scanner items = new Scanner(line);
        items.useDelimiter(",");
        for (int c = 0; c <= 8; c++) {
          marks[index][c] = items.nextInt();
        }
        items.close();
        index++; 
        
      }
      file.close();
    }
 //Q3
  public static void displayStudentMarks (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  System.out.println("Enter a student number");
    int num = myScanner.nextInt();
    
    for(int r=0; r<marks.length;r++)
    {
    	if(num == marks[r][0]){
        for(int c =0; c <marks[r].length;c++){
        		System.out.println(" " + marks[r][c]);
	      }
        break;
	    }
	    }
	  
  }
  
  //Q4a
  public static void getMean (int marks[][]){
	  Scanner input = new Scanner(System.in); 
	  
	System.out.println("Enter a student number");
    int num = input.nextInt();
    
    int avg=0;
    
    for(int r=0; r<marks.length;r++){
    	if(num == marks[r][0]){
        for(int c =1; c <marks[r].length;c++){
        	avg = avg + marks[r][c];
        }
        break;
	    }
	    }
    System.out.println(" Mean: " + (avg/8));
	  
  }

  //Q4b
  public static void getMedian (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  
	  System.out.println("Enter a student number");
    int num = myScanner.nextInt();
    int median=0;
    
    for(int r=0; r<marks.length;r++)
    {
    	if(num == marks[r][0]){
        for(int c =0; c <marks[r].length;c++){
        	   boolean swap;
        	    int j=1;
        	    int temp;
        	    do{
        	      swap=false;
        	      for (int i=0;i<marks[r].length-j;i++){
        	        if (marks[r][i]>marks[r][i+1]){
        	          temp=marks[r][i];
        	          marks[r][i]=marks[r][i+1];
        	          marks[r][i+1]=temp;
        	          swap=true;
        	        }
        	      }
        	      j++; 
        	    }while(swap);
        	    
median = (marks[r][3]+ marks[r][4])/2;
	      }
        break;
	    }
	    }
	  System.out.println(" Median" + median);
	  
  }

  //Q5
  public static void classAverage (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  
	System.out.println("Enter assessment #");
    int num = myScanner.nextInt();
    
    int sum = 0;
    for(int r=0; r<marks.length;r++){
    	sum = sum + marks[r][num];
  }
        		System.out.println(" Class Average:" + (sum/marks.length));
	      }

  //Q6
  public static void overallAverage (int marks[][]){
	int avg [] = new int[30];
	int all=0;
	int sum =0;
	
    for(int r=0; r<marks.length;r++){//go through rows
        for(int c =1; c <marks[r].length;c++){//go through columns of r row
        		sum = sum + marks[r][c];//Accumulate each cell of row r and column c in sum
	      }
        avg[r] = (sum/8); //Take sum of student x and divide to find average & add to avg array
    sum = 0;    
    }

    for(int i=0; i<avg.length; i++){
    	all = all + avg[i];
    }
   
    System.out.println("overall average:" + (all/30));
    }
	  

  //Q7
  public static void displayClassMarks (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  
	  System.out.println("Enter assessment #");
    int num = myScanner.nextInt();
    
    for(int r=0; r<marks.length;r++)
    {
        		System.out.println(" Student #: " + marks[r][0] + " mark: " + marks[r][num]);
	    }
  }
 
  //Q8
  public static void getMax (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  
	System.out.println("Enter assessment #");
    int num = myScanner.nextInt();
    
    int max = 0;
    int stu = 0;
    
    for(int r=0; r<marks.length;r++)
    {
    	if(max<marks[r][num])
    	{
    		max = marks[r][num];
    		stu = marks[r][0];
    	}
    	}
        		System.out.println(" Maximum mark: Student #: " + stu + " mark: " + max);
  }

  //Q9
  public static void editMark (int marks[][]){
	  Scanner myScanner = new Scanner(System.in); 
	  
	  System.out.println("Enter a student number of mark to edit");
    int stuNum = myScanner.nextInt();
    
    System.out.println("Enter # of assessment to edit");
    int aNum = myScanner.nextInt();
    
    for(int r=0; r<marks.length;r++)
    {
    	if(stuNum == marks[r][0]){
    		System.out.println(" Current mark:" + marks[r][aNum]);	

        System.out.println("Enter new mark");
        int mark2 = myScanner.nextInt();
        		marks[r][aNum] = mark2;
        		break;
    	}
    }
	  
  }
}
