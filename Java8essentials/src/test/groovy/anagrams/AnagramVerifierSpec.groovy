package anagrams

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/2/18
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
class AnagramVerifierSpec extends Specification {

    @Unroll
    def 'isAnagram: works as expected'() {
          expect:
            expected == AnagramVerifier.isAnagram( a, b )

          where:
            a          | b          | expected
            "Hello"    | "hello"    | true
            "anagramm" | "marganaa" | false
    }
}
