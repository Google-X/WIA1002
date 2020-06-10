package T9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchTest<T extends Comparable<T>> {

    private boolean ASCENDING;
    private int size;
    private T[] value;
    private int MaxValue;
    private final int line = 10;
    private final int MAXCHAR = 26;
    private Random r = new Random();

    public void setAscending(boolean ascending){
        ASCENDING = ascending;
    }
    
    public SearchTest(T t, int size, int Max) {
        this.size = size;
        value = (T[]) new Comparable[size];
        char c;
        
        if (t instanceof Number || t instanceof String) this.MaxValue = Max;
        
        for (int i = 0; i < value.length; i++) {
            if (t instanceof Integer) {
                value[i] = (T) ((Integer) r.nextInt(MaxValue));
            } 
            else if (t instanceof Double) {
                value[i] = (T) ((Double) (0.01 * r.nextInt(MaxValue*100)));
            } 
            else if (t instanceof Character){
                if(Character.isUpperCase((Character)t)) c = (char)('A' + r.nextInt(MAXCHAR));
                else c = (char)('a' + r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            } 
            else if (t instanceof String){
                String tmp = "";
                if(Character.isUpperCase((Character)((String) t).charAt(0))){
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('A' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                else {
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('a' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                value[i] = (T) tmp;
            } else {
                System.out.println("Will update soon.");
            }
        }
    }
    
    public SearchTest(T t, int size, int Max, boolean asccending) {
        this.size = size;
        ASCENDING = asccending;
        value = (T[]) new Comparable[size];
        char c;
        
        if (t instanceof Number || t instanceof String) this.MaxValue = Max;
        
        for (int i = 0; i < value.length; i++) {
            if (t instanceof Integer) {
                value[i] = (T) ((Integer) r.nextInt(MaxValue));
            } 
            else if (t instanceof Double) {
                value[i] = (T) ((Double) (0.01 * r.nextInt(MaxValue*100)));
            } 
            else if (t instanceof Character){
                if(Character.isUpperCase((Character)t)) c = (char)('A' + r.nextInt(MAXCHAR));
                else c = (char)('a' + r.nextInt(MAXCHAR));
                value[i] = (T) ((Character) c);
            } 
            else if (t instanceof String){
                String tmp = "";
                if(Character.isUpperCase((Character)((String) t).charAt(0))){
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('A' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                else {
                    for(int j = 0; j < this.MaxValue; j++){
                        c = (char)('a' + r.nextInt(MAXCHAR));
                        tmp += c;
                    }
                }
                value[i] = (T) tmp;
            } else {
                System.out.println("Will update soon.");
            }
        }
    }

    public void showValue() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
            if ((i + 1) % line == 0) {
                System.out.println();
            }
        }
    }

    public T getElement(int index) {
        return value[index];
    }
    
    // Q1 Methods
    public boolean linearSearch(T t){
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public int linearSearchCount(T t) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                count++;
            }
        }
        return count;
    }
    
    public int[] getLinearSearchIndex(T t){
        int size = linearSearchCount(t);
        if(size == 0) return null;
        int[] re = new int[size];
        for (int i = 0, j = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                re[j] = i;
                j++;
            }
        }
        return re;
    }
    
    public boolean linearSearchBetween(T t1, T t2){
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                return true;
            }
        }
        return false;
    }
    
    public int linearSearchCountBetween(T t1, T t2) {
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                count++;
            }
        }
        return count;
    }
    
    public int[] getLinearSearchIndexBetween(T t1, T t2){
        int size = linearSearchCountBetween(t1, t2);
        if(size == 0) return null;
        int[] re = new int[size];
        for (int i = 0, j = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                re[j] = i;
                j++;
            }
        }
        return re;
    }

    /* Better way for Q1 LinearSearch using List & ArrayList
    public List getLinearSearchIndexList(T t){
        List<Integer> re = new ArrayList<>();
        if(size == 0) return null;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t) == 0) {
                re.add(i);
            }
        }
        return re;
    }
    
    public List getLinearSearchIndexListBetween(T t1, T t2){
        List<Integer> re = new ArrayList<>();
        if(size == 0) return null;
        for (int i = 0; i < value.length; i++) {
            if (value[i].compareTo(t1) >= 0 && value[i].compareTo(t2) <= 0) {
                re.add(i);
            }
        }
        return re;
    }
    */
    
    public int binarySearchCount(T t) {
        int count = 0;
        int index = binarySearchCount(0, value.length, t);
        if (index != -1) {
            for (int i = index; i >= 0 && t.compareTo(value[i]) == 0; i--) {
                count++;
            }
            for (int i = index + 1; i < value.length && t.compareTo(value[i]) == 0; i++) {
                count++;
            }
        }
        return count;
    }

    public int binarySearchCount(int start, int end, T t) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (value[middle].compareTo(t) == 0) {
            return middle;
        } else if ((value[middle].compareTo(t) > 0 && ASCENDING)
                || (value[middle].compareTo(t) < 0 && !ASCENDING)) {
            return binarySearchCount(start, middle - 1, t);
        } else {
            return binarySearchCount(middle + 1, end, t);
        }
    }

    public void selectionSort(boolean ascending) {
        ASCENDING = ascending;
        for (int i = 0; i < value.length - 1; i++) {
            swap(i, getMinIndex(i));
        }
    }

    public void swap(int index1, int index2) {
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }

    public int getMinIndex(int start) {
        T temp = value[start];
        int index = start;
        for (int i = start + 1; i < value.length; i++) {
            if (temp.compareTo(value[i]) > 0 && ASCENDING) {
                index = i;
                temp = value[i];
            } else if (temp.compareTo(value[i]) < 0 && !ASCENDING) {
                index = i;
                temp = value[i];
            }
        }
        return index;
    }

}
