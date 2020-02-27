/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author User
 */
public class PolynomialV2TesterClass {
    public static void main(String[] args) {

        double[] a = {4.0, 2.0, -0.5, -20.0};
        PolynomialV2 p1 = new PolynomialV2(3, a);
        System.out.print("The polynomial is ");
        p1.display();
        p1.calculate(2);
        p1.calculate(-3.5);

    }
}
