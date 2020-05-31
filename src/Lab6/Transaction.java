/*
 * 1. Write a program to read the transactions input from a string into a queue. Given D is deposit and W is withdraw. After that, show the balance for each transaction, given the initial balance is 500. Display error if the user withdraws more than the balance.   

Example output:
Enter transactions : D 400 | W 300 | W 700 | D 200 | D 450 | W 120
D 400 --> W 300 --> W 700 --> D 200 --> D 450 --> W 120
Initial Balance : 500
Deposit 400             New Balance 900
Withdraw 300            New Balance 600
Withdraw 700 Rejected   New Balance 600
Deposit 200             New Balance 800
Deposit 450             New Balance 1250
Withdraw 120            New Balance 1130

 */
package Lab6;

import java.util.Scanner;

public class Transaction {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter transactions : ");
        String transaction = s.nextLine().replaceAll("\\s+", "");
        String[] t = transaction.split("\\|");
        
        Queue<String> Q = new Queue<>();
        for(String st : t) Q.enqueue(st);
        Q.showQueue();
        
        int bal = 500;
        System.out.println("\nInitial Balance : " + bal);
        
        int Qsize = Q.getSize();
        
        for(int i = 0; i < Qsize; i++){
            String tmp = Q.dequeue();
            int val = Integer.parseInt(tmp.substring(1));
            
            if(tmp.charAt(0) == 'D'){
                bal += val;
                System.out.printf("Deposit %d\t\tNew Balance %d\n", val, bal);
            } else if (tmp.charAt(0) == 'W'){
                if(bal - val < 0){
                    System.out.printf("Withdraw %d Rejected\tNew Balance %d\n", val, bal);
                } else {
                    bal -= val;
                    System.out.printf("Withdraw %d \t\tNew Balance %d\n", val, bal);
                }
            }
        }
    }
}
