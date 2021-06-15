package com.vineethds.others;

import java.util.Scanner;

public class FIndCharacterDifference {

    public static void printDifference(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int i = 0, j =0;
        System.out.println(s1);
        System.out.println(s2);
        while(i < l1 && j < l2){
            if(s1.charAt(i) == s2.charAt(j)){
                System.out.print(".");
            }else{
                System.out.print("*");
            }
            i++;
            j++;
        }

        while(i < l1){
            System.out.print("*");
            i++;
        }

        while(j < l2){
            System.out.print("*");
            i++;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i< n; i++){
            String str1 = scan.next();
            String str2 = scan.next();
            printDifference(str1, str2);
        }

    }
}
