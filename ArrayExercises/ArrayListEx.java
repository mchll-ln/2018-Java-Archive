import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListEx {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<Integer>(10);

		EnterFromKeyboard(num);

		int get;
		do {
			System.out.println("Input:");
			System.out.println("1: exit");
			System.out.println("2: assign -1 to every element");
			System.out.println("4: display all whole #s entered");
			System.out.println("5: Print array in the order entered");
			System.out.println("6: Display the list in reverse order");
			System.out.println("7: Sum");
			System.out.println("8: Average");
			System.out.println("91: Max number");
			System.out.println("92: Min number");
			System.out.println("10: Search for the position of the number");
			System.out
					.println("12: sort the numbers in ascending order using the bubble sort method");
			System.out
					.println("13: sort the numbers in ascending order using the improved bubble sort method");
			System.out
					.println("14: switch the order of values in a pairwise fashion");
			System.out.println("15: remove duplicate integers ");
			get = input.nextInt();

			if (get == 1) {
				break;
			} else if (get == 2) {
				InitializeArray(num);
			} else if (get == 4) {
				CountWhole(num);
			} else if (get == 5) {
				Display(num);
			} else if (get == 6) {
				DisplayReverse(num);
			} else if (get == 7) {
				System.out.println("the sum is " + Sum(num));
			} else if (get == 8) {
				Average(num);
			} else if (get == 91) {
				System.out.println("the maximum number is " + FindMax(num));
			} else if (get == 92) {
				System.out.println("the minimum number is " + FindMin(num));
			} else if (get == 10) {
				Search(num);
			} else if (get == 12) {
				Sort(num);
			} else if (get == 13) {
				ImprovedBubbleSort(num);
			} else if (get == 14) {
				switchPairs(num);
			} else if (get == 15) {
				removeMultiples(num);
			} else {
				System.out.println("Try again");
			}
		} while (get != 1);
	}

	public static void InitializeArray(ArrayList<Integer> num) {
		for (int i = 0; i < num.size(); i++) {
			num.set(i, num.get(i) - 1);
		}
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static void EnterFromKeyboard(ArrayList<Integer> num) {
		Scanner input = new Scanner(System.in);
		int n, in;

		do {
			System.out.println("How many integers will you enter? Max. 10");
			n = input.nextInt();
		} while (n < 1 || n > 10);

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1));
			in = input.nextInt();
			num.add(in);
		}
	}

	public static void CountWhole(ArrayList<Integer> num) {

		for (int i = 0; i < num.size(); i++) {
			if (num.get(i) > 0 && (num.get(i) - Math.floor(num.get(i)) == 0)) {
				System.out.println(num.get(i));
			}
		}
	}

	public static void Display(ArrayList<Integer> num) {

		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static void DisplayReverse(ArrayList<Integer> num) {

		for (int i = 0; i < num.size() / 2; i++) {
			int temp = num.get(i);
			num.set(i, num.get(num.size() - i - 1));
			num.set((num.size() - i - 1), temp);
		}

		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static int Sum(ArrayList<Integer> num) {
		int sum = 0;
		for (int i = 0; i < num.size(); i++) {
			sum = sum + num.get(i);
		}
		return (sum);
	}

	public static void Average(ArrayList<Integer> num) {
		int sum = 0;
		double avg;

		for (int i = 0; i < num.size(); i++) {
			sum = sum + num.get(i);
		}
		avg = (sum / num.size());

		System.out.println("Average: " + ((Math.round(avg * 10)) / 10));
	}

	public static int FindMax(ArrayList<Integer> num) {
		int max = num.get(0);
		for (int i = 0; i < num.size(); i++) {
			if (max < num.get(i)) {
				max = num.get(i);
			}
		}
		return (max);
	}

	public static int FindMin(ArrayList<Integer> num) {
		int min = num.get(0);
		for (int i = 0; i < num.size(); i++) {
			if (min > num.get(i)) {
				min = num.get(i);
			}
		}
		return (min);
	}

	public static void Search(ArrayList<Integer> num) {
		Scanner input = new Scanner(System.in);

		System.out.println("Search for:");
		int look = input.nextInt();
		int pos = 0;

		for (int i = 0; i < num.size(); i++) {
			if (num.get(i) == look) {
				System.out.println(i);
				pos++;
			}
		}
		if (pos == 0) {
			System.out.println("No results");
		}
	}

	public static void Sort(ArrayList<Integer> num) {
		for (int i = 0; i < num.size(); i++) {
			for (int j = 0; j < (num.size() - 1) - i; j++)
				if (num.get(j) > num.get(j + 1)) {
					int temp = num.get(j);
					num.set(j, num.get(j + 1));
					num.set(j + 1, temp);
				}
		}
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static void ImprovedBubbleSort(ArrayList<Integer> num) {
		boolean swap;
		int j = 1;
		int temp;

		do {
			swap = false;
			for (int i = 0; i < num.size() - j; i++) {
				if (num.get(i) > num.get(i + 1)) {
					temp = num.get(i);
					num.set(i, num.get(i + 1));
					num.set(i + 1, temp);
					swap = true;
				}
			}
			j++;
		} while (swap == true);

		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static void switchPairs(ArrayList<Integer> num) {
		int temp = 0;

		for (int i = 0; i < num.size() / 2 * 2; i += 2) {// for odd # elements
			temp = num.get(i);
			num.set(i, num.get(i + 1));
			num.set(i + 1, temp);
		}

		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

	public static void removeMultiples(ArrayList<Integer> num) {
		for (int i = 0; i < num.size(); i++) {
			for (int j = 0; j < (num.size() - 1) - i; j++)
				if (num.get(j) > num.get(j + 1)) {
					int temp = num.get(j);
					num.set(j, num.get(j + 1));
					num.set(j + 1, temp);
				}
		}

		for (int i = 0; i < num.size() - 1; i++) {
			if (num.get(i) == num.get(i + 1)) {
				num.remove(i);
				i--;
			}
		}
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
	}

}
