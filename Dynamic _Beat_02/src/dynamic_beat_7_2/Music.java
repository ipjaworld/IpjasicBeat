package dynamic_beat_7_2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music extends Thread{
	
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {	
		File file;
		try {
			this.isLoop = isLoop;
			
			file = new File(Main.class.getResource("../music/"+name).toURI() );
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			
			// 소리 설정
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			// 볼륨 조절
			gainControl.setValue(-25.0f);
			
			if(isLoop) clip.loop(Clip.LOOP_CONTINUOUSLY);
			//clip.loop(Clip.LOOP_CONTINUOUSLY); // java 에서 무한루프를 할 수 있게 해주는 메서드
			clip.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
//	public int getTime() {
//		if(file == null)
//			return 0;
//	}

	public void close() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException  {
		isLoop = false;
		this.interrupt();
		this.stop();
		
		//this.close();
		System.out.println("닫았습니다.");
	}
	
	public boolean isLoop() {
		return isLoop;
	}

	public void setLoop(boolean isLoop) {
		this.isLoop = isLoop;
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
