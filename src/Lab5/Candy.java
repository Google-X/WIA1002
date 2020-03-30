/*
 * 1. Ahmad randomly selects a number of candy and insert into a candy container in the figure below. The candies are blue, orange, red and yellow in colour. His brother Ali likes to eat the blue ones. Ali takes all the candies one by one from the container and eats the blue ones. Then, he put back the rest of candies in order. Write a program to simulate the process using stack with linked list.

Example Output:
The candies in the container:
 <-- Blue <-- Yellow <-- Yellow <-- Orange <-- Blue <-- Red <-- Orange
Ali takes all the candies one by one from the container and eats the blue ones.
He puts back the rest of the candies in the container.
The candies in the container:
 <-- Yellow <-- Yellow <-- Orange <-- Red <-- Orange

 */
package Lab5;

import java.util.Random;

public class Candy {
    public static void main(String[] args) {
        
        Random r = new Random();
        String[] color = {"Blue", "Orange", "Red", "Yellow"};
        
        Stack<String> cylinder = new Stack<>();
        int loop = 1+r.nextInt(10);
        
        for(int i = 0; i < loop; i++) cylinder.push(color[r.nextInt(color.length)]);
        
        System.out.println("The candies in the container:");
        cylinder.showStack();
        
        // Ali is smart, he takes another cylinder container to stack the not-blue candies
        Stack<String> tmp = new Stack<>();
        
        System.out.println("\nAli takes all the candies one by one from the container and eats the blue ones.");
        while(cylinder.getSize() != 0){
            String candy = cylinder.pop();
            if(!candy.equals("Blue")) tmp.push(candy);
        }
        
        System.out.println("He puts back the rest of the candies in the container.");
        while(tmp.getSize() != 0) cylinder.push(tmp.pop());
        
        System.out.println("The candies in the container:");
        cylinder.showStack();
        System.out.println();
    }
}
