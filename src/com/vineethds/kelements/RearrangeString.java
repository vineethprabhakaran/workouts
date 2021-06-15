package com.vineethds.kelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

Input: "aappp"
Output: "papap"
Explanation: In "papap", none of the repeating characters come next to each other.

TC: O(NLogN)
SC: O(N)
 */
class RearrangeString {

    public static String rearrangeString(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            result.append(curr.getKey());
            if(prev != null && prev.getValue() > 0){
                maxHeap.offer(prev);
            }
            curr.setValue(curr.getValue() - 1);
            prev = curr;
        }


        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}