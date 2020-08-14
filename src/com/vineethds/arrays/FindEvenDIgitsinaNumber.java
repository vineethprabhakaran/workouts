package com.vineethds.arrays;
/*
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
 */
public class FindEvenDIgitsinaNumber {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        FindEvenDIgitsinaNumber fn = new FindEvenDIgitsinaNumber();
        int res = fn.findNumber(nums);
        System.out.print(res);
        System.out.println();
        System.out.println(Math.log10(123)+1);

    }

    private int findNumber(int[] nums) {
        int evenCount = 0;
        for(int num : nums){
            int i = 1;
            while( num != 0){
                num = num/10;
                if(num != 0){
                    i++;
                }
            }
            if(i%2 == 0){
                evenCount++;
            }
        }
        return evenCount;
    }
}
