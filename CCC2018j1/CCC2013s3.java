import java.util.Arrays;
import java.util.Scanner;

public class CCC2012S3 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);

        int length = kb.nextInt(); //length
        int[] readings = new int[1000]; //array to read
        int temp; //temp variable

        for (int i = 0; i < length; i++) {
            temp = kb.nextInt();
            readings[temp-1]++;
        }

        int[] first = {0,0}; // {reading, num of repetitions}
        int[] max = {0,0};
        int[] min = {0,0};

        for (int i = 0; i < 1000; i++) {
            if (readings[i] >= first[1]) {
                first[0] = i;
                first[1] = readings[i];
            }
        }

        readings[first[0]] = 0;
        for (int i = 999; i > -1; i--) {
            if (readings[i] >= min[1]) {
                min[0] = i;
                min[1] = readings[i];
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (readings[i] >= max[1]) {
                max[0] = i;
                max[1] = readings[i];
            }
        }

        System.out.println(Math.max(Math.abs(first[0] - max[0]), Math.abs(first[0] - min[0])));
    }
}