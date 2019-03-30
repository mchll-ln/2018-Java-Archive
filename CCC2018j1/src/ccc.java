import java.util.*;

public class ccc 
{
static Scanner myScanner = new Scanner(System.in);
 public static void main(String[] args) {
  
  int[] num = new int[4]; 
  
  for(int i = 0; i<num.length; i++)
  {
   num[i] = myScanner.nextInt();
  }

if(num[0]==8||num[0]==9||num[3]==8||num[3]==9||num[1]==num[2])
{
 System.out.println("ignore");
}
else
{
System.out.println("answer");
}
 }

}
