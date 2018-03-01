package dequeue;

import java.util.*;

/**
 * problem description: https://www.hackerrank.com/challenges/java-dequeue/problem
 */
public class MaxUniqueNumberInSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        LinkedList<Integer> frame = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            frame.add(in.nextInt());
            if( frame.size() == m ) {
                int unique = getUniqueCount( frame );
                maxUnique = unique > maxUnique ? unique : maxUnique;
                frame.removeFirst();
            }
        }
        System.out.println( maxUnique );
    }

    public static Integer getUniqueCount( LinkedList<Integer> frame ) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
        frame.forEach( num -> {
            if( unique.contains(num) ) {
                duplicates.add(num);
            }
            unique.add(num);
        });
        duplicates.forEach( d -> unique.remove(d) );
        return unique.size();
    }
}
