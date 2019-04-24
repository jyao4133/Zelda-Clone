package com.control;
/*This is the audio generic class which is used to take the input file and convert into 16 bit format to be able to play within the game.
 * It is called in various classes to play sound effects. The audio files are .wav format. Reference of the code has been used 
 * from: https://www.youtube.com/watch?v=ar0hTsb9sxM&t=490s, as it is made on a new thread which works in parallel to the main game thread.
 */
import javax.sound.sampled.*;

public class Audio {
	
	private Clip clip;
	
	public Audio (String s) {
		try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
		AudioFormat baseFormat = ais.getFormat();
		AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
		AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
		clip = AudioSystem.getClip();
		clip.open(dais);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void play() {
		if (clip == null) return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void stop () {
		if (clip.isRunning()) clip.stop();
	}
	
	public void close() {
		stop();
		clip.close();
	}
	
}
