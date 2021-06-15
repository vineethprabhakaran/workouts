package com.vineethds.topologicalsort;

import java.lang.reflect.Array;
import java.util.*;

public class SequenceReconstruction {

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        if(originalSeq.length == 0)
            return false;

        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < sequences.length; i++){
            int[] seq = sequences[i];
            for(int num : seq){
                indegree.put(num, 0);
                graph.put(num, new ArrayList<>());
            }
        }

        for(int[] seq : sequences){
            for(int i = 1; i < seq.length; i++){
                int parent = seq[i -1];
                int child = seq[i];
                if(parent != child){
                    graph.get(parent).add(child);
                    indegree.put(child, indegree.get(child) + 1);
                }
            }
        }

        if(originalSeq.length != indegree.size())
            return false;

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue() == 0)
                queue.add(entry.getKey());
        }
        List<Integer> sortedOrder = new ArrayList<>();
        while(!queue.isEmpty()){
            if(queue.size() > 1)
                return false;

            if(originalSeq[sortedOrder.size()] != queue.peek())
                return false;

            int vertex = queue.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for(int child : children ){
                indegree.put(child, indegree.get(child) -1);
                if(indegree.get(child) == 0)
                    queue.add(child);
            }
        }


        return sortedOrder.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
