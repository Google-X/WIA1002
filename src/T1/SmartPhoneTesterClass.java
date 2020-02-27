/*
 * 4. Create a class SmartPhone that implements the comparable interface. The class consists of model name and the price of the model. Create an array for multiple SmartPhone objects. Sort the smartphone in ascending order of the price. Example output:

List of Smart Phone:
iPhone (RM 2400) Samsung (RM 2200) Nokia (RM 1400) LG (RM 1800)
List of Smart Phone in ascending order of the price
Nokia (RM1400) LG (RM 1800) Samsung (RM 2200) iPhone (RM 2400)
 */
package T1;

public class SmartPhoneTesterClass {

    public static void main(String[] args) {

        SmartPhone[] sp = new SmartPhone[4];

        sp[0] = new SmartPhone("iPhone", 2400);
        sp[1] = new SmartPhone("Samsung", 2200);
        sp[2] = new SmartPhone("Nokia", 1400);
        sp[3] = new SmartPhone("LG", 1800);

        System.out.println("List of Smart Phone:");
        for (int i = 0; i < sp.length; i++) {
            System.out.print(sp[i].toString());
        }

        System.out.println("\nList of Smart Phone in ascending order of the price");
        SmartPhone temp;

        for (int pass = 1; pass < sp.length; pass++){
            for (int i = 0; i < sp.length - 1; i++) {
                if (sp[i].compareTo(sp[i+1])) {
                    temp = sp[i];
                    sp[i] = sp[i + 1];
                    sp[i + 1] = temp;
                }
            }
        }
        
        for (int i = 0; i < sp.length; i++) {
            System.out.print(sp[i].toString());
        }
    }
}
