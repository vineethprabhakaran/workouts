package com.vineethds.strings;

/*
@Author: Vineeth
@input: vineeth
output: v-i-n-e-e-t-h
v-i-n-ee-t-h
Order: O(n^2)
 */
public class PalindromicPartitions {
/*
Algorithm insights:
- Check each character one by one and from the starting character to the last character check if each word is a palindrome
by addling next characters to the starting character till the last character though a loop
- if the selected word is a palindrome then append the palidromic word to the ouput and continue from the next character
 */

    private void printPalidromePartitions(String str, String output, int begin, int end) {
        if(begin == end){
            System.out.println(output);
            return;
        }
        String delimiter = "-";
        int n = str.length();
        for(int i = begin;i < end ;i++){
            if(isPalin(str,begin,i)){
                if(i == n-1){
                    delimiter = "";
                }
                printPalidromePartitions(str,output+str.substring(begin,i+1)+delimiter,i+1,end);
            }
        }
    }

    private boolean isPalin(String str, int begin, int end) {
        while(begin < end){
            if(str.charAt(begin) != str.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String args[]){

        PalindromicPartitions pal = new PalindromicPartitions();
        String str = "banana";
        String output = "";
        pal.printPalidromePartitions(str, output, 0, str.length());
    }

}
