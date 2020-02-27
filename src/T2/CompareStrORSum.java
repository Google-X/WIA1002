/*
 * 1. Create a generic method that accepts two parameters. The method will display the sum of the parameters if the parameters are integer and double. The method will compare whether the parameters are equal if the parameters are String. (Assume that both parameters are from the same type). Example, output.

The parameters value are : Hello and World
The string is not equal
The parameters value are : 12.4 and 64.3
The sum of the double is 76.7
The parameters value are : 20 and 35
The sum of  the integer is 55
The parameters calue are : Welcome and Welcome
The string is equal

 */
package T2;

public class CompareStrORSum<T, U> {
    private T t;
    private U u;

    public CompareStrORSum(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setU(U u) {
        this.u = u;
    }

    public T getT() {
        return t;
    }

    public U getU() {
        return u;
    }
    
}

class Tester{
    public static void main(String[] args) {
        CompareStrORSum<String, String> a = new CompareStrORSum<>("Hello", "World");
    }
}