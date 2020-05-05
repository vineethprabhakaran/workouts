package com.vineethds.strings;

import java.util.HashMap;

/*
    Author: Vineeth
    Input: leetcode
    Output: 0
    Time Complexity: O(n)
    Space Complexity: O(n)
    Efficient Solution
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int n = s.length();
        for(int i = 0 ; i < n; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i = 0 ; i < n; i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FirstUniqueCharacter fc = new FirstUniqueCharacter();
        int result = fc.firstUniqChar("leetcode");
        System.out.println(result);
    }
}
