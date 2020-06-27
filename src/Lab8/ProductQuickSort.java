/*
 * 2. Create a program to read the products from a text file (lab8Q2.txt). The product consists of PID, SID, price and quantity. Sort the product by price followed by PID in ascending order using quick sort.
 */
package Lab8;

import java.util.List;

public class ProductQuickSort extends Product{
    
    Product[] p;
    
    public ProductQuickSort(List<Product> pro){
        p = new Product[pro.size()];
        for(int i = 0; i < pro.size(); i++){
            p[i] = pro.get(i);
            System.out.println(p[i].toString());
        }
    }
    
    // Q2 ProductQuickSort
    public void quickSort(){
        quickSort(0, p.length-1);
    }
    
    private void quickSort(int first, int last){
        if(first < last){
            int splitIndex = productSplit(first, last);
            quickSort(first, splitIndex-1);
            quickSort(splitIndex+1, last);
        }
    }
    
    private int productSplit(int first, int last){
        boolean correctSide;
        Product splitValue = p[first];
        
        int index = first;
        first++;
        do{
            correctSide = true;
            while(correctSide){
                if(splitValue.compareTo(p[first]) < 0){
                    correctSide = false;
                }
                else {
                    first++;
                    correctSide = first <= last;
                }
            }
            correctSide = first <= last;
            while(correctSide){
                if(splitValue.compareTo(p[last]) >= 0){
                    correctSide = false;
                }
                else {
                    last--;
                    correctSide = first <= last;
                }
            }
            if(first < last) {
                swap(first, last);
                first++;
                last--;
            }
        } while(first <= last);
        
        swap(index, last);
        return last;
    }
    
    public void swap(int index1, int index2){
        Product tmp = p[index1];
        p[index1] = p[index2];
        p[index2] = tmp;
    }
    
    public void showList(){
        for(int i = 0; i < p.length; i++){
            System.out.println(p[i].toString());
        }
    }
}
