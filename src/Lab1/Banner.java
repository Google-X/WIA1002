/*
 * 4. Create a banner system that used to print banner using traditional system.out.println. The system consists of a base abstract and a few derived classes. The derived classes are used to print a range of characters example (A-G, H-N, O-T, U-Z). Create a Tester class to test the program; given output below, when the sentence is fsktm. [You can share the classes with other classmates]. 

  ****   **  *  *  *****  *   *
  *     *    * *     *    ** **
  ***    *   **      *    * * *
  *       *  * *     *    *   *
  *     **   *  *    *    *   *

 */
package Lab1;

public abstract class Banner {
    
    public abstract void display1stLine(char c);
    public abstract void display2ndLine(char c);
    public abstract void display3rdLine(char c);
    public abstract void display4thLine(char c);
    public abstract void display5thLine(char c);
    
}
