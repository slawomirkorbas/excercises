package sorting.student

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: skor
 * Date: 3/1/18
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
class StudentSorterSpec extends Specification{

    def 'sortWithComparator: works as expected'() {
        given:
            def list = [
                   new Student( 33,"Rumpa",  3.68 ),
                   new Student( 85,"Ashis",  3.85 ),
                   new Student( 56,"Samiha", 3.75 ),
                   new Student( 19,"Samara", 3.75 ),
                   new Student( 22,"Fahim",  3.76  )
            ]

        when:
            StudentSorter.sortWithComparator( list );
        then:
            list[0].getFname().equals("Ashis");
            list[1].getFname().equals("Fahim");
            list[2].getFname().equals("Samara");
            list[3].getFname().equals("Samiha");
            list[4].getFname().equals("Rumpa");

    }
}
