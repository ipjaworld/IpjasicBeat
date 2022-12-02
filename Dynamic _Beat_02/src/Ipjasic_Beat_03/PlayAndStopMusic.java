package Ipjasic_Beat_03;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Ipjasic_Beat_02.MainAction;

public class PlayAndStopMusic extends Thread{
	/**
	PlayAndStopMusic 클래스 설명서
	1. 일반 1회 재생
	2. 무한 루프 재생
	3. pause (일시 정지)
	4. close (노래 정지)
	
	pasm 클래스의 객체를 만들어서 각 노래별로 관리를 합니다.
	*/
	
	private boolean isLoop;
	private String location;
	

	public PlayAndStopMusic(String location, boolean isLoop, int operation) {
		System.out.println("생성자가 잘 실행이 되었습니다~ 쨔란 ★");
		File musicPath;
		this.isLoop = isLoop;
		try {
			if(location.equals("default")) { musicPath = new File(MainAction.class.getResource("../music/asterisk.wav").toURI());
			}else { this.location = location;
						musicPath = new File(MainAction.class.getResource("../music/"+location).toURI());
			}
			
			if(musicPath.exists()) {
				AudioInputStream ais = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				// 소리 설정
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				// 볼륨 조절
				gainControl.setValue(-20.0f);
				
				switch(operation) {
				case 1 : clip.start(); break;	// 일반 1회 재생
				case 2 : clip.loop(Clip.LOOP_CONTINUOUSLY); clip.start(); break;	// 무한 루프 재생
				case 3 : break;	// 일시정지(현재 위치 기억)
				case 4 : System.out.println("기존 음악을 닫습니다."); ais.close(); clip.close(); break;	// clip close
				}
			}else { System.out.println("I can't find File"); }
		}catch(Exception e) { System.out.println(e); }
		
	}
	
	// close() clip에 쓰는 메서드를 오버라이딩했지만 실행 취소하였습니다.
	// 22.12.01에 interrupt 메서드는 이상이 없이 잘 실행이 되는 것을 확인
	public void close()  {
		this.isLoop = false;
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
				//System.out.println("쓰레드가 잘 동작하고 있습니다.");
			}while(isLoop);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	

}
