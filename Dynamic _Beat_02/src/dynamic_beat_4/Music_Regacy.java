package dynamic_beat_4;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music_Regacy extends Thread{
	
	private boolean isLoop;
	public Music_Regacy(String name, boolean isLoop) {
//		File file = new File("../music/asterisk.wav");
		File file;
		//System.out.println(new File("../music/asterisk.wav").getAbsolutePath());
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI() );
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			
			// 소리 설정
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			// 볼륨 조절
			gainControl.setValue(-15.0f);
			
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void close() {
		isLoop = false;
	}
	
}
