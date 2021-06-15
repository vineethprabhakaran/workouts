package com.vineethds.topologicalsort;

import java.util.*;

public class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if(nodes <= 0)
            return minHeightTrees;

        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            for(int i =0;i < edge.length; i++){
                indegree.put(edge[i], 0);
                graph.put(edge[i], new ArrayList<>());
            }
        }

        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            indegree.put(n1, indegree.get(n1) + 1);
            indegree.put(n2, indegree.get(n2) + 1);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 1)
                leaves.add(entry.getKey());
        }
        int totalNodes = nodes;
        while(totalNodes > 2){
            totalNodes -= leaves.size();
            int leafSize = leaves.size();
            for(int i = 0;i < leafSize && !leaves.isEmpty(); i++){
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for(int child : children){
                    indegree.put(child, indegree.get(child) -1);
                    if(indegree.get(child) == 1)
                        leaves.add(child);
                }
            }


        }
        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }

    public static void main(String[] args) {
        List<Integer> result = MinimumHeightTrees.findTrees(5,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);

        result = MinimumHeightTrees.findTrees(4,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
    }
}
