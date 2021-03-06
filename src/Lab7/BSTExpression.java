/* CREDIT: GitHub @ HeLinChooi
 * 3. Write a program to request an infix expression from the user and then insert the expression to the BSTExpression. You need to create the new BSTExpression class.   
Example output:

Enter Infix Expression : 4+5*7
The number of elemetns in the tree : 5
The tree elements - INORDER :  <-- 4 <-- + <-- 5 <-- * <-- 7
The tree elements - PREORDER :  <-- + <-- 4 <-- * <-- 5 <-- 7
The tree elements - POSTORDER :  <-- 4 <-- 5 <-- 7 <-- * <-- +

Example 2:
Enter Infix Expression : (5*4+8)/7+2
The number of elemetns in the tree : 9
The tree elements - INORDER :  <-- 5 <-- * <-- 4 <-- + <-- 8 <-- / <-- 7 <-- + <-- 2
The tree elements - PREORDER :  <-- + <-- / <-- + <-- * <-- 5 <-- 4 <-- 8 <-- 7 <-- 2
The tree elements - POSTORDER :  <-- 5 <-- 4 <-- * <-- 8 <-- + <-- 7 <-- / <-- 2 <-- +

 */
package Lab7;

import T5.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BSTExpression {

    static List<String> Expression = new ArrayList<String>();
    static BST<String> Tree;
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Tree = new BST<>();
        System.out.print("Enter Infix Expression : ");
        setExpression(s.nextLine());

        System.out.println("The number of elements in the tree : " + Tree.getSize());

        System.out.print("The tree elements - INORDER : ");
        Tree.setOrder(1);
        Tree.showTreeStack();

        System.out.print("The tree elements - PREORDER : ");
        Tree.setOrder(2);
        Tree.showTreeStack();

        System.out.print("The tree elements - POSTORDER : ");
        Tree.setOrder(3);
        Tree.showTreeStack();

    }

    public static void createBST() {

        Stack<Character> operator = new Stack<>();
        Stack<BST<String>> bst = new Stack<>();

        for (String e : Expression) {
            
            // IF '(' FOUND
            if (e.equals("(")) {
                operator.push(e.charAt(0));
            } 
            
            // IF ')' FOUND
            else if (e.equals(")")) {
                char c = operator.peek();
                while (c != '(') {
                    subTree(operator, bst);
                    c = operator.peek();
                    if (c == '(') {
                        operator.pop();
                    }
                }
            } 
            
            // IF LETTER OR NUMBER IS FOUND
            else if (Character.isLetterOrDigit(e.charAt(0))) {
                BST<String> tmp = new BST<>();
                tmp.addNode(e);
                bst.push(tmp);
            } 
            
            // IF OTHER OPERATOR IS FOUND
            else {
                if (!operator.isEmpty()) {
                    char c = operator.peek();
                    if (getPriority(e.charAt(0)) >= getPriority(c)) {
                        operator.push(e.charAt(0));
                    } else {
                        while (getPriority(e.charAt(0)) <= getPriority(c)) {
                            subTree(operator, bst);
                            if (!operator.isEmpty()) {
                                c = operator.peek();
                            } else break;
                        }
                        operator.push(e.charAt(0));
                    }
                } else operator.push(e.charAt(0));
            }
        }
        
        // AFTER FINISH READING THE EXPRESSION
        while (!operator.isEmpty()) subTree(operator, bst);
        
        // POP THE BST FROM THE STACK<BST>
        Tree = bst.pop();
    }

    public static void setExpression(String input) {

        char[] c = input.replaceAll("\\s+","").toCharArray();
        String tmp = "";

        for (int i = 0; i < c.length; i++) {
            if (i == c.length - 1 && Character.isLetterOrDigit(c[i])) {
                Expression.add(tmp + c[i]);
                break;
            }
            if (Character.isLetterOrDigit(c[i])) {
                tmp += c[i];
            } else {
                if (!tmp.equals("")) {
                    Expression.add(tmp);
                    tmp = "";
                }
                Expression.add(String.valueOf(c[i]));
            }
        }
        
        createBST();
    }

    public static void subTree(Stack<Character> operator, Stack<BST<String>> bst) {
        char oper = operator.pop();
        BST<String> right = bst.pop();
        BST<String> left = bst.pop();
        BST<String> newTree = new BST<>();
        newTree.addNode(String.valueOf(oper));
        newTree.getRoot().setLeft(left.getRoot());
        newTree.getRoot().setRight(right.getRoot());
        bst.push(newTree);
    }

    public static int getPriority(char a) {
        switch (a) {
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
}
