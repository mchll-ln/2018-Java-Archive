import java.util.*;
public class Rec {
	
public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	int n;
	
	System.out.println("Enter n # of discs");
	n = input.nextInt();
	
	System.out.println(moves(n));
	//
	System.out.println("Enter n");
	int a = input.nextInt();
	
	for(int i =1; i<=a;i++){
	System.out.println(i +": " + Fibonum(i));
	//
	int c = 0;
	
	do{
	System.out.println("Enter a non-negative integer");
	c = input.nextInt();
	}while(c<0);
	
	int tot = addDigits(c,0);
			
	System.out.println("sum: " + tot);
	//
	System.out.println("Enter length of array");
	int max = input.nextInt();
	
	int[] num = new int[max];
	
	for(int z=0;z<num.length;z++){
	System.out.println("Enter #");
	num[z] = input.nextInt();
	}
	
	int total = sum(num, num.length-1);
	
	System.out.println("Total: " + total);
}
}

public static int moves(int d){
if(d==1){
	return 1;
}
else{
	return 2*moves(d-1)+1;
}
}

public static int Fibonum(int n){

	if(n <= 1){ //1,1 = defined
	return n;
	}
	else{
	return Fibonum(n-1) + Fibonum(n-2);
	}
}
//Non-negative int n, and returns the sum of its digits recursively (no loops). 
//Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
//while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

public static int addDigits(int b, int tot){
			if (b== 0)  {
			        return tot;
			    } else {
			        tot = tot + b % 10;  //recursive variable to keep the digits sum
			        b= b/10;
			        return addDigits(b, tot); //returning sum to print it.
			    }
			}
public static int sum(int[] num,int m){

			if(m==0){
				System.out.println(num[m]);
				return num[m];
			}
			else{
				System.out.println(num[m]);
				return num[m] + sum(num, m-1);
			}
			} 
	}
