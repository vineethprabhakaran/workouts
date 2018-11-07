package com.vineethds.arrays;

/*
    Author: Vineeth
    Input: ABCDABDEFGHICAC
    Output: ABDEFGHIC
    Order: O(n) where n is the length of the array
 */
public class LongestSubStringWithNonRepetitingCharacters {
/*
Algorithm Description:
- Create a temp array called charIndex of size 256 and initialize the array elements to -1
-if the charIndex[s.charAt(i)] == -1 && if the current character's previous Index is not within the current length
 increment the currnet length
 - else compare the current with maxlength and if the current length is greater than maxlength then update the maxlength and startIndex
 - Maxke Current Length = i - prevIndex
 */

public String findLongestSubString(String s){
    int[] charIndex = new int[256];
    for(int i =0;i< 256;i++){
        charIndex[i] = -1;
    }
    int maxLength = -1;
    int startIndex = -1;
    int currlen = -1;
    int preIndex = -1;

    for(int i = 0;i < s.length();i++){
        preIndex = charIndex[s.charAt(i)];
        if(preIndex == -1 || (i-currlen) > preIndex){
            currlen ++;
        }else{
            if(currlen > maxLength){
                maxLength = currlen;
                startIndex = i-currlen;
            }
            currlen = i - preIndex;
        }
        charIndex[s.charAt(i)] = i;
    }
    if(currlen > maxLength){
        maxLength = currlen;
        startIndex = s.length() - currlen;
    }

    return s.substring(startIndex,startIndex+maxLength);
}

public static void main(String a[]){
    LongestSubStringWithNonRepetitingCharacters l = new LongestSubStringWithNonRepetitingCharacters();
    String s = "ABCDABDEFGHICAC";
    String result = l.findLongestSubString(s);
    System.out.println(result);
}

}
