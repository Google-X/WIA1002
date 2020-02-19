/*
 * 2. Create a class called Sentence that used to display the length, the number of vowels (a,e,i,o,u) and the number of words in the sentence. Example output:

The sentence is : How are you?
The lenth of the sentence : 12
The number ofk vowels : 5
The number of words : 3

 */
package T1;

public class SentenceTesterClass {
    public static void main(String[] args) {
        
        Sentence s = new Sentence("How are you?");
        System.out.println(s.toString());
        
    }
}
