/*
8. Create a Music class that consists of the music title and the file name. Then, insert a few music object into the CircularLinkedList. After that, modify the code below to allow the users to play the music.  

Example output below

 */
package Lab4;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
    
    static JFXPanel panel = new JFXPanel();
    static String folderDir = "C:/Users/User/Music/0Songs/Chill/";
    // Put the name of one of your file
    static Media hit = new Media(Paths.get(folderDir + "Bright.mp3").toUri().toString());
    static MediaPlayer mediaPlayer = new MediaPlayer(hit);
    static CircularLinkedList<String> li = new CircularLinkedList<>();
    static Scanner s = new Scanner(System.in);
    static int index = 0;
    
    public static void main(String[] args) {
        // Replace with your music folder directory
        ArrayList<String> songFiles = getFileName(folderDir);
        
        // Adding the song name into the CircularLinkedList
        for(String f : songFiles) li.addCircularNode(f);
        
        System.out.println("My Music Play List");
        ask();
        
    }
    
    public static void ask(){
        int choice;
        do{
            li.showCircularNodeMusic();
            System.out.print("1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit: ");
            choice = s.nextInt();
            mediaPlayer.stop();
            
            switch(choice){
                case 1:
                    playSong(li.getCicularItem(index));
                    break;
                    
                case 2:
                    if(index == li.length()-1) index = 0;
                    else index++;
                    System.out.print("Forward One Position - ");
                    playSong(li.getCicularItem(index));
                    break;
                    
                case 3:
                    if(index == 0) index = li.length()-1;
                    else index--;
                    System.out.print("Backward One Position - ");
                    playSong(li.getCicularItem(index));
                    break;
                
                case 4:
                    System.out.println("Stop Playing");
                    mediaPlayer.stop();
                    break;
                    
                case -1:
                    System.out.println("Exit Music Player");
                    System.exit(0);
                    break;
                    
            }
        } while (choice != -1);
    }
    
    public static void playSong(String song){
        System.out.println("Play Music : " + song);
        hit = new Media(Paths.get(folderDir + song).toUri().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        ask();
//        mediaPlayer.stop();
    }
    
    public static ArrayList getFileName(String folderName){
        ArrayList<String> musicList = new ArrayList<>();
        File f = new File(folderName);
        File l[] = f.listFiles();
        for(File x : l){
            if(x == null) return null;
            if(x.isHidden() || !x.canRead()) continue;
            if(x.isDirectory()) {
//                skip here
//                musicList = getFileName(x.getPath());
            }
            else if(x.getName().endsWith(".mp3"))
                musicList.add(x.getName());
//                System.out.println(x.getPath()+"\\"+x.getName());
        }
        return musicList;
    }
}
/*
Example output:

My Music Play List 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit: 1 
Play Music : one 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 StopI -1 Exit : 2 
Forward One Position - Play Music : two 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : 2 
Forward One Position Play Music : three 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : 3 
Backward One Position - Play Music : two 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop -1 Exit : 2 
Forward One Position - Play Music : three 
Music : one --> Music : two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : 2 
Forward One Position Play Music : four 
Music : one --> Music : two--> Music: three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : 2 
Forward One Position Play Music : one 
Music : one --> Music : Two --> Music : three --> Music : four --> Music : one
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : 4 
Stop Playing 
Music : one --> Music : Two --> Music : three --> Music : four --> Music : one 
1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit : -1
Exit Music Player

*/