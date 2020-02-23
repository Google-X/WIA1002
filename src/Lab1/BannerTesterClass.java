/*
 * 4. Create a banner system that used to print banner using traditional system.out.println. The system consists of a base abstract and a few derived classes. The derived classes are used to print a range of characters example (A-G, H-N, O-T, U-Z). Create a Tester class to test the program; given output below, when the sentence is fsktm. [You can share the classes with other classmates]. 

  ****   **  *  *  *****  *   *
  *     *    * *     *    ** **
  ***    *   **      *    * * *
  *       *  * *     *    *   *
  *     **   *  *    *    *   *

 */
package Lab1;

import java.util.Scanner;

public class BannerTesterClass {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        String word = s.nextLine().toUpperCase();
        
        BannerA_G AG = new BannerA_G();
        BannerH_N HN = new BannerH_N();
        BannerO_T OT = new BannerO_T();
        BannerU_Z UZ = new BannerU_Z();
        
//        if(word.charAt(i) >= 'A' && word.charAt(i) <= 'G'){
//            BannerA_G AG = new BannerA_G();
//        } else if(word.charAt(i) >= 'H' && word.charAt(i) <= 'N'){
//            BannerH_N HN = new BannerH_N();
//        } else if(word.charAt(i) >= 'O' && word.charAt(i) <= 'T'){
//            BannerO_T OT = new BannerO_T();
//        } else if(word.charAt(i) >= 'U' && word.charAt(i) <= 'Z'){
//            BannerU_Z UZ = new BannerU_Z();
//        } 
        
//            AG.display1stLine(word.charAt(i));
//            HN.display1stLine(word.charAt(i));
//            OT.display1stLine(word.charAt(i));
//            UZ.display1stLine(word.charAt(i));
//            System.out.println();
//            
//            AG.display2ndLine(word.charAt(i));
//            HN.display2ndLine(word.charAt(i));
//            OT.display2ndLine(word.charAt(i));
//            UZ.display2ndLine(word.charAt(i));
//            System.out.println();
//            
//            AG.display3rdLine(word.charAt(i));
//            HN.display3rdLine(word.charAt(i));
//            OT.display3rdLine(word.charAt(i));
//            UZ.display3rdLine(word.charAt(i));
//            System.out.println();
//            
//            AG.display4thLine(word.charAt(i));
//            HN.display4thLine(word.charAt(i));
//            OT.display4thLine(word.charAt(i));
//            UZ.display4thLine(word.charAt(i));
//            System.out.println();
//            
//            AG.display5thLine(word.charAt(i));
//            HN.display5thLine(word.charAt(i));
//            OT.display5thLine(word.charAt(i));
//            UZ.display5thLine(word.charAt(i));
//            System.out.println();
        
        // 1st line
        for(int i = 0; i < word.length(); i++){
                AG.display1stLine(word.charAt(i));
                HN.display1stLine(word.charAt(i));
                OT.display1stLine(word.charAt(i));
                UZ.display1stLine(word.charAt(i));
            if(i == word.length() - 1){
                System.out.println();
            }
        }
        
        // 2nd line
        for(int i = 0; i < word.length(); i++){
                AG.display2ndLine(word.charAt(i));
                HN.display2ndLine(word.charAt(i));
                OT.display2ndLine(word.charAt(i));
                UZ.display2ndLine(word.charAt(i));
            if(i == word.length() - 1){
                System.out.println();
            }
        }
        
        // 3rd line
        for(int i = 0; i < word.length(); i++){
                AG.display3rdLine(word.charAt(i));
                HN.display3rdLine(word.charAt(i));
                OT.display3rdLine(word.charAt(i));
                UZ.display3rdLine(word.charAt(i));
            if(i == word.length() - 1){
                System.out.println();
            }
        }
        
        // 4th line
        for(int i = 0; i < word.length(); i++){
                AG.display4thLine(word.charAt(i));
                HN.display4thLine(word.charAt(i));
                OT.display4thLine(word.charAt(i));
                UZ.display4thLine(word.charAt(i));
            if(i == word.length() - 1){
                System.out.println();
            }
        }
        
        // 5th line
        for(int i = 0; i < word.length(); i++){
                AG.display5thLine(word.charAt(i));
                HN.display5thLine(word.charAt(i));
                OT.display5thLine(word.charAt(i));
                UZ.display5thLine(word.charAt(i));
            if(i == word.length() - 1){
                System.out.println();
            }
        }
        
    }
}
