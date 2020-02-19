/*
 * 3. Derive a class MPlan from ISP. The MPlan will charge RM5 per Mbps subscribe and RM0.80 per GB used.
 */
package T1;

public class MPlan extends ISP{

    public MPlan(String planName, int Mbps, int GB) {
        super(planName, Mbps, GB);
        price = (Mbps * 5) + (GB * 0.80);
    }

    public double getPrice() {
        return price;
    }
}
