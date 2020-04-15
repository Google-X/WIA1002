/*
 * 4. When a share of common stock of some company is sold, the capital gain or loss is obtained by calculating the difference between the share’s selling price and the price originally paid to buy it. This rule is easy to understand for a single share. However, if we sell multiple shares of stock bought over a long period of time, then we must identify the shares actually being sold. A standard accounting principle for identifying which shares of a stock were sold in such a case is to use FIFO – the shares sold are the ones that have been held the longest. For example, we buy 100 shares at RM20 each on day 1, 20 shares at RM24 on day 2, 200 shares at RM36 on day 3, and then sell 150 shares on day 4 at RM30 each. Using FIFO, the capital gain or loss is (100 * (30-20)) + (20 * (30-24)) + (30 * (30-36)) = RM940. Write a program to read the transactions from a text file (lab6Q4.txt), compute the total gain or loss.

Example output:

List of Transactions 
Day 1 : Buy 100 shares at RM 20 -->
Day 2 : Buy 20 shares at RM 24 -->
Day 3 : Buy 200 shares at RM 36 -->
Day 4 : Sell 150 shares at RM 30 -->
Total Gain 940

 */
package Lab6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        
        String[] info = getInfo().split("\n");
        Queue<String> Q = new Queue<>();
        
        for(String i : info) Q.enqueue(i);
        System.out.println("List of Transactions");
        Q.showQueueStock();
        
        getResult(Q);
        
    }
    
    public static String getInfo(){
        String t = "";
        File f = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab6/Files/lab6Q4.txt");
        try{
            Scanner s = new Scanner(new FileInputStream(f));
            while(s.hasNextLine()) t += s.nextLine() + "\n";
            s.close();
        } catch (FileNotFoundException fnf){
            System.err.println("File not found!");
        }   
        return t;   
    }
    
    public static void getResult(Queue<String> Q){
        
        int size = Q.getSize();
        int[] stockNum = new int[size];
        int[] price = new int[size];
        boolean[] sell = new boolean[size];
        
        for(int i = 0; i < size; i++){
            String[] tmp = Q.dequeue().split(" ");
            if(tmp[1].equals("S")) sell[i] = true;
            stockNum[i] = Integer.parseInt(tmp[2]);
            price[i] = Integer.parseInt(tmp[3]);
        }
        
        int total = 0;
        for(int i = 0; i < size; i++){
            if(sell[i]){
                int soldAmt = stockNum[i];
                int soldPrice = price[i];
                for(int j = 0; j < i; j++){
                    if(stockNum[j] <= soldAmt){
                        int tmp = stockNum[j];
                        soldAmt -= stockNum[j];
                        stockNum[j] = 0;
                        total += tmp * (soldPrice - price[j]);
                    } else {
                        stockNum[j] -= soldAmt;
                        total += soldAmt * (soldPrice - price[j]);
                        soldAmt = 0;
                    }
                }
            }
        }
        
        if(total > 0) System.out.println("Total Gain " + total);
        else if(total < 0) System.out.println("Total Loss " + total);
        else System.out.println("No gain / loss");
        
    }
}
