/*
 * 2. Create a class called Sentence that used to display the length, the number of vowels (a,e,i,o,u) and the number of words in the sentence. Example output:

The sentence is : How are you?
The lenth of the sentence : 12
The number ofk vowels : 5
The number of words : 3

 */
package T1;

public class Sentence {
    
    private String sentence;
    private int length, vowel, word;

    public Sentence(String sentence) {
        this.sentence = sentence;
        length = sentence.length();
        word = sentence.split(" ").length;
        vowel = calcVowel();
    }
    
    public int calcVowel(){
        int tempVowel = 0;
        String tempSentence = sentence.toLowerCase();
        
        for(int i = 0; i < sentence.length(); i++){
            switch(tempSentence.charAt(i)){
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    tempVowel++;
                    break;
                
                default:
            }
        }
        return tempVowel;
    }

    public String toString() {
        return "The sentence is : " + sentence + 
               "\nThe length of the sentence : " + length + 
               "\nThe number of vowels : " + vowel + 
               "\nThe number of words : " + word;
    }
}
