/*
 * 4. 4. Write a program to evaluate the statement source code correctly matches left-right parentheses, brackets and braces (), [] and {}. The statement will ignore the parentheses, brackets and braces if the \ character appear before parentheses, brackets and braces, \(, \] and etc.  
Example output:
Enter an expression : System.out.print(str.charAt(3);
System.out.print(str.charAt(3);
                              ^ Missing )

Enter an expression : System.out.print("\(No Error");
System.out.print("\(No Error");
The expression is balanced

Enter an expression : int[] num = 1, 2};
int[] num = {1, 2}};
                  ^ Extra }

Enter an expression : if (arr[{3] < 4)
if (arr[{3] < 4)
          ^ Missing }

 */
package Lab5;

import java.util.Scanner;

public class StatementEvaluation {
    
    static char[] open = {'(', '{', '['};
    static char[] close = {')', '}', ']'};
    
    public static void main(String[] args) {
        
        Stack<Character> st = new Stack<>();
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter an expression : ");
        String str = s.nextLine();
        boolean extra = false;
        char[] li = str.toCharArray();
        int i = 0;
        
        for(i = 0; i < li.length; i++){
            if(li[i] == '\\') i++;
            else if(li[i] == ';') break;
            else {
                if(checkOpenParenthesis(li[i])) st.push(li[i]);
                else if(checkCloseParenthesis(li[i])){
                    if(st.getSize() > 0 && open[getIndex(li[i])] == st.peek()) st.pop();
                    else if(st.getSize() == 0) {
                        st.push(li[i]);
                        extra = true;
                        break;
                    }
                    else break;
                }
            }
        }
        
        // Final Output
        System.out.println(str);
        if(st.getSize() == 0 && !extra){
            System.out.println("The expression is balanced");
        } else {
            for(int j = 0; j < i; j++) System.out.print(" ");
            if(extra){
                System.out.println("^ Extra " + close[getIndex(st.peek())]);
            } else {
                System.out.println("^ Missing " + close[getIndex(st.peek())]);
            }
        }
    }
    
    public static boolean checkOpenParenthesis(char c){
        for(int i = 0; i < open.length; i++){
            if(open[i] == c) return true;
        }
        return false;
    }
    
    public static boolean checkCloseParenthesis(char c){
        for(int i = 0; i < close.length; i++){
            if(close[i] == c) return true;
        }
        return false;
    }
    
    public static int getIndex(char c){
        for(int i = 0; i < close.length; i++){
            if(close[i] == c || open[i] == c) return i;
        }
        return -1;
    }
}
