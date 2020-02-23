/*
 * 4. Create a banner system that used to print banner using traditional system.out.println. The system consists of a base abstract and a few derived classes. The derived classes are used to print a range of characters example (A-G, H-N, O-T, U-Z). Create a Tester class to test the program; given output below, when the sentence is fsktm. [You can share the classes with other classmates]. 

  ****   **  *  *  *****  *   *    
  *     *    * *     *    ** **    
  ***    *   **      *    * * *    
  *       *  * *     *    *   *    
  *     **   *  *    *    *   *    

 */
package Lab1;

public class BannerH_N extends Banner{
    
    public void display1stLine(char c) {
        switch(c){
            case 'H':
                System.out.print("  *   *");
                break;
            case 'I':
                System.out.print("  *****");
                break;
            case 'J':
                System.out.print("  *****");
                break;
            case 'K':
                System.out.print("  *  * ");
                break;
            case 'L':
                System.out.print("  *    ");
                break;
            case 'M':
                System.out.print("  *   *");
                break;
            case 'N':
                System.out.print("  *   *");
                break;
        }
    }
    
    public void display2ndLine(char c) {
        switch(c){
            case 'H':
                System.out.print("  *   *");
                break;
            case 'I':
                System.out.print("    *  ");
                break;
            case 'J':
                System.out.print("     * ");
                break;
            case 'K':
                System.out.print("  * *  ");
                break;
            case 'L':
                System.out.print("  *    ");
                break;
            case 'M':
                System.out.print("  ** **");
                break;
            case 'N':
                System.out.print("  **  *");
                break;
        }
    }
    
    public void display3rdLine(char c) {
        switch(c){
            case 'H':
                System.out.print("  *****");
                break;
            case 'I':
                System.out.print("    *  ");
                break;
            case 'J':
                System.out.print("     * ");
                break;
            case 'K':
                System.out.print("  **   ");
                break;
            case 'L':
                System.out.print("  *    ");
                break;
            case 'M':
                System.out.print("  * * *");
                break;
            case 'N':
                System.out.print("  * * *");
                break;
        }
    }
    
    public void display4thLine(char c) {
        switch(c){
            case 'H':
                System.out.print("  *   *");
                break;
            case 'I':
                System.out.print("    *  ");
                break;
            case 'J':
                System.out.print("  *  * ");
                break;
            case 'K':
                System.out.print("  * *  ");
                break;
            case 'L':
                System.out.print("  *    ");
                break;
            case 'M':
                System.out.print("  *   *");
                break;
            case 'N':
                System.out.print("  *  **");
                break;
        }
    }
    
    public void display5thLine(char c) {
        switch(c){
            case 'H':
                System.out.print("  *   *");
                break;
            case 'I':
                System.out.print("  *****");
                break;
            case 'J':
                System.out.print("   **  ");
                break;
            case 'K':
                System.out.print("  *  * ");
                break;
            case 'L':
                System.out.print("  *****");
                break;
            case 'M':
                System.out.print("  *   *");
                break;
            case 'N':
                System.out.print("  *   *");
                break;
        }
    }
}
