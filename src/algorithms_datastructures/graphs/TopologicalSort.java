/*
 * TopologicalSort Algorithm
 */
package algorithms_datastructures.graphs;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Kyoo
 */
public class TopologicalSort {
    boolean[] mark;
    Deque<Integer> reversePost;
    public TopologicalSort(Digraph dG){
        mark= new boolean[dG.V];
        reversePost= new LinkedList<>();
        for (int v = 0; v < dG.V; v++) 
            if(!mark[v])
                dfs(dG,v);
    }
    private void dfs(Digraph dG, int v) {
        mark[v]=true;
        for (Integer adjV : dG.adj(v))
            if(!mark[v])
                dfs(dG, adjV);
        reversePost.push(v);
    }
    public Iterable<Integer> getReversePost(){
        return reversePost;
    }
}