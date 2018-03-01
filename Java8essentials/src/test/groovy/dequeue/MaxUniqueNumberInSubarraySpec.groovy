package dequeue

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/1/18
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
class MaxUniqueNumberInSubarraySpec extends Specification{

    @Unroll
    def 'findMaxUniqueCount: works as expected'() {
        given:
            List inputList = [ 2,2,3,5,6,6,8,9,4,3,3,2 ]

        expect:
            maxUnique == MaxUniqueNumberInSubarray.findMaxUniqueCount( windowSize, inputList )

        where:
            windowSize | maxUnique
            4          | 4
            6          | 4

    }

}
