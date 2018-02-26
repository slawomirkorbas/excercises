package lambda;

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/26/18
 * Time: 10:42 AM
 *
 * To change this template use File | Settings | File Templates.
 */

import java.util.stream.IntStream;

interface PerformOperation {
    boolean check(int a);
}

class PalindromesAndPrimes {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return num -> num%2 > 0;
    }

    public PerformOperation isPrime() {
        //return num -> num > 1 ? IntStream.range(2, num - 1).filter( n -> num%n == 0 ).count() == 0 : false;

        return num -> {
            boolean prime = num != 1;
            for( int i = 2; i < num; i++) {
                if( num%i == 0 ) {
                    prime = false;
                    break;
                }
            }
            return prime;
        };
    };

    PerformOperation isPalindrome() {
//        return (num) -> {
//            final int[] chars = String.valueOf(num).chars().toArray();
//            return IntStream.range(0, chars.length/2 - 1).filter( i -> chars[i] != chars[chars.length - i - 1] ).count() == 0;
//        };

        // another way...
        return (int a) ->  Integer.toString(a).equals( new StringBuilder(Integer.toString(a)).reverse().toString() );


    };
}