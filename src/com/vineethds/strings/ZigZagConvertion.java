package com.vineethds.strings;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConvertion {

    private void convertAotherSolution(String s, int n) {
        if(s.isEmpty()){
            return;
        }
        if(n == 0){
            System.out.println(s);
            return;
        }
        int currlen = 2 * n - 2;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0 ;j + i < s.length(); j += currlen){
                str.append(s.charAt(i+j));
                if(i != 0 && i != n-1 && j + currlen - i < s.length()){
                    str.append(s.charAt(j + currlen - i));
                }
            }
        }

        System.out.println(str);

    }

    private void convert(String s, int n, boolean isGoingDown, int down) {
        if(s.isEmpty()){
            return;
        }
        if(n == 0){
            System.out.println(s);
            return;
        }
        HashMap<Integer,String> hm = new HashMap();
        for(int i = 0; i < s.length(); i++){
            String str = hm.get(down);
            if(str == null){
                hm.put(down,s.charAt(i)+"");
            }else{
                hm.put(down,str+s.charAt(i));
            }

            if(down == n-1 || down == 0){
                isGoingDown = !isGoingDown;
            }
            if (isGoingDown){
                down++;
            }else{
                down--;
            }
        }

        String result = "";
        for(int i = 0; i < n ;i++){
            result+=hm.get(i);
        }
        System.out.print(result);
    }

    public static void main(String[] args){
        ZigZagConvertion zigzag = new ZigZagConvertion();
        String s = "PAYPALISHIRING";
        int n = 3;
        boolean isGoingDown = false;
        int down  = 0;
        zigzag.convert(s,n,isGoingDown,down);
        System.out.println("");
        zigzag.convertAotherSolution(s , n);
    }


}
