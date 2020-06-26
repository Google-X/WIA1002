/*
 * 3. Compare the performance of Selection Sort, Bubble Sort, Insertion Sort, Merge Sort, and Quick Sort in the SortTest class using the 1000 sets of 100000 random numbers (Must use the same random set number for each sorting algorithm). Then, sort the sorting algorithms and identify the sorting algorithm with the fastest time.   
Example output:  

Performance Comparison of Sorting Algorithms
Running on 100 sets of 100000 random numbers
Quick Sort : 59605
Selection Sort : 65839
Merge Sort : 88058
Insertion Sort : 164786
Bubble Sort : 208429
The fastest sorting algo is Quick Sort

 */
package Lab8;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class SortTime {

    public static void main(String[] args) {
        
        Random r = new Random();
        SortTest sorter;

        // Initial parameters and setups
        int set = 100;
        int num = 100000;
        String[] methods = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort"};
        HashMap<String, Long> time = new HashMap<>();
        for (String m : methods) time.put(m, 0L);
        
        // Display startup
        System.out.println("Performance Comparison of Sorting Algorithms");
        System.out.println("Running on " + set + " sets of " + num + " random numbers");

        // Set of numbers
        Integer[][] randList = new Integer[set][num];

        // Setting up non duplicated number for better analysis of the soorting method
        for (int i = 0; i < randList.length; i++) {
            for (int j = 0; j < randList[0].length; j++) {
                randList[i][j] = j;
            }
        }

        // Randomly swap the position
        for (int i = 0; i < randList.length; i++) {
            for (int j = 0; j < randList[0].length; j++) {
                int rand = r.nextInt(num);
                int tmp = randList[i][j];
                randList[i][j] = randList[i][rand];
                randList[i][rand] = tmp;
            }
        }

        // Sorting time
        for (int k = 0; k < methods.length; k++) {

            for (int i = 0; i < randList.length; i++) {
                long start;

                switch (k) {
                    // Selection Sort
                    case 0:
                        sorter = new SortTest(randList[i]);
                        start = System.nanoTime();
                        sorter.selectionSort();
                        time.put(methods[k], time.get(methods[k]) + System.nanoTime() - start);
                        break;

                    // Bubble Sort
                    case 1:
                        sorter = new SortTest(randList[i]);
                        start = System.nanoTime();
                        sorter.bubbleSort();
                        time.put(methods[k], time.get(methods[k]) + System.nanoTime() - start);
                        break;

                    // Insertion Sort
                    case 2:
                        sorter = new SortTest(randList[i]);
                        start = System.nanoTime();
                        sorter.insertionSort();
                        time.put(methods[k], time.get(methods[k]) + System.nanoTime() - start);
                        break;

                    // Merge Sort
                    case 3:
                        sorter = new SortTest(randList[i]);
                        start = System.nanoTime();
                        sorter.mergeSort();
                        time.put(methods[k], time.get(methods[k]) + System.nanoTime() - start);
                        break;

                    // Quick Sort
                    case 4:
                        sorter = new SortTest(randList[i]);
                        start = System.nanoTime();
                        sorter.quickSort();
                        time.put(methods[k], time.get(methods[k]) + System.nanoTime()- start);
                        break;

                    default:
                }
            }
        }
        
        // When done average up the duration for each methods
        for (int k = 0; k < methods.length; k++) {
            long average = time.get(methods[k]) / set;
            time.put(methods[k], average);
        }
        
        // Sort the methods in ascending order by its Long value
        // @ https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
        Map<String, Long> sortedTime = sortByValue(time); 
        for (Map.Entry<String, Long> entry : sortedTime.entrySet()) { 
            System.out.println(entry.getKey() +  " : " + entry.getValue()); 
        }
        System.out.println("The fastest sorting algo is " + sortedTime.keySet().iterator().next());
        System.out.println("The fastest sorting algo is " + sortedTime.keySet().toArray()[0]);
    }
    
    // Function to sort hashmap by values 
    public static HashMap<String, Long> sortByValue(HashMap<String, Long> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Long> > list = new LinkedList<Map.Entry<String, Long> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Long> >() { 
            public int compare(Map.Entry<String, Long> o1,  
                               Map.Entry<String, Long> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Long> temp = new LinkedHashMap<String, Long>(); 
        for (Map.Entry<String, Long> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    
}
        /* @ https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html
        System.out.println("HashMap before sorting, random order ");
        Set<Entry<String, Long>> entries = time.entrySet();
       
        for(Entry<String, Long> entry : entries){
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }
        
        // Now let's sort HashMap by keys first 
        // all you need to do is create a TreeMap with mappings of HashMap
        // TreeMap keeps all entries in sorted order
        TreeMap<String, Long> sorted = new TreeMap<>(time);
        Set<Entry<String, Long>> mappings = sorted.entrySet();
        
        System.out.println("HashMap after sorting by keys in ascending order ");
        for(Entry<String, Long> mapping : mappings){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        
        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing 
        // or decreasing by values.
        
        Comparator<Entry<String, Long>> valueComparator = new Comparator<Entry<String,Long>>() {
            
            @Override
            public int compare(Entry<String, Long> e1, Entry<String, Long> e2) {
                Long v1 = e1.getValue();
                Long v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };
        
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<String, Long>> listOfEntries = new ArrayList<Entry<String, Long>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<String, Long> sortedByValue = new LinkedHashMap<String, Long>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<String, Long> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("HashMap after sorting entries by values ");
        Set<Entry<String, Long>> entrySetSortedByValue = sortedByValue.entrySet();
        
        for(Entry<String, Long> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }
        */