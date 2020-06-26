/*
 * 3. Write a program to request an infix expression from the user and then insert the expression to the BSTExpression. You need to create the new BSTExpression class.   
Example output:

Enter Infix Expression : 4+5*7
The number of elemetns in the tree : 5
The tree elements - INORDER : <-- 4 <-- + <-- 5 <-- * <-- 7
The tree elements - PREORDER : 
The tree elements - POSTORDER : 

Example 2:
Enter Infix Expression : (5*4+8)/7+2
The number of elemetns in the tree : 9
The tree elements - INORDER : 
The tree elements - PREORDER : 
The tree elements - POSTORDER : 

 */
package Lab7;

import T5.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BSTExpression {

    static List<String> Expression = new ArrayList<String>();
    static BST<String> tree = new BST<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter Infix Expression : ");
        setExpression("(5*4+8)/7+2");

        System.out.println("The number of elements in the tree : " + Expression.size());

        System.out.print("The tree elements - INORDER : ");
        tree.setOrder(1);
        tree.showTreeStack();

        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(2);
        tree.showTreeStack();

        System.out.print("The tree elements - POSTORDER : ");
        tree.setOrder(3);
        tree.showTreeStack();

    }

    public static void createBST() {

        Stack<Character> operator = new Stack<>();
        Stack<BST> bst = new Stack<>();

        for (String e : Expression) {
            if (e.equals("(")) {
                operator.push(e.charAt(0));
            } else if (e.equals(")")) {
                char c = operator.peek();
                while (c != '(') {
                    subTree(operator, bst);
                    if (operator.peek() == '(') {
                        operator.pop();
                    }
                }
            } else if (Character.isLetterOrDigit(e.charAt(0))) {
                BST<String> tmp = new BST<>();
                tmp.addNode(e);
                bst.push(tmp);
            } else {
                if (operator.isEmpty()) {
                    operator.push(e.charAt(0));
                } else {
                    char c = operator.peek();
                    if (getPriority(e.charAt(0)) >= getPriority(c)) {
                        operator.push(e.charAt(0));
                    } else {
                        while (getPriority(e.charAt(0)) < getPriority(c)) {
                            subTree(operator, bst);
                            if (!operator.isEmpty()) {
                                c = operator.peek();
                            } else {
                                break;
                            }
                        }
                        operator.push(e.charAt(0));
                    }
                } 
            }

            while (!operator.isEmpty()) {
                subTree(operator, bst);
            }

            tree = bst.pop();
        }
    }
    
    public static void setExpression(String input) {

        char[] c = input.toCharArray();
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

    public static void subTree(Stack<Character> operator, Stack<BST> bst) {
        char oper = operator.pop();
        BST<Character> newTree = new BST<>();
        newTree.addNode(oper);
        BST<Character> right = bst.pop();
        newTree.getRoot().setRight(right.getRoot());
        if (!bst.isEmpty()) {
            BST<Character> left = bst.pop();
            newTree.getRoot().setLeft(left.getRoot());
        }
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
