/*
 * 4. Fibonacci is series of numbers in which each number is the sum of the two preceding numbers. Example 1, 1, 2, 3, 5, 8, etc. Write a method to solve the Fibonacci, Fib(N) given Fib(1)=1 and Fib(2)=1. You can use the stack implementation with linked list.  
Example output:

Fib(1): 1
Fib(5): 5
Fib(8): 21
Fib(14): 377

 */
package T5;

public class Fibonacci {
    
    // ANOTHER WAY
    public static void main(String[] args) {
        fib(1);
        fib(5);
        fib(8);
        fib(14);
    }
    
    public static void fib(int n) {
        Stack<Integer> list = new Stack<>();

        int num1 = 1;
        int num2 = 1;
        int sum = 1;
        list.push(num1);
        list.push(num2);

        for (int i = 2; i < n; i++) {
            int second = list.pop();
            sum = second + list.pop();
            list.push(second);
            list.push(sum);
        }
        System.out.println("Fib(" + n + "): " + sum);
    }
    
    /*
    public static void main(String[] args) {

        int[] n = {1, 5, 8, 14};
        
        Stack<Integer>[] st = new Stack[n.length];
        for(int i = 0; i < n.length; i++) st[i] = new Stack<>();
        
        for(int i = 0; i < n.length; i++) fib(st[i], 0, n[i]);
        
        for(int i = 0; i < n.length; i++){
            int l1 = st[i].pop();
            int l2 = st[i].pop();
            System.out.printf("Fib(%d): %d\n", n[i], (l1+l2));
            st[i].push(l2);
            st[i].push(l1);
        }
    }

    public static void fib(Stack st, int s, int n) {
        if(s == 0) {
            st.push(0);
            fib(st, s+1, n);
        }
        if (s == 1 || s == 2 ){
            st.push(1);
            if(s < n){
                fib(st, s+1, n);
            } 
        }
        if (s > 2 && s < n){
            int top = (int) st.pop();
            int fibo = top + (int) st.peek();
            st.push(top);
            st.push(fibo);
            fib(st, s+1, n);
        }
    }
    
    // Easiest way
    public static int fibo(int n){
        if(n <= 1) return n;
        return fibo(n-1) + fibo(n-2);
    }
*/
}
