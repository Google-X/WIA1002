/*
 * 1. Create a class Time that represents time of the day. The class consists of attributes for the hour and minute. The hour value ranges from 0 to 23 and the minute value ranges from 0 to 59. The class consists of constructor that initializes the time and hour. The class also consists of a method to check whether the time is valid and a method to display the time in hh:mm AM or hh:mm PM. Create a Tester class to test the program, given output below.

Hour: 13 Minute: 45 1:45 PM
Hour: 33 Minute: 15 Invalid time input
Hour: 10 Minute: 52 10:52 AM
 */
package Lab1;

public class Time {
    private int h, m, finalH, finalM;
    private String time;

    public Time(int h, int m) {
        this.h = h;
        this.m = m;
        finalM = m;
        
        if(checkValid()){
            if(h >= 12){
                time = "PM";
                if(h > 12) finalH = h - 12;
                else finalH = h;
            }
            else {
                time = "AM";
                finalH = h;
            }
            System.out.println(toStringValid());
        } else {
            System.out.println(toStringInvalid());
        }
    }
    
    public boolean checkValid(){
        return !(h >= 24 || h < 0 || m >= 60 || m < 0);
    }

    public String toStringValid() {
        return String.format("Hour: %d Minute: %d %d:%02d %s", h, m, finalH, finalM, time);
    }
    
    public String toStringInvalid() {
        return String.format("Hour: %d Minute: %d Invalid time input", h, m);
    }   
}
