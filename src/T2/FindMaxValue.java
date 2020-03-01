/*
 * 3. Create a generic static method called maximum which consists of three parameters that used to get the maximum of the three values. The generic type extends the Comparable interface. Example output: 

The maximum value of 42 15 58 is 58
The maximum value of 12.45 41.28 19.82 is 41.28
 */
package T2;

class FindMaxValue{
    public static void main(String[] args) {
        
        int[] arr = {42, 15, 58};
        double[] arrDouble = {12.45, 41.28, 19.82};
        
        System.out.printf("The maximum value of %d %d %d is %d\n", arr[0], arr[1], arr[2], findMax(arr[0], arr[1], arr[2]));
        System.out.printf("The maximum value of %.2f %.2f %.2f is %.2f\n", arrDouble[0], arrDouble[1], arrDouble[2], findMax(arrDouble[0], arrDouble[1], arrDouble[2]));
        
    }
    
    public static <T extends Comparable<T>> T findMax(T ob1, T ob2, T ob3){
    
        T max = ob1;
        
        if(ob2.compareTo(max) > 0){
            max = ob2;
        } else if (ob3.compareTo(max) > 0){
            max = ob3;
        }
        
        return max;
    }
    
    public static <T> String arrayToStr(T[] arr){
        String finalStr = "";
        
        for(T e : arr){
            finalStr += e + " ";
        }
        
        return finalStr;
    }
}

