/*
 * 2. Create a class that represents a Polynomial. The class is able to compute any polynomial function. Create a Tester class to test the program, given output below. Example Polynomial a = new Polynomial(degree, coefficientInArray).

The polynomial is 4.0x^3 +2.0x^2 -0.5x -20.0
when x = 2.0
4.0x^3 +2.0x^2 -0.5x -20.0 = 19.0
when x = -3.5
4.0x^3 +2.0x^2 -0.5x -20.0 = -165.25
 */
package Lab1;

public class PolynomialTesterClass {
    public static void main(String[] args) {
        
        double[] coefficientInArray = {4.0, 2.0, -0.5, -20.0};
        
        Polynomial a = new Polynomial(3, coefficientInArray);
        a.createPoly();
        System.out.println(a.toString());
        a.calculate(2.0);
        a.calculate(-3.5);
        
    }
}
