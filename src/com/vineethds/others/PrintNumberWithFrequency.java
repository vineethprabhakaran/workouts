package com.vineethds.others;

import java.util.*;

public class PrintNumberWithFrequency {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String numbers = s.nextLine();
        String[] number = numbers.split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (String num : number) {
            int val = Integer.parseInt(num);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        list.addAll(map.entrySet());
        Collections.sort(list, new SortComparator());
        for(Map.Entry<Integer, Integer> res : list){
            System.out.print(res.getValue()+" ");
        }
    }
}

class SortComparator implements Comparator<Map.Entry<Integer, Integer>>{

    public int compare(Map.Entry<Integer, Integer> a , Map.Entry<Integer, Integer> b){

        int freq = a.getValue().compareTo(b.getValue());
        int valComp = a.getKey().compareTo(b.getKey());
        if(freq == 0)
            return valComp;
        else
            return freq;
    }
}