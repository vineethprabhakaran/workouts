package com.vineethds.graphs;



import java.util.Iterator;
import java.util.LinkedList;

class Graph1{
    int V;
    LinkedList<Integer> adj[];
    Graph1(int v){
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i< V; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
}

public class DFSTraversal {

    public void addEdge(Graph1 graph,int v,int w){
        graph.adj[v].add(w);
    }

    public void DFSUtil(Graph1 graph,int s,boolean[] visited){
        visited[s] =  true;
        System.out.print(s + " ");
        Iterator itr = graph.adj[s].listIterator();
        while(itr.hasNext()){
            s = (int) itr.next();
            if(!visited[s]){
                DFSUtil(graph,s,visited);
            }
        }
    }

    public void DFS(Graph1 graph){
        boolean visited[] = new boolean[graph.V];
        for(int i = 0 ; i< graph.V;i++){
            if(!visited[i]){
                DFSUtil(graph,i,visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSTraversal dfs = new DFSTraversal();
        Graph1 graph = new Graph1(4);
        dfs.addEdge(graph,0, 1);
        dfs.addEdge(graph,0, 2);
        dfs.addEdge(graph,1, 2);
        dfs.addEdge(graph,2, 0);
        dfs.addEdge(graph,2, 3);
        dfs.addEdge(graph,3, 3);
        dfs.DFS(graph);
    }
}
