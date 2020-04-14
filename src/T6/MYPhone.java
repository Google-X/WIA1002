/*
 * 3. Write a Program to simulate a queue when purchasing a new MY phone. Given each customer can purchase 1 – 3 sets of MY phone. The number of MY phone available is 30.

Example output at bottom

 */
package T6;

import java.util.Random;

public class MYPhone {
    public static void main(String[] args) {
        
        int MAX = 30;
        Random r = new Random();
        
        Queue<Integer> customer = new Queue<>();
        
        while(MAX > 0){
            int num = 1 + r.nextInt(3);
            if(MAX - num >= 0) {
                customer.enqueue(num);
                MAX -= num;
            }
        }
        
        System.out.println("Simulating a Queue to purchase MY phone");
        customer.showQueueCustomer();
        
    }
}

/*
Simulating a Queue to purchase MY phone
Customer 1 : 1 set(s) --> 
Customer 2 : 2 set(s) --> 
Customer 3 : 2 set(s) --> 
Customer 4 : 3 set(s) --> 
Customer 5 : 1 set(s) --> 
Customer 6 : 2 set(s) --> 
Customer 7 : 2 set(s) --> 
Customer 8 : 1 set(s) --> 
Customer 9 : 1 set(s) --> 
Customer 10 : 3 set(s) --> 
Customer 11 : 3 set(s) --> 
Customer 12 : 1 set(s) --> 
Customer 13 : 3 set(s) --> 
Customer 14 : 2 set(s) --> 
Customer 15 : 2 set(s) --> 
Customer 16 : 1 set(s) -->
Number of customer : 16
*/
