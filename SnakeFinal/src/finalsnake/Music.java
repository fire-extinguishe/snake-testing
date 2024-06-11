package finalsnake;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music{
	File music = new File("src/snake_files/BabyElephantWalk60.wav");
	Clip clip;
	long clipPosition;
	public Music() {
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(music);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	void play() {
		try {	
			clip.setMicrosecondPosition(clipPosition);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void stop() {
		clipPosition = clip.getMicrosecondPosition();
		clip.stop();
	}
}