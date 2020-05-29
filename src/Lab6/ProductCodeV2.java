/*
 * 2. Create a program to read data from a text file (lab6Q2.txt) and then categorize the product into different queues based on the product code. The number of queue is variable and is determined by reading the data from the text file.

Contents of Text File:
P03 Durian P02 iPhone P06 Buku P02 Samsung P04 Baju P03 Tembikai 
P03 Mangga P06 Pembaris P02 Nokia P06 Kertas P04 Kasut P03 Rambutan

Example output:

Product Code in Queue : P03 --> P02 --> P06 --> P04 -->
List of product by categories
Product : P03
Durian --> Tembikai --> Mangga --> Rambutan
Product : P02
iPhone --> Samsung --> Nokia
Product : P06
Buku --> Pembaris --> Kertas
Product : P04
Baju --> Kasut

 */
package Lab6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

// USING HASHMAP
public class ProductCodeV2 {
    
    public static void main(String[] args) {
        
        // String as key, Queue as value (key = String, value = Queue)
        HashMap<String, Queue<String>> allQueues = new HashMap<>();
        Queue<String> code = new Queue<>();
        
        String[] items = getInfo().split(" ");
        
        for(int i = 0; i < items.length; i+=2){
            
            String productCode = items[i];
            String product = items[i+1];
            
            // If the hashmap contain the key that is same as the current productCode, hashmap will get the queue using the key
            if(allQueues.containsKey(productCode)) allQueues.get(productCode).enqueue(product);
            
            // If discovered a new key, create a new Queue for the new productCode, enqueue the product before putting the new key to the hashmap
            else {
                code.enqueue(productCode);
                Queue<String> newProductQueue = new Queue<>();
                newProductQueue.enqueue(product);
                allQueues.put(productCode, newProductQueue);
            }
            
        }
        
        System.out.print("Product Code in Queue : ");
        code.showQueue();
        
        System.out.println("\nList of product by categories");
        
        Set<String> key = allQueues.keySet();
        for(String k : key){
            System.out.println("Product : " + k);
            allQueues.get(k).showQueue();
            System.out.println();
        }
    }
    
    public static String getInfo(){
        String re = "";
        File f = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab6/Files/lab6Q2.txt");
        
        try{
            Scanner s = new Scanner(new FileInputStream(f));
            while(s.hasNextLine()) re += s.nextLine() + " ";
            s.close();
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found!");
        }
        
        return re;
    }
}