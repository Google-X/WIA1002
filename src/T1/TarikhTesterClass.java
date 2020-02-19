/*
 * 1. Create a class called Tarikh that includes three instance variables type integer. (day, month, year). Create a constructor that initializes the three instance variables. Create a toString() method that return the date format in "dd/mm/yyyy". Example output:

Day: 5 Month: 11 Year: 2016
Date is : 05/11/2016
 */
package T1;

import java.util.Scanner;

public class TarikhTesterClass {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Day: ");
        int day = s.nextInt();
        System.out.print("Month: ");
        int month = s.nextInt();
        System.out.print("Year: ");
        int year = s.nextInt();
        
        Tarikh t = new Tarikh(day, month, year);
        
        System.out.println(t.toString());
    }
}
