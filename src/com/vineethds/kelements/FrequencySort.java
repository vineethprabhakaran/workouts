package com.vineethds.kelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
Given a string, sort it based on the decreasing frequency of its characters.

Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.

TC: O(NLogN)
SC: O(N)
 */
public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            maxHeap.offer(entry);
        }
        String result = "";
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            Character ch = entry.getKey();
            int n = entry.getValue();
            for(int i = 0 ; i < n;i++){
                result += ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
