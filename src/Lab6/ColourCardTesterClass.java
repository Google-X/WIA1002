/*
 * 3. Colour Card is a new type of card that consists of 4 different colour (Blue, Green, Red, Yellow) from one to ten. The total number of card is 40. Create a program that simulate the two players Colour Card game where each player will draw 5 cards from the deck in sequence and then compare the cards in sequence with each other. The card with the higher number is the bigger card and if the card is the same number, the Blue colour is the bigger followed by Green, Red, Yellow. Create the ColourCard class and then use different queues for different players.

Example output:
Player 1 Card
Six Blue --> Two Green --> Nine Yellow --> One Green --> Four Red --> 

Player 2 Card
Seven Blue --> Nine Blue --> Nine Red --> Four Blue --> Two Yellow -->

Player 1 Score: 1
PLayer 2 Score: 4
Player 2 WINS!
 */
package Lab6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.Random;

public class ColourCardTesterClass {
    
    public static void main(String[] args) {
        
        String number[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven" ,"Eight", "Nine", "Ten"};
        String colour[] = {"Blue", "Green", "Red", "Yellow"};
        String deck[] = new String[colour.length * number.length];
        
        int j = 0;
        for(String c : colour) for(String n : number) deck[j++] = n + " " + c;
//        shuffle(deck); // <-- Obsolete method
//        Collections.shuffle(Arrays.asList(deck)); // <--  Easier shuffle method for array
        List<String> finalDeck = Arrays.asList(deck);
        Collections.shuffle(finalDeck);
        
        final int numberOfCardEachPlayerDraws = 5;
        
        Queue<ColourCard> player1 = new Queue();
        Queue<ColourCard> player2 = new Queue();
        
        for(int i = 0; i < numberOfCardEachPlayerDraws*2; i++){
            String[] draw = finalDeck.get(i).split(" ");
            ColourCard card = new ColourCard(draw[0], draw[1]);
            if(i % 2 == 0) player1.enqueue(card);
            else player2.enqueue(card);
        }
        
        System.out.println("Player 1 Card");
        player1.showQueue();
        
        System.out.println("\n\nPlayer 2 Card");
        player2.showQueue();

        int p1score = 0;
        int p2score = 0;
        
        while(!player1.isEmpty()){
            // return true if player 1 card > player 2 card
            if(player1.dequeue().compareTo(player2.dequeue())) p1score++;
            else p2score++;
        }
        
        System.out.println("\n\nPlayer 1 Score: " + p1score);
        System.out.println("Player 2 Score: " + p2score);
        
        if(p1score > p2score) System.out.println("Player 1 WINS!");
        else if(p2score > p1score) System.out.println("Player 2 WINS!");
        else if(p1score == p2score) System.out.println("It's a tie!");
        
    }
    
    /* EASIER SHUFFLE METHOD ABOVE USING COLLECTION
    public static void shuffle(String[] deck){
        Random r = new Random();
        for(int i = 0; i < deck.length; i++){
            int randInt = r.nextInt(deck.length);
            String tmp = deck[i];
            deck[i] = deck[randInt];
            deck[randInt] = tmp;
        }
    }
    */
    
//        compare(p1, p2);
    // OBSOLETE compare() method
    /*
    public void compare(Queue p1, Queue p2){
        int cardNum = p1.getSize();
        for(int i = 0; i < cardNum; i++){
            String[] p1c = String.valueOf(p1.dequeue()).split(" ");
            String[] p2c = String.valueOf(p2.dequeue()).split(" ");
            
            if(p1c[1].charAt(0) < p2c[1].charAt(0)) p1score++;
            else if(p2c[1].charAt(0) < p1c[1].charAt(0)) p2score++;
            else if(p1c[1].charAt(0) == p2c[1].charAt(0)){
                int p1num = getNumber(p1c[0]);
                int p2num = getNumber(p2c[0]);
                if(p1num > p2num) p1score++;
                else p2score++;
            }
        }
    }
    */
}
