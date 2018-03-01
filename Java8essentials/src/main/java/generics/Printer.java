package generics;

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/1/18
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Printer {

    /**
     * Method can accept any array like String[], Integer[] and
     * print out all its elements
     * @param array
     * @param <T>
     */
    public static <T> void printArray( T[] array ) {
        for (T o : array) {
            System.out.println( o );
        }
    }
}
