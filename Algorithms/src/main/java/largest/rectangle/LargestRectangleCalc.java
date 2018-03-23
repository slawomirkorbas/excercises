package largest.rectangle;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangleCalc {

    static long calculate(int[] h) {
        // Complete this function
         long n = h.length;
         return ((n+1)/2) * (n - ((n+1)/2) + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }

        long result = calculate(h);
        System.out.println(result);
        in.close();
    }


}
