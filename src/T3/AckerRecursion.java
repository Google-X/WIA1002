/*
 * 2. Define a recursive method Acker(m,n) that return the value as follow: 
 If m=0, Acker(m,n) = n + 1   
 If n=0 , Acker(m,n) = Acker(m-1,1) 
 Otherwise, Acker(m,n) = Acker(m-1, Acker(m, n-1))    
Find the value of Acker(3, 4) and Acker(2,5) 
 */
package T3;

public class AckerRecursion {
    public static void main(String[] args) {
        
        System.out.println("Acker(3, 4): " + Acker(3, 4));
        System.out.println("Acker(2, 5): " + Acker(2, 5));
        System.out.println("Acker(1, 1): " + Acker(1, 1));
        
    }
    
    public static int Acker(int m, int n){
        
        if(m == 0) return n+1;
        else if (n == 0) return Acker(m-1, 1);
        else return Acker(m-1, Acker(m, n-1));
        
    }
}
