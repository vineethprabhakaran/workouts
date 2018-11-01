package com.vineethds.strings;

import java.util.HashSet;

/*
    Author: Vineeth
    Input: abc
    Output: bca acb abc cba bac cab
    Order:O(n*n!)
 */
public class PermutationOfString {
/*
    Algorithm Description
    -Recursively split the string's first character one by one
    and recursively add the remaining the string on both sides of the character as
    s.substring(0,i)+first+s.substring(i)
 */
    private static void printResults(HashSet<String> resultSet) {
        for (String word : resultSet){
            System.out.print(word+" ");
        }
    }
    private static HashSet<String> getPermutationofString(String s) {

        HashSet<String> perm = new HashSet<String>();
        if(s == null || s.equals("")){
            perm.add("");
            return perm;
        }
        char first = s.charAt(0);
        HashSet<String> words = getPermutationofString(s.substring(1));
        for(String word : words){
            for(int i = 0; i<= word.length();i++){
                String prev = word.substring(0,i);
                String last = word.substring(i);
                perm.add(prev+first+last);
            }
        }
        return perm;
    }


    public static void main (String arg[]){
        String s = "abc";
        HashSet<String> resultSet = getPermutationofString(s);
        printResults(resultSet);

    }

}
