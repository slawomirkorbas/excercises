package regex

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/5/18
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
class MyRegexSpec extends Specification {

   @Unroll
   def 'IP address validation works as expected'() {
        given:
            MyRegex obj = new MyRegex()

        expect:
            valid == obj.vaidateIP( ip )

        where:
            ip                      | valid
            "000.12.12.034"         | true
            "121.234.12.12"         | true
            "23.45.12.56"           | true
            "00.12.123.123123.123"  | false
            "122.23"                | false
            "Hello.IP"              | false
            "259.259.259.259"       | false
            "266.266.266.266"       | false
            "255.255.255.255"       | true
            "555.555.555.555"       | false
            "666.666.666.666"       | false
            "249.249.249.249"       | true
            "249.249.249.256"       | false
   }

   @Unroll
   def "one followed by any number occuring 1 to 2 times"() {
       given:
           MyRegex obj = new MyRegex()
           def regex = "1\\d{1,2}"  // "1" followed by any number occuring 1 to 2 times  eg. 127

       expect:
           valid == obj.validate( num, regex )

       where:
           num    | valid
           "127"  | true
           "19"   | true
           "10"   | true
           "2"    | false
           "1673" | false
   }


    @Unroll
    def 'isNumberFrom0to255'() {
        given:
            MyRegex obj = new MyRegex()
            //def regex = "[2][0-5][0-5]|[2][0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9]"
            def regex = "(25[0-5])|(2[0-4]\\d)|([0-1]\\d{2})|(\\d{1,2})"

        expect:
            valid == obj.validate( num, regex )

        where:
            num    | valid
            "000"  | true
            "255"  | true
            "355"  | false
            "abc"  | false
            "1"    | true
            "100"  | true
            "0"    | true
            "249"  | true
    }

    def '0. to 255.'() {
        given:
            MyRegex obj = new MyRegex()
        def regex = "((25[0-5])|(2[0-4]\\d)|([0-1]\\d{2})|(\\d{1,2}))."

        expect:
            true == obj.validate( "249.", regex )
    }

    def '255.255.'() {
        given:
            MyRegex obj = new MyRegex()
            def regex = "(((25[0-5])|(2[0-4]\\d)|([0-1]\\d{2})|(\\d{1,2})).){2}"

        expect:
            true == obj.validate( "249.249.", regex )
    }
}


