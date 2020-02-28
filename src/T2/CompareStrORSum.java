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

class Tester{
    public static void main(String[] args) {
        
        CompareStrORSum<String, String> a = new CompareStrORSum<>("Hello", "World");
        CompareStrORSum<Double, Double> b = new CompareStrORSum<>(12.4, 64.3);
        
        // Object as the type is possible
        CompareStrORSum<Object, Object> c = new CompareStrORSum<>(20, 35);
        CompareStrORSum<Object, Object> d = new CompareStrORSum<>("Welcome", "Welcome");
    }
}

public class CompareStrORSum<T, U> {
    private T t;
    private U u;
    
    public CompareStrORSum(T t, U u) {
        this.t = t;
        this.u = u;
        
        if(checkDataType()){
            switch (t.getClass().getSimpleName()) {
                case "String":
                    System.out.println(toString());
                    checkSpelling();
                    break;
                case "Integer":
                    System.out.println(toString());
                    addInt();
                    break;
                case "Double":
                    System.out.println(toString());
                    addDouble();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Different type of data.");
        }
    }
    
    public boolean checkDataType(){
        return t.getClass().getSimpleName().equals(u.getClass().getSimpleName());
    }
    
    public void checkSpelling(){
        if(t.equals(u)) System.out.println("The string is equal.");
        else System.out.println("The string is not equal.");
    }
    
    public void addInt(){
        System.out.print("The sum of the " + t.getClass().getSimpleName().toLowerCase() + " is ");
        System.out.println( (T)(Integer)((Integer) t + (Integer) u));
    }
    
    public void addDouble(){
        System.out.print("The sum of the " + t.getClass().getSimpleName().toLowerCase() + " is ");
        System.out.println( (T)(Double)((Double) t + (Double) u));
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

    public String toString() {
        return "The parameter value are : " + t + " and " + u;
    }   
}