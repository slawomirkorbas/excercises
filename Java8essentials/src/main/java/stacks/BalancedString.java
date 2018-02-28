package stacks;

import java.util.*;
import java.util.stream.IntStream;

/**
 A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
 Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 Given a string, determine if it is balanced or not.

 Input Format
 There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

 The part of the code that handles input operation is already provided in the editor.

 Output Format:  For each case, print 'true' if the string is balanced, 'false' otherwise.

 Sample Input

 {}()
 ({()})
 {}(
 []
 Sample Output

 true
 true
 false
 true

 */
class BalancedString {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //Complete the code
            System.out.println( isBalanced( sc.next()) );
        }

    }

    public static boolean isBalanced( String input ) {
        Stack<Character> stack = new Stack<>();
        Character nextTag, closeTag;
        for( int i = 0; i < input.length(); i++ ) {
            closeTag = getEnclosingForLastFormStack( stack );
            nextTag  = Character.valueOf(input.charAt(i));
            if( nextTag.equals(closeTag)) {
                stack.pop();
            }
            else {
                stack.push(nextTag);
            }
        }
        return stack.isEmpty();
    }

    public static Character getEnclosingForLastFormStack( Stack<Character> stack ) {
        if( !stack.isEmpty() ) {
            Character tag = stack.peek();
            return ( tag == '{' ? '}' : tag == '[' ? ']' : tag == '(' ? ')' : 'x' );
        }
        return null;
    }


}