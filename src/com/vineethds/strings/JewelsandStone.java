package com.vineethds.strings;
/*
Problem Statement:
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters.
Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsandStone {
    public static int numJewelsInStones(String J, String S){
        int JewelCount = 0;
        char[] charArray = S.toCharArray();
        for(char ch : charArray){
            if(J.contains(ch+"")) JewelCount++;
        }
        return JewelCount;
    }
    public static void main(String[] args) {
        int totalJewelCount  = JewelsandStone.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(totalJewelCount);
    }
}
