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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCode {
    public static void main(String[] args) {
        
        String[] info = getInfo().split(" ");
        List<String> arr = new ArrayList<>();
        Queue<String> code = new Queue<>();
        
        for(String i : info){
            if(i.substring(0, 2).equals("P0")){
                if (!arr.contains(i)) {
                    arr.add(i);
                    code.enqueue(i);
                }
            }
        }
        
        Queue<String> P02 = new Queue<>();
        Queue<String> P03 = new Queue<>();
        Queue<String> P04 = new Queue<>();
        Queue<String> P06 = new Queue<>();
        
        for(int i = 0; i < info.length; i++){
            switch(info[i]){
                case "P02":
                    P02.enqueue(info[++i]);
                    break;
                case "P03":
                    P03.enqueue(info[++i]);
                    break;
                case "P04":
                    P04.enqueue(info[++i]);
                    break;
                case "P06":
                    P06.enqueue(info[++i]);
                    break;
                default:
            }
        }
        
        System.out.print("Product Code in Queue : ");
        code.showQueue();
        
        System.out.println("\nList of product by categories");
        System.out.println("Product : " + code.dequeue());
        P03.showQueue();
        
        System.out.println("\nProduct : " + code.dequeue());
        P02.showQueue();
        
        System.out.println("\nProduct : " + code.dequeue());
        P06.showQueue();
        
        System.out.println("\nProduct : " + code.dequeue());
        P04.showQueue();
        
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
