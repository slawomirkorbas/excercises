package sorting;

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/25/18
 * Time: 7:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sorter {

    public void quickSort( int[] array ) {
        quickSort( array, 0, array.length - 1 );
    }

    private void quickSort( int[] array, int left, int right ) {
        if( left >= right ) {
            return;
        }
        int pivot = array[left + (right - left)/2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right );
    }

    private int partition( int[] array, int left, int right, int pivot ) {
        while( left <= right ) {
            while( array[left] < pivot ) {
                left++;
            }
            while( array[right] > pivot ) {
                right--;
            }
            if( left <= right ) {
                swap( array, left, right );
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap ( int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
