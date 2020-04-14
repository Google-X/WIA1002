/*
 * 4. Write a program to determine whether a string is palindrome. (You can use stack and queue to solve the problem).   
Example output:

kayak is a palindrome
Welcome is not a palindrome
Was it a car or a cat I saw? is not a palindrome
civic is a palindrome
race car is not a palindrome

 */
package T6;

import T5.Stack;

public class Palindrome {
    public static void main(String[] args) {
        
        String[] list = {"kayak", "Welcome", "Was it a car or a cat I saw?", "civic", "race car"};
        
        for(String s : list){
            Queue<Character> Q = new Queue<>();
            Stack<Character> S = new Stack<>();
            for(char c : s.toCharArray()) {
                Q.enqueue(c);
                S.push(c);
            }
            String Qu = Q.showQueuePalindrome();
            String St = S.showStackPalindrome();
            
            if(Qu.equals(St)) System.out.println(s + " is a palindrome");
            else System.out.println(s + " is not a palindrome");
            
        }   
    }
}
