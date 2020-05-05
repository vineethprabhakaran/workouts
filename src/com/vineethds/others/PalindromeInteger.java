package com.vineethds.others;

public class PalindromeInteger {

    private static boolean checkIfPalindrome(int num) {
        int reverseInteger = 0;
        int orginalNumber = num;
        int remainder = 0;
        while(orginalNumber!=0){
            remainder = orginalNumber %10;
            reverseInteger = reverseInteger * 10 + remainder;
            orginalNumber = orginalNumber/10;
        }
        if(num == reverseInteger){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 101;
        System.out.println(checkIfPalindrome(num));
    }

}

