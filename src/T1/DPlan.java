/*
 * 3. Derive a class DPlan from ISP. The DPlan will charge RM10 per Mbps subscribe and RM0.20 per GB used. 
 */
package T1;

public class DPlan extends ISP{

    public DPlan(String planName, int Mbps, int GB) {
        super(planName, Mbps, GB);
        price = (Mbps * 10) + (GB * 0.20);
    }

    public double getPrice() {
        return price;
    }
}
