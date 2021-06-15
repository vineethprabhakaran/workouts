package com.vineethds.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.

Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"

TC: O(N*2^N)
SC: O(N*2^N)

 */
public class LetterCaseStringPermutation {

    public static  List<String> findLetterCaseStringPermutations(String str){
        List<String> result = new ArrayList<>();
        result.add(str);
        for(int i = 0 ; i < str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                int n  = result.size();
                for(int j = 0; j < n; j++){
                    char[] ch = result.get(j).toCharArray();
                    if(Character.isUpperCase(ch[i])){
                        ch[i] = Character.toLowerCase(ch[i]);
                    }else{
                        ch[i] = Character.toUpperCase(ch[i]);
                    }
                    result.add(String.valueOf(ch));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
