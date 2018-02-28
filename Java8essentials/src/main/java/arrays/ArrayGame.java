package arrays;

import java.util.Scanner;

/**
 https://www.hackerrank.com/challenges/java-1d-array/problem
 Let's play a game on an array! You're standing at index  of an -element array named .
 From some index (where ), you can perform one of the following moves:
 Move Backward: If cell i - 1  exists and contains a 0, you can walk back to cell i - 1.
 Move Forward:
 If cell  i + 1 contains a zero, you can walk to cell i + 1.
 If cell  i + LEAP contains a zero, you can jump to cell i + LEAP.
 If you're standing in cell  n -1 or the value of i + leap >= n, you can walk or jump off the end of the array and win the game.

 Given  LEAP and GAME, complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).
 */
public class ArrayGame {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return moveOut( 0, leap, game );
        //return isSolvable( leap, game, pos);
    }

//    private static boolean isSolvable(int m, int[] arr, int i) {
//        if (i < 0 || arr[i] == 1) return false;
//        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;
//
//        arr[i] = 1;
//        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
//    }

    public static boolean moveOut( int pos, int leap, int[] game ) {
        if( pos > game.length - 1 ) {
            return true; // game won !!!
        }
        if( (pos == game.length - 1) && (game[pos] == 0) ) {
            return true; // game won !!!
        }

        if( pos >= 0 && game[pos] == 0 ) {
            game[pos] = 1;
            if( moveOut( pos + 1, leap, game ) ||
                moveOut( pos - 1, leap, game ) ||
                moveOut( pos + leap, leap, game ) ) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}