package com.vineethds.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string and a list of words, find all the starting indices of substrings in the given string that are a
concatenation of all the given words exactly once without any overlapping of words.
It is given that all words are of the same length.

Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".
 */
public class WordConcatenation {

    public static List<Integer> findwordconcat(String str, String[] words){
        List<Integer> result = new ArrayList<>();
        int wordCount = words.length;
        int wordLength = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(String ws : words){
            map.put(ws,map.getOrDefault(ws,0)+1);
        }
        for(int i = 0; i<= str.length() -(wordCount * wordLength);i++){
            Map<String, Integer> wordSeen  = new HashMap<>();
            for(int j = 0; j < wordCount; j++){
                int nextWord = i + (j * wordLength);
                String word = str.substring(nextWord,nextWord + wordLength);
                if(!map.containsKey(word))
                    break;
                wordSeen.put(word,wordSeen.getOrDefault(word,0)+1);
                if(wordSeen.get(word) > map.get(word))
                    break;
                if(j + 1 == wordCount){
                    result.add(i);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "catfoxcat";
        String str1 = "catcatfoxfox";
        String[] word = {"cat", "fox"};
        System.out.println(findwordconcat(str,word));
        System.out.println(findwordconcat(str1,word));
    }
}
