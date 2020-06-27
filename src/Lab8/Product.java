// 2. Create a program to read the products from a text file (lab8Q2.txt). The product consists of PID, SID, price and quantity. Sort the product by price followed by PID in ascending order using quick sort.
package Lab8;

public class Product implements Comparable<Product>{
    
    private String PID;
    private String SID;
    private double price;
    private int quantity;
    
    public Product(){
        PID = null;
        SID = null;
        price = 0;
        quantity = 0;
    }
    
    public Product(String PID, String SID, double price, int quantity) {
        this.PID = PID;
        this.SID = SID;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    
    public String getPID() {
        return PID;
    }

    public String toString(){
        return String.format("%s : %s : %.2f : %d", PID, SID, price, quantity);
    }

    @Override
    public int compareTo(Product p) {
        if(price <= p.getPrice() && PID.compareTo(p.getPID()) < 0) return -1;
        else return 1;
    }

}
