/*
 * 6. Write a program that takes as input a sequence of transactions of the form “buy x share(s) at $y each” or “sell x share(s) at $y each,” assuming that the transactions occur on consecutive days and the value x and y are integers. Given this input sequence, the output should be the total gain or loss for the sequence, using the FIFO protocol to identify shares. 
 */
package Lab6;

import java.util.Random;

public class StockV2 {
    public static void main(String[] args) {
        
        Random r = new Random();
        Queue<String> Q = new Queue<>();
        
        String buy = "buy x share(s) at $y each";
        String sell = "sell x share(s) at $y each";
        
        int day = 3;
        day *= 2;
        int numOfStockBought = 0;
        int x, y;
        
        while(day-- > 0){
            if(day % 2 != 0){
                // Buy
                x = 1 + r.nextInt(100);
                y = 1 + r.nextInt(10);
                numOfStockBought += x;
                String buyTemp = buy.replace("x", String.valueOf(x)).replace("$y", '$'+String.valueOf(y));
                System.out.println(buyTemp);
                Q.enqueue(buyTemp);

            } else {
                // Sell
                x = 1 + r.nextInt(100);
                y = 1 + r.nextInt(10);
                while(x > numOfStockBought){
                    x = 1 + r.nextInt(100);
                }
                
                // Applicable only when the number of stock is less than what you bought unless you are trading in US
                numOfStockBought -= x;
                String sellTemp = sell.replace("x", String.valueOf(x)).replace("$y", '$'+String.valueOf(y));
                System.out.println(sellTemp);
                Q.enqueue(sellTemp);
            }
        }
        
        getResult(Q);
    }
    
    public static void getResult(Queue<String> Q){
        
        int size = Q.getSize();
        int[] stockNum = new int[size];
        int[] price = new int[size];
        boolean[] sell = new boolean[size];
        
        for(int i = 0; i < size; i++){
            String[] tmp = Q.dequeue().split(" ");
            if(tmp[0].equals("sell")) sell[i] = true;
            stockNum[i] = Integer.parseInt(tmp[1]);
            price[i] = Integer.parseInt(tmp[4].replace("$", ""));
        }
        
        int total = 0;
        for(int i = 0; i < size; i++){
            if(sell[i]){
                int soldAmt = stockNum[i];
                int soldPrice = price[i];
                for(int j = 0; j < i; j++){
                    if(soldAmt == 0) break;
                    else {
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
        }
        
        if(total > 0) System.out.println("Total Gain: " + total);
        else if(total < 0) System.out.println("Total Loss: " + total);
        else System.out.println("No gain / loss");
        
    }
}
