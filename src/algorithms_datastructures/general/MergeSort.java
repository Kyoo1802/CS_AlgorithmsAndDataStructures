/*
 * MergeSort
 */
package algorithms_datastructures.general;

import java.util.Arrays;

/**
 *
 * @author Kyoo
 */
public class MergeSort {
    public static void main(String[] args) {        
        int[] vals={2,111,3,24,15,3,21,3,12,21,3,53,24};
        System.out.println(Arrays.toString(mergeSort(vals)));
    }

    private static int[] mergeSort(int[] vals) {
        mergeSort(vals, 0, vals.length-1);
        return vals;
    }
    private static void mergeSort(int[] val, int low, int hight){
        int half=(low+hight)/2;
        if(low<hight){
            mergeSort(val, low, half);
            mergeSort(val, half+1,hight);
            int size=hight-low+1;
            int[] temp= new int[size];
            int j=low;
            int k=half+1;
            for (int i = 0; i < size; i++) {
                if(j<=half && k<=hight)
                    temp[i]= val[j]<=val[k]?val[j++]:val[k++];
                else if(j<=half)
                    temp[i]=val[j++];
                else
                    temp[i]=val[k++];          
            }
            System.arraycopy(temp, 0, val, low, size);
        }
    }
}