package bigonotation;

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



}
