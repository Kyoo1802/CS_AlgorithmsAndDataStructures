package algorithms_datastructures.general;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap= new ArrayList<>();
    public Heap(){
        heap.add(null);
    }
    public int getMax(){
        return heap.get(1);
    }
    public void add(Integer v){
        heap.add(v);
        for (int i = heap.size()-1; i >1; i/=2)
            if(heap.get(i)> heap.get(i/2))
                swap(i, i/2);
    }
    public boolean isEmpty(){
        return heap.size()<=1;
    }
    public Integer removeMax(){
        if(isEmpty())
            return null;
        int max=heap.get(1);
        int last=heap.remove(heap.size()-1);
        if(!isEmpty()){
            heap.set(1, last);
            for (int i = 1; i*2 < heap.size();) {
                int izq=i*2;
                int der=i*2+1;
                int idxHijo=izq;
                if(der < heap.size() && heap.get(izq) < heap.get(der))
                    idxHijo=der;
                if(heap.get(i)<heap.get(idxHijo))
                    swap(i, idxHijo);
                i=idxHijo;
            }
        }
        return max;
    }
    private void swap(int i, int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
}
