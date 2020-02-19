/*
 * 3. Define a class ISP. The class consists of the name of the subscription plan and a method that display the plan. Derive a class DPlan from ISP. The DPlan will charge RM10 per Mbps subscribe and RM0.20 per GB used. Derive a class MPlan from ISP. The MPlan will charge RM5 per Mbps subscribe and RM0.80 per GB used. Display the plan and select the best plan. Example output: 

5Mbps Subscription and 50GB
Plan : DPlanwith price RM: 60.0
Plan : MPlanwith price RM: 65.0
DPlan is cheaper as compared to MPlan

 */
package T1;

public class ISPTesterClass {
    public static void main(String[] args) {
        
        DPlan d = new DPlan("DPlan", 5, 50);
        MPlan m = new MPlan("MPlan", 5, 50);
        
        System.out.println(d.toString());
        System.out.println(d.planPrice());
        System.out.println(m.planPrice());
        
        if(d.getPrice() < m.getPrice()){
            System.out.println("DPlan is cheaper as compared to MPlan");
        } else {
            System.out.println("MPlan is cheaper as compared to DPlan");
        }
    }
}
