/*
 * Graph API
 */
package algorithms_datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kyoo
 */
public class Graph {
    public static void main(String[] args) {
        Graph g= new Graph(4);
    }
    final int V;
    private List<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        adj= new LinkedList[V];
        for (int i=0;i<adj.length;i++)
            adj[i] = new LinkedList<>();
    }
    public void add(int v, int w){
        adj[v].add(w);
        adj[w].add(v);                
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}