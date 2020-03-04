/*
 * 3. Output
Array Implementation
Player 1 draws 7 times
Yellow Zero :: Yellow Draw Two :: Green Skip :: Draw Four :: Green Zero :: Yellow Three :: Red Zero ::
Array Implementation
Player 2 draws 7 times
Red Four :: Green Three :: Green Six :: Red Nine :: Yellow Five :: Yellow Four :: Blue Five ::
 */
package Lab2;

//import static Lab2.ADTUno.color;
import java.util.Arrays;
import java.util.Random;

public class UNOArray<T> implements ADTUno{
    
    private T[] t;
    private int numOfPlayer;
    private int index;
    private int maxSize;
    private Random r = new Random();
    
    public UNOArray(int maxSize){
        numOfPlayer = 0;
        this.maxSize = maxSize;
        index = -1;
        t = (T[]) new Object[maxSize];
    }
    
    public void draw(int N) {
        numOfPlayer++;
        for(int i = 0; i < N; i++){
            t[i] = (T) color[r.nextInt(color.length)];
            
            if(t[i].equals("")){
                t[i] = (T) action[r.nextInt(action.length)];
            } else {
                t[i] += String.valueOf(" " + colorCard[r.nextInt(colorCard.length)]);
            }
        }
    }
    
    public String toString(){
        
        String temp = String.format("Array Implementation\nPlayer %d draws %d times\n", numOfPlayer, maxSize);
        String removedSymbol = Arrays.toString(t).replace("[", "");
        removedSymbol = removedSymbol.replace("]", " :: ");
        removedSymbol = removedSymbol.replaceAll(", ", " :: ");
        temp += removedSymbol;
        
        return temp;
    }
    
}
