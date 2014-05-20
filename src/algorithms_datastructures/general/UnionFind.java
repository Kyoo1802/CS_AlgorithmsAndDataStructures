package algorithms_datastructures.general;
//NOT Tested
import java.util.Arrays;

public class UnionFind {
    private int[] uf,wuf;
    public UnionFind(int n){
        wuf= new int[n];
        uf= new int[n];
        Arrays.fill(wuf, 1);
        for (int i = 0; i < uf.length; i++)
            uf[i]=i;
    }
    public void union(int x, int y){
        int pX=find(x);
        int pY=find(y);
        if(wuf[pX]>wuf[pY]){
            int tempX=pX;
            pX=pY;
            pY=tempX;
        }
        uf[pX]=pY;
        wuf[pY]+=wuf[pX];
    }
    public int find(int x){
        while(x!=uf[x]){
            uf[x]=uf[uf[x]];
            x=uf[x];
        }
        return x;
    }
}
