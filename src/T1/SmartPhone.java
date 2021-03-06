/*
 * 4. Create a class SmartPhone that implements the comparable interface. The class consists of model name and the price of the model. Create an array for multiple SmartPhone objects. Sort the smartphone in ascending order of the price. Example output:

List of Smart Phone:
iPhone (RM 2400) Samsung (RM 2200) Nokia (RM 1400) LG (RM 1800)
List of Smart Phone in ascending order of the price
Nokia (RM1400) LG (RM 1800) Samsung (RM 2200) iPhone (RM 2400)
 */
package T1;

public class SmartPhone implements SmartPhoneComparable{
    private String modelName;
    private int price;

    public SmartPhone(String modelName, int price) {
        this.modelName = modelName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    
    @Override
    public boolean compareTo(Object s){
        return price > ((SmartPhone) s).getPrice();
    }
    
    public String toString() {
        return modelName + " (RM " + price + ") ";
    }
}
