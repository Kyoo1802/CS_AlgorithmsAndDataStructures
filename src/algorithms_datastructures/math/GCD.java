package algorithms_datastructures.math;
//O(log(a+b))
public class GCD {
    public static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
