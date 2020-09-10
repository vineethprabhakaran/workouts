package com.vineethds.others;

import java.util.Scanner;
/*
Some valid IP address:
000.12.12.034
121.234.12.12
23.45.12.56

Some invalid IP address:
000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
In this problem you will be provided strings containing any combination of ASCII characters.
You have to write a regular expression to find the valid IPs.

Just write the MyRegex class which contains a String . The string should contain the correct
regular expression.

(MyRegex class MUST NOT be public)

Sample Input
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
Sample Output
true
true
true
false
false
false
 */

public class IpValidInvalid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex
{
    String pattern =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

}