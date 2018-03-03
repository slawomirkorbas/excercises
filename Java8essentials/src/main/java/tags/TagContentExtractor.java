package tags;

import java.util.Stack;

/**
 https://www.hackerrank.com/challenges/tag-content-extractor/problem
 * To change this template use File | Settings | File Templates.
 */
public class TagContentExtractor {

    public static void printLine(String line) {
        String content = "";
        boolean validContentFound = false;
        Stack<String> tagStack = new Stack<>();
        for( int i = 0; i < line.length(); i++ ) {
            if( line.charAt(i) == '<') {
                String tag = "";
                while( i < line.length() - 1 && line.charAt(++i) != '>' ) {
                    tag +=  line.charAt(i);
                };

                // enclosing tag found ...so print its content
                if( tag.length() > 1 && tag.charAt(0) == '/' ) {
                    if( tag.equals( "/" + tagStack.peek()) && !content.isEmpty() ) {
                        System.out.println(content);
                        validContentFound = true;
                    }
                }
                else {
                    tagStack.add(tag);
                }
                content = "";
            }
            else {
                content += line.charAt(i);
            }
        }

        if( !validContentFound ) {
            System.out.println("None");
        }
    }
}
