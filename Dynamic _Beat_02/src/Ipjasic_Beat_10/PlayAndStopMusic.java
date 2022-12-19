package Ipjasic_Beat_10;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayAndStopMusic extends Thread{
	
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public PlayAndStopMusic(String location, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(MainAction.class.getResource("../music/"+location).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			//System.out.println("생성자가 잘 실행이 되었습니다~ 쨔란 ★");
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	// close() clip에 쓰는 메서드를 오버라이딩했지만 실행 취소하였습니다.
	// 22.12.01에 interrupt 메서드는 이상이 없이 잘 실행이 되는 것을 확인
	public void close()  {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				
				//System.out.println("쓰레드가 잘 동작하고 있습니다.");
			}while(isLoop);
		}catch(Exception e){e.printStackTrace();
		}
	}



}
