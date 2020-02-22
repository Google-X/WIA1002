/*
 * 2. Create a class that represents a Polynomial. The class is able to compute any polynomial function. Create a Tester class to test the program, given output below. Example Polynomial a = new Polynomial(degree, coefficientInArray).

The polynomial is 4.0x^3 +2.0x^2 -0.5x -20.0
when x = 2.0
4.0x^3 +2.0x^3 -0.5x -20.0 = 19.0
when x = -3.5
4.0x^3 +2.0x^3 -0.5x -20.0 = -165.25
 */
package Lab1;

public class Polynomial {
    private int degree;
    private double[] coefficient;
    private String polyStr;

    public Polynomial(int degree, double[] coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }
    
    public void createPoly() {
        String temp = "";
        
        for(int i = coefficient.length, j = 0; i > 2; i--, j++){
            if(coefficient[j] != 0){
                if(temp.equals("")){
                    temp += coefficient[j] + "x^" + (i-1) + " ";
                } else {
                    if(coefficient[j] > 0){
                        temp += "+" + coefficient[j] + "x^" + (i-1) + " ";
                    } else if (coefficient[j] < 0){
                        temp += coefficient[j] + "x^" + (i-1) + " ";
                    }
                }
            }
        }
        
        if(coefficient[coefficient.length - 2] < 0){
            temp = temp + coefficient[coefficient.length - 2] + "x ";
        } else if (coefficient[coefficient.length - 2] > 0){
            temp = temp + "+" + coefficient[coefficient.length - 2] + "x ";
        }
        
        if(coefficient[coefficient.length - 1] < 0){
            polyStr = temp + coefficient[coefficient.length - 1] + " ";
        } else if (coefficient[coefficient.length - 1] > 0){
            polyStr = temp + "+" + coefficient[coefficient.length - 1] + " ";
        } else if (coefficient[coefficient.length - 1] == 0){
            polyStr = temp;
        }
        
    }
    public void calculate(double x){
        System.out.println("when x = " + x);
        System.out.print(polyStr + "= ");
        
        double answer = 0;
        
        for(int i = coefficient.length, j = 0; i > 0; i--, j++){
            answer += coefficient[j] * Math.pow(x, i-1);
        }
        System.out.println(answer);
    }
    
    public String toString(){
        return "The polynomial is " + polyStr;
    }
}
