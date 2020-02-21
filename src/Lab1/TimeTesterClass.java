/*
 * 1. Create a class Time that represents time of the day. The class consists of attributes for the hour and minute. The hour value ranges from 0 to 23 and the minute value ranges from 0 to 59. The class consists of constructor that initializes the time and hour. The class also consists of a method to check whether the time is valid and a method to display the time in hh:mm AM or hh:mm PM. Create a Tester class to test the program, given output below.

Hour: 13 Minute: 45 1:45 PM
Hour: 33 Minute: 15 Invalid time input
Hour: 10 Minute: 52 10:52 AM
 */
package Lab1;

public class TimeTesterClass {
    public static void main(String[] args) {
        
        Time t1 = new Time(13, 45);
        Time t2 = new Time(33, 15);
        Time t3 = new Time(10, 52);
        
    }
}
