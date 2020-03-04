/*
 * 3. Output
Linked List Implementation
Player 1 draws 7 times
Green Five :: Blue Reverse :: Pick Colour :: Green Reverse :: Red Nine :: Red Zero :: Red Two ::
Linked List Implementation
Player 2 draws 7 times
Green One :: Blue One :: Yellow Four :: Green Zero :: Green Draw Two :: Pick Colour :: Red Three ::
 */
package Lab2;

//import static Lab2.ADTUno.action;
//import static Lab2.ADTUno.color;
//import static Lab2.ADTUno.colorCard;
import java.util.LinkedList;
import java.util.Random;

public class UNOLinkedList<T> implements ADTUno{

    private LinkedList t;
    private int numOfPlayer;
    private int numOfDraws;
    private Random r = new Random();
    
    public UNOLinkedList(){
        numOfPlayer = 0;
        t = new LinkedList();
    }
    
    public void draw(int N) {
        t = new LinkedList();
        numOfDraws = N;
        numOfPlayer++;
        for(int i = 0; i < N; i++){
            
            String temp = "";
            temp += color[r.nextInt(color.length)];
            
            if(temp.equals("")){
                temp += action[r.nextInt(action.length)];
            } else {
                temp += " " + colorCard[r.nextInt(colorCard.length)];
            }
            
            t.add(temp);
        }
    }
    
    public String toString(){
        
        String temp = String.format("Linked List Implementation\nPlayer %d draws %d times\n", numOfPlayer, numOfDraws);
        String removedSymbol = t.toString().replace("[", "");
        removedSymbol = removedSymbol.replace("]", " :: ");
        removedSymbol = removedSymbol.replaceAll(", ", " :: ");
        temp += removedSymbol;
        
        return temp;
    }
    
}
