package com.vineethds.strings;

/*
Author: Vineeth
Problem: Count the Number of holes in GivenNumbner in a String
input: 630
output: 2
Order: O(N)
 */
class StringsCollection{

    static int countHoles(int nums) {
        int num = nums;
        int count = 0;
        while(num > 0){
            int n= num %10;
            num = num /10;
            if(n == 4 || n== 6 || n == 9 || n == 0){
                count++;
            }
            if(n == 8){
                count = count+2;
            }
        }
        return count;
    }

    public static void main(String a[]){
        System.out.println(countHoles(630));
    }
}