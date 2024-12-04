package Engine;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;








public class SoundHandler{


   public static Clip currentMusic;


   public static void RunMusic(String path){


       /* try {  
           AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
           music = AudioSystem.getClip();
           music.open(inputStream);
           music.loop(Clip.LOOP_CONTINUOUSLY);
       } catch (UnsupportedAudioFileException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       } catch (LineUnavailableException e) {
           e.printStackTrace();
       } */


       File music = new File(path);


       try {
           if(music.exists()){
               AudioInputStream inputStream = AudioSystem.getAudioInputStream(music);


               currentMusic = AudioSystem.getClip();
               currentMusic.open(inputStream);
               currentMusic.loop(Clip.LOOP_CONTINUOUSLY);


               currentMusic.start();


              
             
           }
          
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


   public static void PatchMusic(String path){


       try {  
           AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
           currentMusic = AudioSystem.getClip();
           currentMusic.open(inputStream);
           currentMusic.start();
       } catch (UnsupportedAudioFileException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       } catch (LineUnavailableException e) {
           e.printStackTrace();
       }
   }
  


   public static void StopMusic(String path){




/*
       try {  
           AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
           music = AudioSystem.getClip();
           long musicTimePosition = music.getMicrosecondPosition();
           music.stop();
           System.out.println("music stopped");
       } catch (UnsupportedAudioFileException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       } catch (LineUnavailableException e) {
           e.printStackTrace();
       }
   }
   */




         


           currentMusic.stop();


}
}


  


