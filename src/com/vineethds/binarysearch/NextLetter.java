package com.vineethds.binarysearch;
/*
Given an array of lowercase letters sorted in ascending order,
find the smallest letter in the given array greater than a given ‘key’.

Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first
letter of the array.

Write a function to return the next letter of the given ‘key’.


Input: ['a', 'c', 'f', 'h'], key = 'f'
Output: 'h'
Explanation: The smallest letter greater than 'f' is 'h' in the given array.
 */
public class NextLetter {
    public static  char searchNextLetter(char[] letters, char key ){
        if( key  < letters[0] ||key >= letters[letters.length -1]){
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int mid  = start + (end - start)/2;
            if(key < letters[mid])
                end = mid -1;
            else
                start = mid +1;
        }
        return letters[start];
    }
    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
