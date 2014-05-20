package algorithms_datastructures.math;
//gcd(a,b) = ax + by for some integers x, y
//If gcd (a , n) = 1, then ax + ny = 1 for some x, y (Coprimos)
//Taking modulo n gives ax ≡ 1(mod n)
public class MultiplicativeInverse {
    public static int multiplicativeInverse(int x, int modN){
        int r=modN, newR=x;
        int t=0, newT=1;
        while(newR!=0){
            int q=r/newR;
            
            int tempT=newT;
            newT=t-q*newT;
            t=tempT;
            
            int temp=newR;
            newR=r-q*newR;
            r=temp;
        }
        if(r>1){
            System.out.println("No exite inverso multiplicativo");
            return -1;
        }
        if(t<0)
            t+=modN;
        return t;
    }
}
