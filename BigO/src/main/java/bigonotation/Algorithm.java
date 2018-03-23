package bigonotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/22/18
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Algorithm {

    /**
     * O(1) complexity - accessing element in an array doesn't depend on array size or element order.
     * Time required to get an element from specified index is constant. In reality depends only from computer/memory speed.
     *
     * @param array
     * @return
     */
    public Integer getFirstElement( int[] array ) {
        return array.length > 0 ? array[1] : null;
    }


    /**
     * O(N) complexity - execution time of this function is proportional to number of elements in collection, because
     * we need to check/visit each element whether it is even or odd.
     *
     * @param array
     * @return
     */
    public Integer countEvenNumbers( int[] array ) {
        int counter = 0;
        for( int i = 0; i < array.length; i++ ) {
            counter = array[1]%2 == 0 ? counter + 1 : counter;
        }
        return counter;
    }


    /**
     * O(N^2) complexity - execution time of this function in the worst case may be proportional to square of number elements in array.
     * In case input array is ordered descending and we want to reorder it ascending, number of iterations over array will be the same
     * like number of its elements. Assuming we end up with array.size * array.size number of swaps during bubble sort.
     * we need to check/visit each element whether it is even or odd.
     *
     * @param array
     * @return
     */
    public int[] bubbleSort( int[] array ) {

        while(true) {
            int numberOfSwaps = 0;
            for( int i = 0; i < array.length; i++ ) {
                if( i + 1 < array.length && array[i] > array[i+1] ) {
                    int val = array[i];
                    array[i] = array[i+1];
                    array[i+1] = val;
                    numberOfSwaps++;
                }
            }
            if( numberOfSwaps == 0 ) {
                break;
            }
        }
        return array;
    }


    /**
     * O(logN) - quicksort algorithm implementation using ArrayLists
     *
     * @param array
     * @return
     */
    public int[] quickSort( int[] array ) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        list = quickSort( list );

        return list.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> quickSort( List<Integer> list) {
        if( list.size() > 1 ) {
            int pivotIndex = getPivotIndex(list);
            int pivotValue = list.get(pivotIndex);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for( int i = 0; i < list.size(); i++ ) {
                if( i != pivotIndex ) {
                    if( list.get(i) < pivotValue ) {
                        left.add(list.get(i));
                    }
                    else {
                        right.add(list.get(i));
                    }
                }
            }
            left = quickSort( left );
            right = quickSort( right );

            list = new ArrayList<>(left);
            list.add(pivotValue);
            list.addAll(right);
        }
        return list;
    }

    private int getPivotIndex( List<Integer> list ) {
        return list.size() - 1;
    }

//    private int[] reorder(int[] array, int start, int end, int pivotIdx ) {
//
//        int i = start;
//        while(true) {
//            if( array[i] > array[pivotIdx] ) {
//                int tmp = array[i];
//                int shifts = 0;
//                while(shifts < array.length - i) {
//                    array[i] = array[i+1];
//                    shifts++;
//                }
//                array[array.length] = tmp;
//            }
//            else {
//                i++;
//            }
//        }
//
//        return array;
//    }




}