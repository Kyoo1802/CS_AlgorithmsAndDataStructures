package algorithms_datastructures.general;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray implements Comparator<Integer>{
    private  String s;
    private  Integer[] idxSfxSorted,rankIdx,lcp;
    private int t;
    public SuffixArray(){}
    public SuffixArray(String s){
        rankIdx= new Integer[s.length()*2+2];
        idxSfxSorted= new Integer[s.length()];
        lcp= new Integer[s.length()];
        Arrays.fill(rankIdx, 0);
        Arrays.fill(lcp, 0);
        suffixArray();
        lcp();
    }
    public void fixRank(int rIdxI, int rIdxJ) {
        int rankINextT = rankIdx[idxSfxSorted[rIdxI] + t];
        int tamGroup = rIdxJ  - rIdxI;
        int d = 0;
        int np = rIdxI;
        int pk;
        for(int i = 0; i < tamGroup; i++) {
           if (((pk = rankIdx[idxSfxSorted[rIdxI]+t]) != rankINextT) && !(np <= rankINextT && pk < np+tamGroup)) {
              rankINextT = pk;
              d = i;
           }
           rankIdx[idxSfxSorted[rIdxI++]] = np + d;
        }
    }
    
    @Override
    public int compare(Integer i, Integer j) {
        return rankIdx[i + t] - rankIdx[j + t];
    }
    private void suffixArray(){
        int[] abc= new int[256];
        //---Counting sort Inicia
        for (int i = 0; i < s.length(); i++) 
            abc[s.charAt(i)]++;//se tiene la frecuencia
        for (int i = 1; i < abc.length; i++) 
            abc[i]+=abc[i-1];//se realiza la frecuencia acumulada
        for (int i = 0; i < s.length(); i++)
            idxSfxSorted[--abc[s.charAt(i)]]=i;//se consigue el ordenamiento de caracteres
        //---Counting sort Completo
        for (int i = s.length()-1; i >= 0; i--) 
          rankIdx[i]=abc[s.charAt(i)];//caracteres indice ordenado(repetidos mismo valor)
        
        for (t = 1; t < s.length(); t*=2) {//potencias de 2
            for (int i = 0,j=1; i < s.length(); i=j++) {
                //agrupar prefijos con el mismo nivel (necesario ordenar en base al segundo caracter)
                while(j < s.length() && rankIdx[idxSfxSorted[i]] == rankIdx[idxSfxSorted[j]])
                    ++j;
                if (j - i > 1) {//si el grupo es mayor a 1
                    Arrays.sort(idxSfxSorted, i, j, this);//ordena el rango i-j en base al siguiente T caracter
                    fixRank(i, j);
                }
            }
        }
    }
    private void lcp() {
        int tam = 0, i, j;
        for(i = 0; i < s.length(); i++)
            if (rankIdx[i] > 0) {
                j = idxSfxSorted[rankIdx[i] - 1];
                while(j+tam<s.length() && s.charAt(i + tam) == s.charAt(j + tam))
                    tam++;
                lcp[rankIdx[i] - 1] = tam;
                if (tam > 0)
                    tam--;
            }
        lcp[s.length() - 1] = 0;
    }
    public Integer[] getLCP(){
        return lcp;
    }
    public Integer[] getIdxSfx(){
        return idxSfxSorted;
    }
    public String toString(){
        return "idx:"+Arrays.toString(idxSfxSorted)+"\nlcp:"+Arrays.toString(lcp);
    }
}