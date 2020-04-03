/*
 * Question 2: below
 */
package Lab5;

import java.util.Scanner;

public class postfixCalculator {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter infix expression\t\t: ");
        final String infix = replaceAll(s.nextLine());
        
        System.out.print("The infix expression is\t\t: " + infix);
        
        String postfix = infixToPostfix(infix);
        System.out.print("\nThe postfix expression is\t: " + postfix);
        
        System.out.println("\nThe result is: " + postfixEvaluation(postfix));
        
    }
    
    public static String replaceAll(String a){
        a = a.replaceAll("ob", "(");
        a = a.replaceAll("cb", ")");
        a = a.replaceAll("add", "+");
        a = a.replaceAll("sub", "-");
        a = a.replaceAll("mul", "*");
        a = a.replaceAll("div", "/");
        a = a.replaceAll("mod", "%");
        return a;
    }
    
    public static String infixToPostfix(String a){
        Stack<String> st = new Stack<>();
        String s = "";
        char c = ' ';
        
        for(String ch : a.split(" ")){
            if (Character.isLetterOrDigit(ch.charAt(0))) s += ch + " ";
            else if (ch.charAt(0) == '(') st.push(ch);
            else if (ch.charAt(0) == ')') {
                c = st.pop().charAt(0);
                while(c != '('){
                    s += c + " ";
                    c = st.pop().charAt(0);
                }
            } else {
                if(!st.isEmpty()){
                    if(st.peek().charAt(0) == '(') st.push(ch);
                    else {
                        c = st.peek().charAt(0);
                        while(getPriority(ch.charAt(0)) <= getPriority(c)){
                            s += st.pop() + " ";
                            if(!st.isEmpty()){
                                c = st.peek().charAt(0);
                                if(c == '(') break;
                            }
                            else break;
                        }
                        st.push(ch);
                    }
                }
                else st.push(ch);
            }
        }
        
        while(!st.isEmpty()) s += st.pop() + " ";
        
        return s;
    }
    
    public static int getPriority(char a){
        switch(a){
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
    public static double postfixEvaluation(String a){
        Stack<String> st = new Stack<>();
        double num1 = 0, num2 = 0, result = 0;
        
        for(String ch : a.split(" ")){
            if(Character.isLetterOrDigit(ch.charAt(0))) st.push(ch);
            else {
                num2 = Double.parseDouble(st.pop());
                num1 = Double.parseDouble(st.pop());
                result = getResult(num1, num2, ch.charAt(0));
                st.push(result + "");
            }
        }
        result = Double.parseDouble(st.pop());
        return result;
    }
    
    public static double getResult(double a, double b, char c){
        switch(c){
            case '+': 
                return a + b;
            case '-': 
                return a - b;
            case '*': 
                return a * b;
            case '/': 
                return a / b;
            case '%': 
                return a % b;
        }
        return 0;
    }
    
}
/*
2. Write a postfix calculator that can compute the integer value of an infix expression. The operators used in the calculator are add, sub, mul, div, mod. Extra operators include ob=open bracket and cd=close bracket.  

Infix to Postfix Conversion 
When an operand is read, output it 
When an operator is read    
    pop until the stack has a lower precedence operator    
    then, push the new operator 
When ( is found, push. 
When ) is found, pop until the matching (.  
When reach the end of input, pop until the stack is empty.  

Postfix Evaluation 
Scan the postfix expression from left to right 
If recognize an operand, push it on the stack. 
If recognize an operator, pop two operands from the stack.  
Apply the operation and push the result on the stack. 
Continue the expression until the end. The result is on the top of the stack.

Example output:
Enter infix expression      : 34 add 11 mul 7
The infix expression is     : 34 + 11 * 7
The postfix expression is   : 34 1 7 * + 
The result is: 111

Enter infix expression      : ob 300 mul 75 add 4350 cb div 15 add 1126
The infix expression is     : ( 300 * 75 + 4350 ) / 15 + 1126
The postfix expression is   : 300 75 * 4350 + 15 / 1126 +
Thee result is: 2916

Enter infix expression      : ob ob 5 add 8 cb sub ob 7 sub 3 cb cb mul 8 add 25 mod 3
The infix expression        : ( ( 5 + 8 ) - ( 7 - 3 ) ) * 8 + 25 % 3
The postfix expression is   : 5 8 + 7 3 - - 8 * 25 3 % +
The result is: 73
*/