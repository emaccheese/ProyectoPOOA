package Logica;
import java.io.*;
import javax.sound.midi.*;
   
public class PlaySong extends Thread{
	private  Sequencer midiPlayer;

	
	 public  void run() {
	      try {
	        // midiFile = new File("src\\Datos\\Audio\\z64kokri.mid");
	         Sequence song = MidiSystem.getSequence(PlaySong.class.getResourceAsStream("/Datos/Audio/z64kokri.mid"));
	       
	         midiPlayer = MidiSystem.getSequencer();
	         midiPlayer.open();
	         midiPlayer.setSequence(song);
	         midiPlayer.setLoopCount(5); // repeat 0 times (play once)
	         midiPlayer.start();
	      } catch (MidiUnavailableException e) {
	         e.printStackTrace();
	      } catch (InvalidMidiDataException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	}
	
