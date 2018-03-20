package cycle.detection

import spock.lang.Specification

import java.util.stream.IntStream

/**
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Date: 3/19/18
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
class CycleDetectorSpec extends Specification {

    def 'Cycle detection detects no cycle if there is no cycle within linked list of nodes'() {

        given:
            CycleDetector detector = new CycleDetector()
        and:
            Node prev = null
            Node head = new Node()
            IntStream.range(1,100).each( { n ->
                Node node = new Node();
                if( prev == null ) {
                    head = node;
                }
                else {
                    prev.next =  node;
                }
                prev = node;
            });

        expect:
            false == detector.hasCycle(head)
    }


    def 'Cycle detection detects cycle if there is a cycle within linked list of nodes'() {

        given:
            CycleDetector detector = new CycleDetector()
        and:
            Node prev = null
            Node head = new Node()
            IntStream.range(1,100).each( { n ->
                Node node = new Node();
                if( prev == null ) {
                    head = node;
                }
                else {
                    prev.next =  node;
                }
                prev = node;
            });
            prev.next = head;     // Here we set a cycle to head node  !!!

        expect:
            true == detector.hasCycle(head)
    }
}
