package com.vineethds.others;

import java.util.HashMap;

public class FindAnagrams {

    public static void checkIfAnagram(String str, String pattern){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char ch  = pattern.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int count = 0;
        int n  = pattern.length();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) -1);
                if(map.get(ch) == 0){
                    count++;
                }
            }
            if(i >= (n -1)){
                if(count == map.size()){
                    System.out.println(i - (n - 1));
                }
                char c = str.charAt(i - (n -1));
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                        count--;
                }
            }
        }



    }

    public static void main(String[] args) {
        String str = "acddcabadcdadac";
        String pattern = "addc";
        checkIfAnagram(str, pattern);
    }
}
