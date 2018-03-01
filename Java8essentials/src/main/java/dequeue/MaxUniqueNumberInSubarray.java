package dequeue;

import java.util.*;

/**
 * problem description: https://www.hackerrank.com/challenges/java-dequeue/problem
 */
public class MaxUniqueNumberInSubarray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputList.add(in.nextInt());
        }

        System.out.println( findMaxUniqueCount( m, inputList ) );
    }

    public static Integer findMaxUniqueCount( int m, List<Integer> inputList ) {
        int idx = 0;
        int maxUnique = 0;
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = 0; i < inputList.size(); i++) {
            if( idx < m ) {
                Integer num = inputList.get(i);
                if( !uniqueSet.contains(num) ) {
                    uniqueSet.add(inputList.get(i));
                }
                else {
                    uniqueSet.remove(num);
                }
                idx++;
            }
            if( idx == m ) {
                idx = 0;
                maxUnique = maxUnique < uniqueSet.size() ? uniqueSet.size() : maxUnique;
                uniqueSet.clear();
                i = i - m + 2;
            }
        }
        return maxUnique;
    }
}
