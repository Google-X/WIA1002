/*
 * EXTRA:
5. Create a class called FindMax that contains the following: 

In your main program, create 3 different objects of type array 
(a) for integers that stores the following values, 1,2,3; 
(b) a list of string that stores red, green, blue and 
(c) a circle object of radius 3, 2.9 and 5.9. Invoke the max method as below: 

public static <E extends Comparable<E>> E max(E[] list) 
  
The max method above returns the maximum value in an array.  
 */
package Lab2;

public class CircleFindMax {
    public static void main(String[] args) {
        
        Integer[] val = {1, 2, 3};
        String[] color = {"red", "green", "blue"};
        Circle[] c = {new Circle(3), new Circle(2.9), new Circle(5.9)};
        
        System.out.printf("Max value: %d\nColor: %s\n%s", max(val), max(color), max(c).toString());
        
    }
    
    public static <E extends Comparable<E>> E max(E[] list) {
        
        E max = list[0];
        
        for(int i = 1; i < list.length; i++){
            if(max.compareTo(list[i]) < 0){
                max = list[i];
            }
        }
        
        return max;
    }
}
