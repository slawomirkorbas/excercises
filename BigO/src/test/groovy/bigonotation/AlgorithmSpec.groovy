package bigonotation

import spock.lang.Specification

import java.util.stream.IntStream
import java.util.stream.LongStream

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/22/18
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
class AlgorithmSpec extends Specification {


    def 'bubbleSort: works as expected'() {
        given:
            Algorithm alg  = new Algorithm()
        and:
            int size = 10000;
            int[] array = new int[size];
            for( int i = array.length-1; i >= 0; i-- ) {
                array[i] = array.length - i;
            }
            //IntStream.range(0,size).map( {i -> size - i} ).each( {n -> array[n] = n} );

        when:
            array = alg.bubbleSort(array)
        then:
            array[0] == 1;
            array[9999] == 10000;
    }


    def 'quickSort: works as expected'() {
        given:
            Algorithm alg = new Algorithm()
        and:
            int[] array = [ 4,2,3,3,3,5 ]

        when:
            array = alg.quickSort( array )
        then:
            array[0] == 2
            array[array.length - 1] == 5
        and:
            System.out.println( array )
    }

}
