/*
 * 3. Write a program to reverse a sentence and reverse the words in a sentence. You can use the stack implementation with linked list. 

Example output: 
Enter a sentence : Software-defined networking (SDN) technology is an approach to network management
Original sentence : Software-defined networking (SDN) technology is an approach to network management
The sentence in reverse order : tnemeganam...
The word in reverse order : management network...

 */
package T5;

import java.util.Scanner;

public class reverseStack {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a sentence : ");
        String[] strArr = s.nextLine().split(" ");
        
        Stack<String> ori = new Stack<>();
        for(int i=strArr.length-1;i>=0;i--) ori.push(strArr[i]);
        
        System.out.print("Original sentence : ");
        ori.showStackReverse();

        System.out.print("\nThe sentence in reverse order : ");
        Stack<String> reverseSentenceStack = reverseSentence(strArr);
        reverseSentenceStack.showStackReverse();
        
        System.out.print("\nThe word in reverse order : ");
        Stack<String> reverseWordStack = reverseWord(strArr);
        reverseWordStack.showStackReverse();
        
    }
    
    public static Stack reverseWord(String[] arr){
        Stack<String> ret = new Stack<>();
        for(String str : arr) ret.push(str);
        return ret;
    }
    
    public static Stack reverseSentence(String[] arr){
        Stack<String> ret = new Stack<>();
        for(String str : arr){
            String concat = "";
            char[] chList = str.toCharArray();
            for(int i=chList.length-1;i>=0;i--) concat += chList[i];
            ret.push(concat);
        }
        return ret;
    }
}
