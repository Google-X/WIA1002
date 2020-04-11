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
    public static void main(String[] args) {
        
        Stack<Character> st = new Stack<>(true);
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter an expression : ");
        String str = s.nextLine();
        int space = 0;
        boolean missing = false;
        boolean extra = false;
        
        for(char c : str.toCharArray()) {
            space++;
            if(c == ';') {
                if(st.pushParen(c) > 0) {
                    missing = true;
                }
            } else {
                if (st.pushParen(c) < 0) {
                    extra = true;
                    break;
                } 
            }
        }
        
        if(missing){
            System.out.println(str);
            for(int i=0;i<space-1;i++) System.out.print(" ");
            System.out.println("^ Missing " + st.check());
        } else if (extra){
            System.out.println(str);
            for(int i=0;i<space;i++) System.out.print(" ");
            System.out.println("^ Extra " + st.check());
        } else {
            System.out.println(str);
            System.out.println("The expression is balanced");
        }
        
    }
}
