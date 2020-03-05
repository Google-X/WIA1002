/*
 * EXTRA:
Create a Circle class that uses the Comparable interface. Declare the radius variable and a single parameterized constructor that accepts this variable.  
 */
package Lab2;

public class Circle<T> implements Comparable<Circle>{
    
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public int compareTo(Circle ob) {
        if(r < ob.r) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Max radius: " + r + "\n";
    }
    
}
