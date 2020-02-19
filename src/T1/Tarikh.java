/*
 * 1. Create a class called Tarikh that includes three instance variables type integer. (day, month, year). Create a constructor that initializes the three instance variables. Create a toString() method that return the date format in "dd/mm/yyyy". Example output:

Day: 5 Month: 11 Year: 2016
Date is : 05/11/2016
 */
package T1;

public class Tarikh {
    
    private int day, month, year;

    public Tarikh(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return "Date is : " + day + "/" + month + "/" + year;
    }

    
    
}
