/*
 * 3. Write a recursive method writeLine that prints a character repeatedly to form a line of characters. 
Example, writeLine(‘$’, 3) produce 

$$$

Then, Write a recursive method writeBlock that prints m lines of n characters each. 
Example, writeBlock(‘$’, 3, 2) produce:  

$$$
$$$
 */
package T3;

public class WriteRecursive {
    public static void main(String[] args) {
        System.out.println("Write Line");
        System.out.println(writeLine('$', 3));
        
        System.out.println("Write Block");
        System.out.println(writeBlock('$', 3, 2));
        
        System.out.println("Block of stars");
        System.out.println(writeBlock('*', 10, 5));
    }
    
    public static String writeLine(char c, int w){
        if(w == 0) return "\n";
        return c + writeLine(c, w-1);
    }
    
    public static String writeBlock(char c, int w, int h){
        if(h == 0) return "";
        return writeLine(c, w) + writeBlock(c, w, h-1);
    }
    
}
