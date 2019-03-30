import java.util.*;
public class BinaryAct {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] bin = {-1,2,3,4,5}; 

		System.out.println("Enter a number to search for");
		int n = input.nextInt();
		
		System.out.println("Found? " + RecBin(bin,n, 0, bin.length-1));
	}
	
	public static int RecBin(int[] bin, int target, int min, int max){
		int mid= (max+min)/2;

		if(min >=max){
			if(bin[min] != target){
				return -1;
			}
		}
		 if(bin[mid]==target){
			return mid;
		}
		else if(bin[mid]<target){
			min=mid+1;
			return RecBin(bin, target, min, max);
		}
		else {
			max = mid-1;
			return RecBin(bin, target, min, max);
		}
	}
}
/** OR
 * if(min==max){
 * if(array[mi].equals(target)){
 * return min;
 * }else{
 * return -1;
 * int mid = (min+max)/2;
 * int diff = array[mid].compareTo(target);
 * if(diff==0){
 * return mid;
 * }else if(diff>0){
 * return RecBin(array, target, min, mid-1);
 *}else{
 *returnRecBin(array,target,mid+1,max);
 *}
 *}		
 */

