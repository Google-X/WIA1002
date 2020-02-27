/*
 * 2. Create a class that represents a Polynomial. The class is able to compute any polynomial function. Create a Tester class to test the program, given output below. Example Polynomial a = new Polynomial(degree, coefficientInArray).

The polynomial is 4.0x^3 +2.0x^2 -0.5x -20.0
when x = 2.0
4.0x^3 +2.0x^3 -0.5x -20.0 = 19.0
when x = -3.5
4.0x^3 +2.0x^3 -0.5x -20.0 = -165.25
 */
package Lab1;

public class PolynomialV2 {
    private int degree;
    private double[] coe;

    public PolynomialV2(int degree, double[] coe) {
        this.degree = degree;
        this.coe = coe;
    }

    public void display() {
        
        int y = degree;
        System.out.print(coe[0] + "x^" + y);
        y--;
        
        for (int x = 1; x < coe.length; x++) {

            if (y > 1) {
                if (coe[x] > 0) System.out.print(" +" + coe[x] + "x^" + y);
                else System.out.print(" " + coe[x] + "x^" + y);
            } else if (y == 1){
                if (coe[x] > 0) System.out.print(" +" + coe[x] + "x");
                else System.out.print(" " + coe[x] + "x");
            } else {
                if (coe[x] > 0) System.out.print(" +" + coe[x]);
                else System.out.print(" " + coe[x]);
            } 

            y--;
        }
    }

    public void calculate(double x) {
        double ttl = 0;
        int y = degree;
        for (int x1 = 0; x1 < coe.length; x1++) {
            ttl += coe[x1] * Math.pow(x, y);
            y--;
        }
        System.out.println("when x = " + x);
        this.display();
        System.out.print(" = " + ttl);
    }
}
