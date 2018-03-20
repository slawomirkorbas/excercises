package largest.rectangle

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/16/18
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
class LargestRectangleCalcSpec extends Specification {

    def 'calculate: works as expected'() {

        given:
            int[] blocks = [ 8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116 ]

        expect:
            10 == LargestRectangleCalc.calculate(blocks)


    }
}
