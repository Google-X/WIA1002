/*
 * 4. Create a StarList Game. Each player will take turns to roll a dice. The first players that reach more than 20 stars in the lists win the game.  
Example output:

Player 2 start first
Player 2: * --> * -->
Player 1: * --> * --> * --> * -->
Player 2: * --> * --> * --> * --> * -->
Player 1: * --> * --> * --> * --> * --> * --> * -->
Player 2: * --> * --> * --> * --> * --> * --> * -->
Player 1: * --> * --> * --> * --> * --> * --> * --> * --> * --> * -->
...
...
...
Player 1 wins the game
 */
package Lab4;

import java.util.Random;

public class StarList {
    
    static Random r = new Random();
    public static void main(String[] args) {
        if(1+r.nextInt(2) == 1) play("Player 1", "Player 2");
        else play("Player 2", "Player 1");
    }
    
    public static void play(String p1, String p2){
        LinkedList<Character> a = new LinkedList<>();
        LinkedList<Character> b = new LinkedList<>();
        
        boolean win = false;
        System.out.println(p1 + " starts first.");
        int rolls;
        
        while(true){
            
        // Player A
            rolls = 1 + r.nextInt(6);
            for(int i=0;i<rolls;i++) a.addLastNode('*');
            System.out.print(p1 + ": ");
            a.showList();
            System.out.println();
            if(a.length() > 20){
                System.out.println(p1 + " wins the game");
                break;
            }
            
        // Player B
            rolls = 1 + r.nextInt(6);
            for(int i=0;i<rolls;i++) b.addLastNode('*');
            System.out.print(p2 + ": ");
            b.showList();
            System.out.println();
            if(b.length() > 20){
                System.out.println(p2 + " wins the game");
                break;
            }
        }
    }
}
