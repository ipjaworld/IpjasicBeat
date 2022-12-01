package Ipjasic_Beat_01;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayAndStopMusic extends Thread{
	
	private boolean isLoop;

	public PlayAndStopMusic(String location, boolean isLoop) {
		
		this.isLoop = isLoop;
		
		//String filepath = "asterisk.wav";
		//Main.class.getResource("../music/"+name).toURI()
		//Playmusic(filepath);
		//JOptionPane.showMessageDialog(null, "press any button");
		
		PlayMusic(location);	
	}
	
	public void PlayMusic(String location) {
		
		File musicPath;
		
		try {
			
			musicPath = new File(MainAction.class.getResource("../music/"+location).toURI());
			
			if(musicPath.exists()) {
				
				AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				
				// 소리 설정
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				// 볼륨 조절
				gainControl.setValue(-20.0f);
				
				if(isLoop) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
				clip.start();
			}else {
				System.out.println("I can't find File");
			}
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
	}
	
	public void close() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException  {
		isLoop = false;
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
//				AudioInputStream ais = AudioSystem.getAudioInputStream(file);
//				Clip clip = AudioSystem.getClip();
//				clip.open(ais);
//				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}while(isLoop);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	

}
