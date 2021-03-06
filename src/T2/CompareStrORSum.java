/*
 * 1. Create a generic method that accepts two parameters. The method will display the sum of the parameters if the parameters are integer and double. The method will compare whether the parameters are equal if the parameters are String. (Assume that both parameters are from the same type). Example, output.

The parameters value are : Hello and World
The string is not equal
The parameters value are : 12.4 and 64.3
The sum of the double is 76.7
The parameters value are : 20 and 35
The sum of  the integer is 55
The parameters value are : Welcome and Welcome
The string is equal

 */
package T2;

class CompareStrORSumTester {

    public static void main(String[] args) {

        CompareStrORSum<String> a = new CompareStrORSum<>("Hello", "World");
        CompareStrORSum<Double> b = new CompareStrORSum<>(12.4, 64.3);

        // Object as the type is possible
        CompareStrORSum<Object> c = new CompareStrORSum<>(20, 35);
        CompareStrORSum<Object> d = new CompareStrORSum<>("Welcome", "Welcome");
    }
}

public class CompareStrORSum<T> {

    private T ob1, ob2;

    public CompareStrORSum(T ob1, T ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
        System.out.println(toString());

        if (ob1 instanceof String) {
            
            if (ob1.equals(ob2)) {
                System.out.println("The string is equal.");
            } else {
                System.out.println("The string is not equal.");
            }
            
        } else if (ob1 instanceof Integer) {
            
            System.out.println("The sum of the integer is " + ((Integer) ob1 + (Integer) ob2));
            
        } else if (ob1 instanceof Double) {
            
            System.out.println("The sum of the double is " + ((Double) ob1 + (Double) ob2));
            
        } else {
            System.out.println("Undefined data type.");
        }
    }
    
    public String toString() {
        return "The parameter value are : " + ob1 + " and " + ob2;
    }
}
