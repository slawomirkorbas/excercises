package anagrams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 https://www.hackerrank.com/challenges/java-anagrams/problem
 Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies.
 For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
 */
public class AnagramVerifier {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean anagram = a.length() == b.length();
        if( anagram ) {
            int[] ar1 = a.toLowerCase().chars().sorted().toArray();
            int[] ar2 = b.toLowerCase().chars().sorted().toArray();
            for( int i = 0; i < ar1.length; i++ ) {
                if( ar1[i] != ar2[i] ) {
                    anagram = false;
                    break;
                }
            }
        }
        return anagram;


        //return a.toLowerCase().chars().sorted().equals(b.toLowerCase().chars().sorted());

    }

}
