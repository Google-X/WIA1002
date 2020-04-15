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

import java.util.Random;

public class ColourCard {
    
    static String number[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven" ,"Eight", "Nine", "Ten"};
    static String colour[] = {"Blue", "Green", "Red", "Yellow"};
    static Random r = new Random();
    static int p1score = 0, p2score = 0;
    
    public static void main(String[] args) {
        
        String deck[] = new String[40];
        shuffle(deck);
        
        Queue<String> QDeck = new Queue<>();
        for(String card : deck) QDeck.enqueue(card);
        
        Queue<String> p1 = new Queue<>();
        Queue<String> p2 = new Queue<>();
        
        for(int c = 0; c < 5; c++){
            p1.enqueue(QDeck.dequeue());
            p2.enqueue(QDeck.dequeue());
        }
        
        System.out.println("Player 1 Card");
        p1.showQueue();
        
        System.out.println("\nPlayer 2 Card");
        p2.showQueue();
        
        compare(p1, p2);
        System.out.println("\nPlayer 1 Score: " + p1score);
        System.out.println("Player 2 Score: " + p2score);
        
        if(p1score > p2score) System.out.println("Player 1 WINS!");
        else if(p2score > p1score) System.out.println("Player 2 WINS!");
        else if(p1score == p2score) System.out.println("It's a tie!");
    }
    
    public static void shuffle(String[] deck){
        int j = 0;
        for(String c : colour) for(String n : number) deck[j++] = n + " " + c;
        
        for(int i = 0; i < deck.length; i++){
            int randInt = r.nextInt(deck.length);
            String tmp = deck[i];
            deck[i] = deck[randInt];
            deck[randInt] = tmp;
        }
    }
    
    public static void compare(Queue p1, Queue p2){
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
    
    public static int getNumber(String n){
        switch(n){
            case "One":
                return 1;
            case "Two":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
                return 10;
            default:
                return 0;
        }
    }
    
}
