/*
 * 4. Create a banner system that used to print banner using traditional system.out.println. The system consists of a base abstract and a few derived classes. The derived classes are used to print a range of characters example (A-G, H-N, O-T, U-Z). Create a Tester class to test the program; given output below, when the sentence is fsktm. [You can share the classes with other classmates]. 

  ****   **  *  *  *****  *   *    
  *     *    * *     *    ** **    
  ***    *   **      *    * * *    
  *       *  * *     *    *   *    
  *     **   *  *    *    *   *    

 */
package Lab1;

public class BannerA_G extends Banner{

    public BannerA_G() {
    }
    
    public void display1stLine(char c) {
        switch(c){
            case ' ':
                System.out.print("       ");
                break;
            case 'A':
                System.out.print("   *** ");
                break;
            case 'B':
                System.out.print("  **** ");
                break;
            case 'C':
                System.out.print("   ****");
                break;
            case 'D':
                System.out.print("  **** ");
                break;
            case 'E':
                System.out.print("  *****");
                break;
            case 'F':
                System.out.print("  *****");
                break;
            case 'G':
                System.out.print("   ****");
                break;
        }
    }
    
    public void display2ndLine(char c) {
        switch(c){
            case ' ':
                System.out.print("       ");
                break;
            case 'A':
                System.out.print("  *   *");
                break;
            case 'B':
                System.out.print("  *   *");
                break;
            case 'C':
                System.out.print("  *    ");
                break;
            case 'D':
                System.out.print("  *   *");
                break;
            case 'E':
                System.out.print("  *    ");
                break;
            case 'F':
                System.out.print("  *    ");
                break;
            case 'G':
                System.out.print("  *    ");
                break;
        }
    }
    
    public void display3rdLine(char c) {
        switch(c){
            case ' ':
                System.out.print("       ");
                break;
            case 'A':
                System.out.print("  *****");
                break;
            case 'B':
                System.out.print("  **** ");
                break;
            case 'C':
                System.out.print("  *    ");
                break;
            case 'D':
                System.out.print("  *   *");
                break;
            case 'E':
                System.out.print("  **** ");
                break;
            case 'F':
                System.out.print("  **** ");
                break;
            case 'G':
                System.out.print("  * ***");
                break;
        }
    }
    
    public void display4thLine(char c) {
        switch(c){
            case ' ':
                System.out.print("       ");
                break;
            case 'A':
                System.out.print("  *   *");
                break;
            case 'B':
                System.out.print("  *   *");
                break;
            case 'C':
                System.out.print("  *    ");
                break;
            case 'D':
                System.out.print("  *   *");
                break;
            case 'E':
                System.out.print("  *    ");
                break;
            case 'F':
                System.out.print("  *    ");
                break;
            case 'G':
                System.out.print("  *   *");
                break;
        }
    }
    
    public void display5thLine(char c) {
        switch(c){
            case ' ':
                System.out.print("       ");
                break;
            case 'A':
                System.out.print("  *   *");
                break;
            case 'B':
                System.out.print("  **** ");
                break;
            case 'C':
                System.out.print("   ****");
                break;
            case 'D':
                System.out.print("  **** ");
                break;
            case 'E':
                System.out.print("  *****");
                break;
            case 'F':
                System.out.print("  *    ");
                break;
            case 'G':
                System.out.print("   *** ");
                break;
        }
    }
}
