package com.vineethds.trees;

import java.util.ArrayList;
import java.util.Collections;

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