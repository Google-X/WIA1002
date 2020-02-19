/*
 * 3. Define a class ISP. The class consists of the name of the subscription plan and a method that display the plan. Derive a class DPlan from ISP. The DPlan will charge RM10 per Mbps subscribe and RM0.20 per GB used. Derive a class MPlan from ISP. The MPlan will charge RM5 per Mbps subscribe and RM0.80 per GB used. Display the plan and select the best plan. Example output: 

5Mbps Subscription and 50GB
Plan : DPlanwith price RM: 60.0
Plan : MPlanwith price RM: 65.0
DPlan is cheaper as compared to MPlan

 */
package T1;

public class ISP {
    private String planName;
    private int Mbps, GB;
    protected double price;

    public ISP(String planName, int Mbps, int GB) {
        this.planName = planName;
        this.Mbps = Mbps;
        this.GB = GB;
    }

    public String toString() {
        return Mbps + "Mbps Subscription and " + GB + "GB";
    }
    
    public String planPrice(){
        return "Plan : " + planName + "with price RM: " + price;
    }
    
}
