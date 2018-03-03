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
    def 'getUniqueCount: works as expected'() {
        given:
            LinkedList<Integer> frame = [1,2,2,2,3,4,5,6,7,7,7,1];

        expect:
            4 == MaxUniqueNumberInSubarray.getUniqueCount( frame )
    }

}
