package Logica;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import java.net.URL;
   
// Se usa Clip para poder tocar sonido.
// por esto se usa swing
public class PlaySound extends Thread {
	private String file;
   private int loop = 0;
   
   public void setFile(String file) {
	this.file = file;
}

public void setSoundFile(File soundFile) {
}

public void setLoop(int loop) {
	this.loop = loop;
}

// Constructor
   public void run() {
      
   
      try {
         // Abrir un audio input stream.
    	  //soundFile = new File("src\\Audio\\bubbling1.wav");
    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(PlaySound.class.getResourceAsStream(file));
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         //if(!clip.isActive()){
         clip.loop(loop);
         //}
         
         

      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
}
/*
public class PlaySound extends Thread{
    AudioStream audioStream = null;
    InputStream in = null;
	
    public void run() {
        // open the sound file as a Java input stream
        String soundFile = "shotgun-01.wav";

		try {
			in = new FileInputStream(soundFile);
	        // create an audiostream from the inputstream
	        audioStream = new AudioStream(in);
	        // play the audio clip with the audioplayer class
	        AudioPlayer.player.start(audioStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }

}*/
