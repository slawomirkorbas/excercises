package regex

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/5/18
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
class DuplicateWordsSpec extends Specification {

    @Unroll
    def 'removeDuplicates: works as expected'() {

        expect:
            result.equals( DuplicateWords.removeDuplicates(input) )

        where:
            input                                             | result
  //           "Goodbye bye bye world world world"               | "Goodbye bye world"
  //           "Sam went went to to to his business"             | "Sam went to his business"
  //           "Reya is is the the best player in eye eye game"  | "Reya is the best player in eye game"
  //           "in inthe"                                        | "in inthe"
  //          "Hello hello Ab aB"                               | "Hello Ab"
  //           "tap taptap For fOr for forfor"                           | "tap taptap For forfor"
             "taptap of kirethe the hte hTe hte"                       | "taptap of kirethe the hte"
  //           "tim tamtim tam tam ta tam tam"                           | "tim tamtim tam ta tam"
  //           "a a a a a a a a a a a a a a a a"                         | "a"
  //           "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" | "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    }

}
