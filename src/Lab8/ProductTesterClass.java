/*
 * 2. Create a program to read the products from a text file (lab8Q2.txt). The product consists of PID, SID, price and quantity. Sort the product by price followed by PID in ascending order using quick sort.   
Example output:

Reading data from product text file
P003 : S020 : 30.45 : 43
P006 : S022 : 10.45 : 22
P001 : S020 : 20.15 : 50
P013 : S018 : 42.50 : 13
P024 : S023 : 20.15 : 230
P004 : S020 : 42.50 : 21
P009 : S012 : 20.15 : 13
After Quick Sort (Price, PID) : 
P006 : S022 : 10.45 : 22
P001 : S020 : 20.15 : 50
P009 : S012 : 20.15 : 13
P024 : S023 : 20.15 : 230
P003 : S020 : 30.45 : 43
P004 : S020 : 42.50 : 21
P013 : S018 : 42.50 : 13

 */
package Lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTesterClass {
    public static void main(String[] args) {
        
        File f = new File("C:/Users/User/Documents/NetBeansProjects/WIA1002/src/Lab8/Files/Lab 8 Data File.txt");
        List<Product> productList = new ArrayList<>();
        
        try{
            System.out.println("Reading data from product text file");
            Scanner s = new Scanner(new FileInputStream(f));
            
            while(s.hasNextLine()){
                String[] tmp = s.nextLine().split(", ");
                Product p = new Product(tmp[0], tmp[1], Double.valueOf(tmp[2]), Integer.valueOf(tmp[3]));
                productList.add(p);
            }
            
            s.close();
        } catch(FileNotFoundException fnf){
            System.err.println("File not found!");
        }
        
        ProductQuickSort sorter = new ProductQuickSort(productList);
        
        System.out.println("After Quick Sort (Price, PID) : ");
        
        sorter.quickSort();
        sorter.showList();
    }
}

