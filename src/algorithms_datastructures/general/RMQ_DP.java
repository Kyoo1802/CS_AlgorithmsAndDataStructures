/*
 * RMQ DP 0<NlogN,1>
 */
package algorithms_datastructures.general;

/**
 *
 * @author Kyoo
 */
public class RMQ_DP {
        private static int rmq(int idxA, int idxB, int[][] rmq, int[] A) {
            int size=idxB-idxA+1;
            int log2S=(int)(Math.log(size)/Math.log(2));
            if(A[rmq[idxA][log2S]]<A[rmq[idxB-(1<<log2S)+1][log2S]])
                return rmq[idxA][log2S];
            else 
                return rmq[idxB-(1<<log2S)+1][log2S];
        }
        private static int[][] processRMQ(int[] picks) {
            int n=picks.length;
            int log2Size=(int)(Math.log(n)/Math.log(2));
            int[][] rmq= new int[n][log2Size+1];
            for (int idx = 0; idx < n; idx++) 
                rmq[idx][0]=idx;        

            for (int log2 = 1; log2 <= log2Size; log2++) {
                int pow=(1<<log2);
                for (int idx = 0; idx+pow-1 < n; idx++) {
                    if(picks[rmq[idx][log2-1]]<picks[rmq[idx+(1<<(log2-1))][log2-1]])
                        rmq[idx][log2]=rmq[idx][log2-1];
                    else
                        rmq[idx][log2]=rmq[idx+(1<<(log2-1))][log2-1];
                }
            }
            return rmq;
        }
}
