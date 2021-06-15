package com.vineethds.others;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/*
Generate Binary Numbers from 1 to any given number n

Time Complexity: O(N)
 */
public class GenerateBinaryNumbers {
    public static void genBinary(int number){
        String result[] = new String[number];
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for(int i = 0 ; i < number ; i++){
            result[i] = queue.remove();
            String s1 = result[i]+"0";
            String s2 = result[i]+"1";
            queue.add(s1);
            queue.add(s2);
        }
        int count = 1;
        for(String s : result){
            System.out.println(count+" -> "+s);
            count++;
        }
    }

    public static void main(String[] args) {
        genBinary(100);
    }
}
