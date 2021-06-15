package com.vineethds.others;

import java.util.HashSet;

public class CombinationString {

    public static HashSet getCombinationStrings(String str){
        HashSet<String> set = new HashSet<>();
        if (str == null || str.equals("")){
            set.add("");
            return set;
        }
        char first = str.charAt(0);
        HashSet<String> words = getCombinationStrings(str.substring(1));
        for(String word : words){
            for(int i = 0; i<= word.length(); i++){
                String mid = word.substring(0, i);
                String last = word.substring(i);
                set.add(mid + first + last);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        //"xyz" has 6 possible permutations, xyz, xzy, yxz, yzx, zxy, zyx
        String s = "abc";
        HashSet<String> result = getCombinationStrings(s);
        for(String str : result){
            System.out.println(str);
        }

    }

}
