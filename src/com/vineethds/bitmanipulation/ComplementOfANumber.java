package com.vineethds.bitmanipulation;

/*
For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.

Input: 8
Output: 7
Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10.

TC: O(b) - b - bitCount;
 */
public class ComplementOfANumber {

    public static int bitwiseComplement(int num){
        int n = num;
        int bitCount = 0;
        while(n > 0){
            bitCount++;
            n = n >> 1;
        }
        // complement = all_set_bits ^ num;
        // (16) 1111 ^ (8)1000 = 0111 (7)
        int all_set_bits = (int)Math.pow(2,bitCount) - 1;
        return num ^ all_set_bits;
    }

    public static void main(String[] args) {
        System.out.println("Bitwise complement is: " + ComplementOfANumber.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + ComplementOfANumber.bitwiseComplement(10));
        System.out.println(~0);
    }
}
