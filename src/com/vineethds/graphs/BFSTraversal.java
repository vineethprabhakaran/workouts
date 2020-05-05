package com.vineethds.graphs;

import java.util.Iterator;
import java.util.LinkedList;

// Graph creation
class Graph{
    int V;
    LinkedList<Integer> adj[];
    Graph(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }
}

public class BFSTraversal {

    public void addEdge(Graph graph,int v,int w){
        graph.adj[v].add(w);
    }

    public void BFS(Graph graph,int s){
        boolean visited[]  = new boolean[graph.V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s+" ");

            Iterator itr  = graph.adj[s].listIterator();
            while (itr.hasNext()){
                int n = (int) itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal bfs = new BFSTraversal();
        Graph graph = new Graph(4);
        bfs.addEdge(graph,0, 1);
        bfs.addEdge(graph,0, 2);
        bfs.addEdge(graph,1, 2);
        bfs.addEdge(graph,2, 0);
        bfs.addEdge(graph,2, 3);
        bfs.addEdge(graph,3, 3);

        bfs.BFS(graph,2);
    }

}
