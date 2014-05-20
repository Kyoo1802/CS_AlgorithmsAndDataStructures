/*
 * Digraph API
 */
package algorithms_datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kyoo
 */
public class Digraph {
    List<Integer>[] adj;
    final int V;
    public Digraph(int V){
        this.V=V;
        adj= new LinkedList[V];
    }
    public Digraph reverse(){
        Digraph reverseG= new Digraph(V);        
        for (int v = 0; v < V; v++)
            for (Integer w : adj(v))
                reverseG.add(w, v);        
        return reverseG;
    }
    public void add(int v, int w){
        adj[v].add(w);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}