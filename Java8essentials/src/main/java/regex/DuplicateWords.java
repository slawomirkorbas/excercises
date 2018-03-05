package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 https://www.hackerrank.com/challenges/duplicate-word/problem
 In this challenge, we use regular expressions (RegEx) to remove instances of words that
 are repeated more than once, but retain the first occurrence of any case-insensitive repeated word.
 For example, the words love and to are repeated in the sentence I love Love to To tO code. Can you complete the
 code in the editor so it will turn "I love Love to To tO code" into "I love to code"?
 */
public class DuplicateWords {

    public static String removeDuplicates( String input ) {

        String regex = "\\b(\\w+)(\\s+\\1)"; /* Write a RegEx matching repeated words here. */
        // "w" is a word chsrceter - short of: A word character, short for [a-zA-Z_0-9]
        // "w+" stands for word character occuring one or more times
        // "s+" stands for one or more whitespaces
        // \\1 refers to the first group found (\\w+)  <- "back reference"
        // \\b is word bonduary so it ensures that matching word is not part of other string
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE );

        // Check for subsequences of input that match the compiled pattern
        Matcher m = p.matcher(input);
        while (m.find()) {
            input = input.replaceAll( "(?i)(\\b\\w+)(\\s+)(\\1\\b)", "$1" ); // The regex to replace ,  The replacement.
            // (?i) - case insensitivity switch
        }

        return  input;
    }
}
