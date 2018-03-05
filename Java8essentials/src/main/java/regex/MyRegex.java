package regex;

import java.util.Scanner;

/**
 https://www.hackerrank.com/challenges/java-regex/problem
 IP address validation with regex
 IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
 Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

 */
public class MyRegex {

    // first correct pattern
    //public String pattern = "(([2][0-5][0-5]|[2][0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])([\\.])){3}([2][0-5][0-5]|[2][0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])";
    public String pattern = "(((25[0-5])|(2[0-4]\\d)|([0-1]\\d{2})|(\\d{1,2})).){3}((25[0-5])|(2[0-4]\\d)|([0-1]\\d{2})|(\\d{1,2}))";


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }


    public boolean vaidateIP(String ipAddress) {
        return ipAddress.matches(pattern);
    }


    public boolean validate(String num, String regex) {
        return num.matches(regex);
    }

}
