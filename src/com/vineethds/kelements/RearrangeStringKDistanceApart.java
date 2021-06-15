package com.vineethds.kelements;

import java.util.*;

/*
Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are
at least ‘K’ distance apart from each other.

Input: "mmpp", K=2
Output: "mpmp" or "pmpm"
Explanation: All same characters are 2 distance apart.

TC: O(NLogN)
SC: O(N)

 */
public class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());
        StringBuilder result = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.add(current);
            if(!queue.isEmpty() && queue.size() == k){
                Map.Entry<Character, Integer> prev = queue.poll();
                if(prev.getValue() > 0)
                    maxHeap.offer(prev);
            }

        }
        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
