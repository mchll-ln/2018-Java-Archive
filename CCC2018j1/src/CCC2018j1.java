  import java.util.*;
  
public class CCC2018j2 {

 public static void main(String[] args) {
 
   Scanner myScanner = new Scanner(System.in);
   
  int size = myScanner.nextInt();
  
  String day1[] = new String[size];
  String today[] = new String[size];
    
  for(int i = 0; i<size; i++)
  {
   day1[i]= myScanner.nextLine();
  }
  
  for(int i = 0; i<size; i++)
  {
   today[i]= myScanner.nextLine();
  }
  
   int num = 0;  
    for(int i=0; i<size; i++)
   {
   if(today[i].equals("c")&& day1[i].equals("c"))
   {
    num++;
   }
   }
   System.out.println(num);
 }
     }
