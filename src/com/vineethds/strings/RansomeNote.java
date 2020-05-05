package com.vineethds.strings;

/*
 Given an arbitrary ransom note string and another string containing letters from all the magazines,
 write a function that will return true if the ransom note can be constructed from the magazines ;
 otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.
 */
public class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null) { return true; }
        if (magazine == null) { return false; }
        if (magazine.length() < ransomNote.length()) { return false; }
        int[] count = new int[26];
        for (char c: magazine.toCharArray()) {
            count[c - 'a'] += 1;
        }
        for (char c: ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) { return false; }
            count[c - 'a'] -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomeNote rn = new RansomeNote();
        boolean result = rn.canConstruct("fffbfg","effjfggbffjdgbjjhhdegh");
        System.out.println(result);
    }
}

