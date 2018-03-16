package huffman;

/**
 https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 */
public class HuffmanDecoder {

    private class Node {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
    }


    void decode(String S ,Node root) {
        System.out.println( traverseTree( S, 0, root, root, "" ) );
    }

    String traverseTree( String encodedStr, int currentIndex, Node root, Node node, String decodedString ) {
        if( currentIndex < encodedStr.length() ) {
            if( encodedStr.charAt(currentIndex) ==  '1' ) {
                decodedString += isLeaf( node.right ) ? node.right.data : "";
                node = isLeaf( node.right ) ? root : node.right;
            }
            else {
                decodedString += isLeaf( node.left ) ? node.left.data : "";
                node = isLeaf( node.left ) ? root : node.left;
            }
            decodedString = traverseTree( encodedStr, currentIndex + 1, root, node, decodedString);
        }
        return decodedString;
    }

    boolean isLeaf( Node node ) {
        return (node.left == null && node.right == null);
    }
}
