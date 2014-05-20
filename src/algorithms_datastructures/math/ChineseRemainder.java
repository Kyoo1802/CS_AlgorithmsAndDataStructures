package algorithms_datastructures.math;

/**
 * Given a, b, n, m such that n and m are coprime
 * Find x such that x ≡ a (mod m) , x ≡ b (mod n) 
 */
public class ChineseRemainder {
    public static int chiniseReminder(int a, int b, int n, int m){
        if(GCD.gcd(n, m)!=1){
            System.out.println("n and m, must be coprime");
            return -1;
        }
        int n_1=MultiplicativeInverse.multiplicativeInverse(n, m);
        int m_1=MultiplicativeInverse.multiplicativeInverse(m, n);
        
        return a*n*n_1+b*m*m_1;
    }
}
