package cycle.detection;

/**
 * Developers Greenfield
 *
 * Created with IntelliJ IDEA.
 * User: slawomir
 * Detects a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 */
public class CycleDetector {

    /**
     * Checks if a list of nodes contains cycle.
     * Uses no storage and iterates over list with two heads at different "speeds". If there is a cycle these heads will meet
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while( slow != null && fast != null ) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    /* using storage... - not recommended */
    /*    if( head != null ) {
            Set<Node> visited = new HashSet<Node>();
            while( head.next != null ) {
               if( visited.contains(head.next) ) {
                   return true;
               }
               visited.add( head.next );
               head = head.next;
            }
        }
        return false; */
    }
}
