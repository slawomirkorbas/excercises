package lambda

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 2/26/18
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
class PerformOperationSpec extends Specification {


    @Unroll
    def 'isOdd: works as expected'() {
        given:
            PalindromesAndPrimes ob = new PalindromesAndPrimes();
            PerformOperation op = ob.isOdd();

        expect:
            isOdd == ob.checker(op, number);

        where:
            number | isOdd
            1      | true
            13     | true
            24     | false
            131    | true

    }

    @Unroll
    def 'isPrime: works as expected'() {
        given:
            PalindromesAndPrimes ob = new PalindromesAndPrimes();
            PerformOperation op = ob.isPrime();

        expect:
            isPrime == ob.checker(op, number);

        where:
            number    | isPrime
            1      | false
            5      | true
            9      | false
            124    | false

    }

    @Unroll
    def 'isPalindrome: works as expected'() {
        given:
            PalindromesAndPrimes ob = new PalindromesAndPrimes();
            PerformOperation op = ob.isPalindrome();

        expect:
            isPalindrome == ob.checker(op, number);

        where:
            number | isPalindrome
            1      | true
            22122  | true
            12345  | false
            7777   | true
    }
}
