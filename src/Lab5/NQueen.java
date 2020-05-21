/*
 * 3. Write a program to solve the N-Queen problem.
 */
package Lab5;

public class NQueen {
    
    static int[] col;
    
    public static void main(String[] args) {
        System.out.println("Solving the N Queens problem");
        
        int solution = 0;
        int N = 4;
        int c = 0;
        col = new int[N];
        
        Stack<Integer> st = new Stack<>();
        
        while(true){
            while(c < N){
                if(isValid(st, c)){
                    st.push(c);
                    col[st.getSize()-1] = c;
                    c = 0;
                } else c++;
            }
            if(st.getSize() == N) {
                display(st, N);
                solution++;
            }
            if(st.isEmpty()) break;
            c = st.pop()+1;
        }
        
        System.out.println("The number of solutions are : " + solution);
        
    }
    
    public static boolean isValid(Stack<Integer> st, int c){
        for(int i = 0; i < st.getSize(); i++){
            if (c == col[i] || Math.abs(c - col[i]) == st.getSize()-i) return false;
        }
        return true;
    }
    
    public static void display(Stack<Integer> s, int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (j == col[i]) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
/*
Create empty stack
Set current position to 0
while true
    Iterate from the current position to N
        if there is a valid position
        push the position to stack          // get the column
        set the current position to 0
        set the position as valid

    if there is no valid position
        if stack is empty
            exit the while  loop // stop search
        otherwise
            current position = pop stack
            set current position to next position // backtracking

    if stack has size N // found a solution
        display the solution by popping the stack
        set current position to the last element of the stack
        set current position to next position // look for next solution

Example output:
    Solving the 4 Queens problem
    * * Q *
    Q * * *
    * * * Q
    * Q * *

    * Q * *
    * * * Q
    Q * * *
    * * Q *

    The number of solutions are : 2
*/