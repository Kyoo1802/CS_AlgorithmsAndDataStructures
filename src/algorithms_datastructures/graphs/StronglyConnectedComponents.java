/*
 * Strongly Connected Components
 */
package algorithms_datastructures.graphs;

/**
 *
 * @author Kyoo
 */
public class StronglyConnectedComponents {
    int[] scc;
    boolean[] mark;
    public StronglyConnectedComponents(Digraph g){
        scc= new int[g.V];
        mark= new boolean[g.V];
        TopologicalSort ts= new TopologicalSort(g.reverse());
        int count=0;
        for (Integer v : ts.getReversePost()) {
            if(!mark[v])
                dfs(g,v,count++);
        }
    }
    private void dfs(Digraph g, int v, int count) {
        mark[v]=true;
        scc[v]=count;
        for (Integer adjV : g.adj(v)) 
            if(!mark[v])
                dfs(g, adjV, count);
    }
    public boolean stronglyConnected(int v, int w){
        return scc[v]==scc[w];
    }
}
