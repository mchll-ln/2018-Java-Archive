 import java.util.*;

 public class Array {
   
   private static Scanner input = new Scanner(System.in); 
  
   public static void main(String[] args){
	   
    int[] num = new int[10];
    EnterFromKeyboard(num);
      int get;
      do
      {
        System.out.println("Input:");
        System.out.println("1: exit");
        System.out.println("2: assign -1 to every element");
        System.out.println("4: display all whole #s entered");
        System.out.println("5: Print array in the order entered");
        System.out.println("6: display the list in reverse order");
        System.out.println("7: Sum");
        System.out.println("8: Average");
        System.out.println("91: Max number");
        System.out.println("92: Min number");
        System.out.println("10: search for the position of the number");
        System.out.println("12: sort the numbers in ascending order using the bubble sort method");
        System.out.println("13: sort the numbers in ascending order using the improved bubble sort method");
        System.out.println("14: mean");
        System.out.println("15: median");
        System.out.println("16: mode");
        get=input.nextInt();
        
        if (get==1){
          break;
        } 
        else if(get==2){
          InitializeArray(num); 
        }
        else if(get==4){
          CountWhole(num); 
        }
        else if(get==5){
          Display(num); 
        }
        else if(get==6){
          DisplayReverse(num); 
        }
        else if(get==7){
          System.out.println("the sum is " + Sum(num)); 
        }
        else if(get==8){
          Average(num); 
        }
        else if(get==91){
          System.out.println("the maximum number is " + FindMax(num)); 
        }
        else if(get==92){
          System.out.println("the minimum number is " + FindMin(num)); 
        }
        else if(get==10){
          Search(num); 
        }
        else if(get==12){
         Sort(num);
        }
        else if(get==13){
          ImprovedBubbleSort(num);
        }
        else if(get==14){
          Mean(num);
        }
        else if(get==15){
         Median(num);
        }
        else if(get==16){
        getMode(num);
        }
        else if(get==17){
          System.out.println("Try again");
        }
        
      }while (get!=1);
    	}
   public static void InitializeArray(int[] num){
    for(int i=0; i<num.length; i++){
    num[i]=num[i]-1;
    System.out.println(num[i]);
    }
   }
   public static void EnterFromKeyboard(int[] num){
    Scanner input = new Scanner(System.in);
    
    for(int i=0; i<num.length; i++){
    
  System.out.println("Enter");
  num[i]=input.nextInt();
    }
    }
   public static void CountWhole(int[] num){
    
    for(int i=0; i<num.length; i++){
     if(num[i]>0 && (num[i]-Math.floor(num[i])==0)){
    System.out.println(num[i]);
    }
    }
   }
   public static void Display(int[] num){
    
    for(int i=0; i<num.length; i++){
    System.out.println(num[i]);
    }
    }
   public static void DisplayReverse(int[] num){
    
    for(int i=0; i<num.length/2; i++){
     int temp = num[i];
     num[i] = num[num.length-i-1];
     num[num.length-i-1]=temp;
    }
    
    for(int i=0; i<num.length; i++){
    System.out.println(num[i]);
    }
    }
   public static int Sum(int[] num){
	   int sum=0;
	   for(int i=0; i<num.length; i++){
		   sum=sum+num[i];
	   }
	   return sum;
   }
   
   public static void Average(int[] num){
	   int sum=0;
	   for(int i=0; i<num.length; i++){
		   sum=sum+num[i];
	   }
	   double avg=(sum/num.length);
   System.out.println("Average: "+ (Math.round(avg*10))/10);
    }
   
   public static int FindMax(int[] num){
   int max = num[0];
  for(int i=0; i<num.length; i++){
        if(max<num[i]){
         max=num[i];
        }
  } 
  return max;
   }
   
   public static int FindMin(int[] num){
   int min = num[0];
  for(int i=0; i<num.length; i++){
     if(min>num[i]){
     min=num[i];
        }
  } 
  return min;
   }
   
   public static void Search(int[] num){
   Scanner input = new Scanner(System.in);
   
   System.out.println("Search");
   int search= input.nextInt();
   
   int pos=0;
   
    for(int i=0; i<num.length; i++){
     if(num[i]==search){
      break;
     }
     pos++;
   }
    System.out.println(pos);
   }
   
   public static void Sort(int[]num){
    for(int i=0; i<num.length; i++){
    for(int j=1; j<num.length-i;j++){
     if(num[j]<num[j-1]){
     int temp = num[j];
     num[j] = num[j-1];
     num[j-1] = temp;
     }
     }
    }
    
    for(int i=0; i<num.length; i++){
    System.out.println(" Ascending order:" + num[i]);
    }
   }
   public static void ImprovedBubbleSort(int[]num){
    boolean swap;
    int j=1;
    int temp;
    
    do{
     swap = false;
     for(int i=0; i<num.length-j;i++){
      if(num[i]>num[i+1]){
       temp = num[i];
       num[i] = num[i+1];
     num[i+1] = temp;
       swap = true;
      }
    }
     j++;
    }while(swap==true);
    
    for(int i=0; i<num.length;i++){ 
    System.out.println(" Ascending order:" + num[i]);
    }
   }
   
   public static void Mean(int[] num){
   int avg = 0;
   for(int i =0;i <num.length;i++){
    avg = avg + num[i];
   }
   System.out.println(avg/num.length);
   }
   
   public static void Median(int[] num){
	    boolean swap;
	    int j=1;
	    int temp;
	    
	    do{
	     swap = false;
	     for(int i=0; i<num.length-j;i++){
	      if(num[i]>num[i+1]){
	       temp = num[i];
	       num[i] = num[i+1];
	     num[i+1] = temp;
	       swap = true;
	      }
	    }
	     j++;
	    }while(swap==true);
   
   int median =(num[4]+num[5])/2;
   
   System.out.println(" Median:"+median);
   }

   public static void getMode(int[] num){
    int[] count = new int[10];

   //count occurrences
   for(int i=0;i<num.length;i++){
    count[num[i]]++;
   }
   //go backwards & find count with most occurrences
   int index = count.length-1;
   for(int i=count.length-2; i>=0;i--){
     if(count[i]>=count[index]){
      index =i;
     }
    }
 
   
   System.out.println(" Mode:"+ index);
   }
}
