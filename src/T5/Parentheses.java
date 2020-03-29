/*
 * 5. A common problem for compilers is to determine if the parentheses (in a string are balanced and properly nested. A string is balanced if contains properly nested pairs of parentheses. Example, ((()))() is balanced while )()( is not balanced.   
Example output:

(()) is balanced
)()( is not balanced
((())())() is balanced
(())())) is not balanced
()) is not balanced

 */
package T5;

public class Parentheses {
    public static void main(String[] args) {
        
        String[] li = {
            "(())",
            ")()(",
            "((())())()",
            "(())()))",
            "())",
        };
        
        for(int i = 0; i < li.length; i++){
            char[] cl = li[i].toCharArray();
            Stack<Character> typing = new Stack<>();
            for(char c : cl) typing.push(c);
            System.out.println(typing.balanceParentheses() ? li[i] + " is balanced" : li[i] + " is not balanced");
        }
        
    }
}
