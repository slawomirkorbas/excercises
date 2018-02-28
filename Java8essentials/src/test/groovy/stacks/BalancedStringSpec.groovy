package stacks

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 2/28/18
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
class BalancedStringSpec extends Specification {

    @Unroll
    def 'isBalancedRecursive: works properly'() {
        expect:
            balanced == BalancedString.isBalanced(input)

        where:
            balanced  | input
            true      | "{}()"
            true      | "({()})"
            false     | "{}("
            true      | "[]"
            true      | "{}{(())[]}"
            true      | "[[[[[[]]]]]]"
            false     | "[](({)})"
    }




}
