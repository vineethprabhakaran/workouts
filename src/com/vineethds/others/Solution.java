package com.vineethds.others;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */

    static HashMap<Integer, List<Integer>> map;
    public static int connectedSum(int n, List<String> edges) {
        map = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        for(String edge : edges){
            String[] str = edge.split(" ");
            int src = Integer.parseInt(str[0]);
            int dest = Integer.parseInt(str[1]);
            if (!map.containsKey(src)) map.put(src, new ArrayList<>());
            if (!map.containsKey(dest)) map.put(dest, new ArrayList<>());
            map.get(src).add(dest);
            map.get(dest).add(src);
        }
        int res = 0;
        for (int i= 1; i< n + 1; ++i) {
            if (!visited[i]) res += doBFS(i, visited);
        }
        return res;

    }

    public static  int doBFS(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return (int)(Math.ceil(Math.sqrt(cnt)));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> edges = new ArrayList<>();
        edges.add("1 2");
        edges.add("1 3");
        edges.add("2 4");
        edges.add("3 5");
        edges.add("7 8");
        int sum = Result.connectedSum(10,edges );
        System.out.println("Ans "+sum);
    }
}