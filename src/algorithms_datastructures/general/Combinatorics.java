package algorithms_datastructures.general;

/**
 *(n k) es el numero de formas para escoger k objetos de n distintos objetos
 * o el coeficiente de x^k y^(n-k) en la expansion (x+y)^n
 */
public class Combinatorics {
    long[][] mat= new long[100][100];
    public Combinatorics(){
        mat[0][0]=1;
        for (int i = 1; i < mat.length; i++)
            for (int j = 0; j <= i; j++)
                mat[i][j]=mat[i-1][j]+(j-1<0?0:mat[i-1][j-1]);
    }
    public long combinatoricsFast(int n, int k){
        return mat[n][k];
    }
    public static long combinatoricsSlow(int n, int k){
        long X=1;
        for (int i = n; i >= n-k+1; i--) 
            X*=i;
        long K=fact(k);
        return X/K;
    }
    private static long fact(int n){
        long r=1;
        for (int i = 2; i <= n; i++) 
            r*=i;
        return r;
    }
}
