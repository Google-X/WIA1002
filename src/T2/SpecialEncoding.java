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

class SpecialEncodingTester{
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

public class SpecialEncoding<T>{
    private T[] t;
    private String[] code = new String[5];
    
    public SpecialEncoding(T[] t) {
        this.t = t;
    }

    public T[] getT() {
        return t;
    }

    public void setT(T[] t) {
        this.t = t;
    }
    
    public void setCode(){
        if(t.getClass().getSimpleName().equals("Integer[]")){
            for(int i = 0; i < t.length; i++){
                switch((Integer)(t[i])){
                    case 0:
                        code[i] = "Copy";
                        break;
                    case 1:
                        code[i] = "Delete";
                        break;
                    case 2:
                        code[i] = "Insert";
                        break;
                    case 3:
                        code[i] = "Print";
                        break;
                    case 4:
                        code[i] = "Rename";
                        break;
                    case 5:
                        code[i] = "Paste";
                        break;
                    default:
                        
                }
            }
        } else if (t.getClass().getSimpleName().equals("Character[]")){
            for(int i = 0; i < t.length; i++){
                switch((Character)(t[i])){
                    case 'C':
                        code[i] = "Copy";
                        break;
                    case 'D':
                        code[i] = "Delete";
                        break;
                    case 'I':
                        code[i] = "Insert";
                        break;
                    case 'P':
                        code[i] = "Print";
                        break;
                    case 'R':
                        code[i] = "Rename";
                        break;
                    case 'V':
                        code[i] = "Paste";
                        break;
                    default:
                }
            }
            
        }
        
    }
    
    public String toString() {
        String finalStr = "The Code is ";
        
        for(int i = 0; i < t.length; i++){
            finalStr += t[i] + " ";
        }
        
        finalStr += "\nThe Command is ";
        
        for(int i = 0; i < code.length; i++){
            finalStr += code[i] + " ";
        }
        
        return finalStr;
    }
    
}
