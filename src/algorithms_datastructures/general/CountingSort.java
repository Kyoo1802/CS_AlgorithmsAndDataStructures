/*
 * CountingSort
 */
package algorithms_datastructures.general;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] vals={2,1,3,4,5,3,12,34,2,12,3,23,4};
        System.out.println(Arrays.toString(countingSort(vals)));
    }

    private static int[] countingSort(int[] vals) {
        int[] values= new int[1000];
        for (int i = 0; i < vals.length; i++)
            values[vals[i]]++;
        for (int i = 1; i < values.length; i++)
            values[i]+=values[i-1];
        int[] resp= new int[vals.length];
        for (int i = 0; i < vals.length; i++)
            resp[--values[vals[i]]]=vals[i];
        return resp;
    }
}
