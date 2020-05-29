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

public class ColourCard {
    
    private String card;
    private String colour;
    private int num;
    
    public ColourCard(String number, String colour){
        card = number + " " + colour;
        this.colour = colour;
        num = getNumber(number);
    }

    public String getColour() {
        return colour;
    }

    public int getNum() {
        return num;
    }
    
    /**
     * @param card
     * @return true when card is larger than the comparing card
     */
    public boolean compareTo(ColourCard card){
        if(colour.compareTo(card.getColour()) < 0) return true;
        else if (colour.compareTo(card.getColour()) == 0){
            return num > card.getNum();
        }
        return false;
    }
    
    public int getNumber(String n){
        switch(n){
            case "One": return 1;
            case "Two": return 2;
            case "Three": return 3;
            case "Four": return 4;
            case "Five": return 5;
            case "Six": return 6;
            case "Seven": return 7;
            case "Eight": return 8;
            case "Nine": return 9;
            case "Ten": return 10;
            default: return 0;
        }
    }
    
    public String toString(){
        return card;
    }
    
}
