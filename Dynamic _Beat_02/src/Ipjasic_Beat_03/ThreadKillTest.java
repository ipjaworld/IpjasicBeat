package Ipjasic_Beat_03;

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

import dynamic_beat_7_2.Main;

public class ThreadKillTest extends Thread{
	
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadKillTest tk = new ThreadKillTest();
		tk.start();
		
		Thread.sleep(2000);
		//tk.interrupt();
		try {
			tk.close();
		} catch (UnsupportedAudioFileException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		} catch (LineUnavailableException e) {e.printStackTrace();
		}
	}
	
	public ThreadKillTest() {	
		File file;
		try {
			System.out.println("나를 불렀니?");
			file = new File(Main.class.getResource("../music/asterisk.wav").toURI() );
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-25.0f);
			if(isLoop) clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();

		} catch (Exception e) {e.printStackTrace();
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
		//this.stop();
	}
	
	@Override
	public void run() {
		try {
			do {
				System.out.println("쓰레드가 실행이 되었답니다?");
			}while(isLoop);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
