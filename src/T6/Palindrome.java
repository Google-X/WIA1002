/* QUESTION 4 & 5
 * 4. Write a program to determine whether a string is palindrome. (You can use stack and queue to solve the problem).   
Example output:

kayak is a palindrome
Welcome is not a palindrome
Was it a car or a cat I saw? is not a palindrome
civic is a palindrome
race car is not a palindrome

5. Modify Question 4 to ignore the capital letter, punctuation and space characters.   
Example output:   

Was it a car or a cat I saw? is a palindrome
?civic# is a palindrome
race car is a palindrome
redrawer is not a palindrome
put      it up is a palindrome

 */
package T6;

import T5.Stack;

public class Palindrome {
    public static void main(String[] args) {
        
        // Question 4
        System.out.println("Question 4");
        String[] list = {"kayak", "Welcome", "Was it a car or a cat I saw?", "civic", "race car"};
        check(list, list);
        
        
        // Question 5
        System.out.println("\n\nQuestion 5");
        String[] list2 = {"Was it a car or a cat I saw?", "?civic#", "race car", "redrawer", "put      it up"};
        String[] list2Tmp = new String[list2.length];
        for(int i = 0; i < list2.length; i++){
            list2Tmp[i] = list2[i].toLowerCase();
            list2Tmp[i] = list2Tmp[i].replaceAll("[^a-zA-Z0-9]", "");
        }
        check(list2, list2Tmp);
        
    }
    
    public static void check(String[] list, String[] tmp){
        for(int i = 0; i < list.length; i++){
            Queue<Character> Q = new Queue<>();
            Stack<Character> S = new Stack<>();
            for(char c : tmp[i].toCharArray()) {
                Q.enqueue(c);
                S.push(c);
            }
            String Qu = Q.showQueuePalindrome();
            String St = S.showStackPalindrome();
            
            if(Qu.equals(St)) System.out.println(list[i] + " is a palindrome");
            else System.out.println(list[i] + " is not a palindrome");
            
        }
    }
}
