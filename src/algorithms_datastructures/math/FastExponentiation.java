package algorithms_datastructures.math;
//O(log(n))
public class FastExponentiation {
    public double pow(double a, int n){
        if(n==0) return 1;
        if(n==1) return a;
        double r=pow(a,n/2);
        return r*r*pow(a, n%2);
    }
}
