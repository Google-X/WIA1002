/*
 * 2. Create a generic class SpecialEncoding. The class will display the command based on the type of input. Example of Tester Class.  
Integer     0       1       2       3       4       5 
Character   C       D       I       P       R       V 
Command     Copy    Delete  Insert  Print   Rename  Paste

Example output:
The Code is 3 2 5 0 1
The Command is Print Insert Paste Copy Delete
The Code is P I V C D
The Command is Print Insert Paste Copy Delete

 */
package T2;

class SpecialEncodingTester {

    public static void main(String[] args) {
        Integer[] num = {3, 2, 5, 0, 1};
        Character[] letter = {'P', 'I', 'V', 'C', 'D'};
        SpecialEncoding<Integer> a = new SpecialEncoding<>(num);
        SpecialEncoding<Character> b = new SpecialEncoding<>(letter);
        a.setCode();
        b.setCode();
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}

public class SpecialEncoding<T> {

    private T[] t;
    private String[] code = new String[5];

    public SpecialEncoding(T[] t) {
        this.t = t;
    }

    public void setCode() {
        byte i = 0;
        for (T value : t) {
            switch (String.format("%s", value)) {
                case "0":
                case "C":
                    code[i] = "Copy";
                    i++;
                    break;
                case "1":
                case "D":
                    code[i] = "Delete";
                    i++;
                    break;
                case "2":
                case "I":
                    code[i] = "Insert";
                    i++;
                    break;
                case "3":
                case "P":
                    code[i] = "Print";
                    i++;
                    break;
                case "4":
                case "R":
                    code[i] = "Rename";
                    i++;
                    break;
                case "5":
                case "V":
                    code[i] = "Paste";
                    i++;
                    break;
            }
        }
    }

    public String toString() {
        String finalStr = "The Code is ";

        for (int i = 0; i < t.length; i++) {
            finalStr += t[i] + " ";
        }

        finalStr += "\nThe Command is ";

        for (int i = 0; i < code.length; i++) {
            finalStr += code[i] + " ";
        }

        return finalStr;
    }
}
