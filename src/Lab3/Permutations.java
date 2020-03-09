/*
 * 3. Define a recursive method that displays all n! Permutations of an integer array elements. The main method will accept the number of elements from user and generate the random number within 0 and 9 for the elements of the array. Example output

Enter number of elements: 3 
The elements of the array: 436 
436 
463 
346 
364 
634 
643

Modify the program above to display the non-duplicate integer. Example output 
Enter number of elements: 4 
The elements of the array: 5520 
5520
5502
5250
5205
5025
5052
2550
2505
2055
525
552
255
 */
package Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {

    private static List<Object> list = new ArrayList<Object>();
    private static List<Object> nonDuplicatedNumList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
//        Definitely got other way of doing. will update soon.
//        System.out.print("Enter number of elements: ");
//        int numOfEle = s.nextInt();
        
        System.out.print("The elements of the array: ");
        Object test = s.nextLine();

        permutations(String.valueOf(test).toCharArray(), 0);
        
        boolean duplicate = checkDuplicate(test);
        
        if(duplicate){
            removeDuplicate();
            for(Object ele : nonDuplicatedNumList) System.out.println(ele);
        } else {
            for(Object ele : list) System.out.println(ele);
        }
        
    }

    private static void permutations(char[] ch, int currentIndex) {
        
        try{
            if (currentIndex == ch.length - 1) {
                list.add(Integer.parseInt(String.valueOf(ch)));
            }
            
        } catch (NumberFormatException nde){
            list.add(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    private static boolean checkDuplicate(Object a){
        char[] arr = String.valueOf(a).toCharArray();
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1]) return true;
        }
        
        return false;
    }
    
    private static void removeDuplicate(){
        for(Object a : list){
            if(!nonDuplicatedNumList.contains(a)) nonDuplicatedNumList.add(a);
        }
    }
}
