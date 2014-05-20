/*
 * Connected Components Algorithm
 */
package algorithms_datastructures.graphs;

/**
 *
 * @author Kyoo
 */
public class ConnectedComponents {
    int[] cc;
    boolean[] marks;
    public ConnectedComponents(Graph g){
        marks= new boolean[g.V];
        cc=new int[g.V];        
        int count=0;
        for (int v = 0; v < g.V; v++)
            if(!marks[v])
                dfs(g,v,count++);
    }
    private void dfs(Graph g, int v, int count) {
        marks[v]=true;
        cc[v]=count;
        for (Integer vAdj : g.adj(v))
            if(!marks[vAdj])
                dfs(g, vAdj,count);
    }
    public boolean connected(int v, int w){
        return cc[v]==cc[w];
    }
}