/*
 * 4. Create an exception class. The exception class will throw an exception when the length of a String is greater than 12. Create a try-catch clause to test the exception.
 */
package T3;

import java.util.Scanner;

public class LengthExceededException extends Exception{
    
    public LengthExceededException(int N){
        super(String.format("String.length() exceeds set limit [Limit set: %d]", N));
    }
    
    public LengthExceededException(String s){
        super(s);
    }
    
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        System.out.print("Set a limit for the length of the string: ");
        int limit = s.nextInt();
        s.nextLine();
        
        try{
            System.out.print("Enter a string: ");
            String test = s.nextLine();
            
            if(test.length() > limit) {
                throw new LengthExceededException(limit);
//                throw new LengthExceededException("Exceeded limit");
            }
            else System.out.printf("String length is less than %d.\n", limit);
            
        } catch (LengthExceededException e){
            System.err.println(e.getMessage());
        }
        
        
    }
}
