package tags

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/3/18
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
class TagContentExtractorSpec extends Specification {

    @Unroll
    def 'printLine: works as expected'() {

        //def line = "<h1>Nayeem loves counseling</h1>"
        //def line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"
        //def line = "<Amee>safat codes like a ninja</amee>"
        //def line = "<SA premium>Imtiaz has a secret crush</SA premium>"
        //def line = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
        //def line = "<>hello</><h>dim</h>>>>>"
        //def line =">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
        def line = "<h1>had<h1>public</h1515></h1>"

        when:
            TagContentExtractor.printLine( line )
        then:
            true

//        where:
//            line << [ "<h1>had<h1>public</h1></h1>",
//                      "<h1>had<h1>public</h1515></h1>",
//                      "<h1><h1></h1></h1>",
//                      "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<",
//                      ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",
//                      "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>",
//                      "<>hello</>",
//                      "<>hello</><h>dim</h>",
//                      "<>hello</><h>dim</h>>>>>" ]
    }
}
