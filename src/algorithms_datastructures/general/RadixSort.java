/*
 * RadixSort
 */
package algorithms_datastructures.general;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] vals={2,111,3,24,15,3,21,3,12,21,3,53,24};
        System.out.println(Arrays.toString(radixSort(vals)));
    }    

    private static int[] radixSort(int[] vals) {
        for (int i = 0; i < 5; i++){
            vals=countingSortByDigit(vals,i);
        }
        return vals;
    }
    private static int getKey(int v, int pos){
        return (v/(int)Math.pow(10, pos))%10;
    }

    private static int[] countingSortByDigit(int[] vals, int d) {
        int[] b= new int[10];
        for (int i = 0; i < vals.length; i++)
            b[getKey(vals[i],d)]++;
        for (int i = 1; i < b.length; i++)
            b[i]+=b[i-1];
        int[] resp= new int[vals.length];
        for (int i = vals.length-1; i >=0; i--)
            resp[--b[getKey(vals[i],d)]]=vals[i];
        return resp;
    }
}