/*
 * 2. Output
Create a text file log with maximum record equal to 5
Text File Log Size 5
James
Ahmad
Siti
Ramesh
John

Adding another record
The log is full
Searching for Siti in the file
Text File Log contains Siti
Clear the text file log
Text File Log Size 0
 */
package Lab2;

public class TextFileLogTesterClass {
    public static void main(String[] args) {
        
        int N = 5;
        TextFileLog<String> admin = new TextFileLog<>(5);
//        admin.insert("James");
//        admin.insert("Ahmad");
//        admin.insert("Siti");
//        admin.insert("Ramesh");
//        admin.insert("John");
        admin.read();
        
        admin.insert("Abdullah");
        String nameToSearch = "Siti";
        if(admin.search(nameToSearch)){
            System.out.println("Text File Log contains " + nameToSearch);
        } else {
            System.out.println("Text File Log does not contain " + nameToSearch);
        }
        
    }
}
