package Ipjasic_Beat_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	//private Image noteBasicImage = new ImageIcon(MainAction.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(MainAction.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgeMentLineImage = new ImageIcon(MainAction.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameBottomImage = new ImageIcon(MainAction.class.getResource("../images/gameBottomArea.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	
	public String titleName;
	public String difficulty;
	public String musicTitle;
	public PlayAndStopMusic gameMusic;
	public int score = 0;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new PlayAndStopMusic(this.musicTitle, false);
		
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameBottomImage, 0, 660, null);
		g.drawImage(judgeMentLineImage, 0, 580, null);
		for( int i = 0; i<noteList.size(); i++) 
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else {
				note.scrrenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Areal", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Areal", Font.PLAIN, 26));
		g.setColor(Color.darkGray);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 240, 380, null);
		g.drawImage(judgeImage, 460, 420, null);
		
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popBig1.mp3", false).start();
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(MainAction.class.getResource("../images/keyPadPressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	
	public void releasedS() {
		noteRouteSImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedD() {
		noteRouteDImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedF() {
		noteRouteFImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedSpace() {
		noteRouteSpace1Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedJ() {
		noteRouteJImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedK() {
		noteRouteKImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void releasedL() {
		noteRouteLImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(MainAction.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes( String titleName ) {
		Beat [] beats = null;
		if(titleName.equals("SaintTail - SaintTail") && difficulty.equals("Hard")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			int gap = 125;
			beats = new Beat[] {
				new Beat(startTime, "S"),
				new Beat(startTime + gap * 6, "D"),
				new Beat(startTime + gap * 8, "F"),
				new Beat(startTime + gap * 10, "Space"),
				new Beat(startTime + gap * 12, "F"),
				new Beat(startTime + gap * 14, "D"),
				new Beat(startTime + gap * 16, "F"),
				new Beat(startTime + gap * 18, "D"),
				new Beat(startTime + gap * 20, "F"),
				new Beat(startTime + gap * 22, "D"),
				new Beat(startTime + gap * 24, "F"),
				new Beat(startTime + gap * 26, "D"),
				new Beat(startTime + gap * 28, "F"),
				new Beat(startTime + gap * 30, "J"),
				new Beat(startTime + gap * 32, "F"),
				new Beat(startTime + gap * 34, "J"),
				new Beat(startTime + gap * 36, "F"),
				new Beat(startTime + gap * 38, "J"),
				new Beat(startTime + gap * 40, "F"),
				new Beat(startTime + gap * 42, "J"),
				new Beat(startTime + gap * 44, "Space"),
				new Beat(startTime + gap * 46, "F"),
				new Beat(startTime + gap * 46, "Space"),
				new Beat(startTime + gap * 46, "J"),
			};
		}else if(titleName.equals("SaintTail - SaintTail") && difficulty.equals("Easy")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("SquareWorld - DigimonRPG") && difficulty.equals("Hard")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("SquareWorld - DigimonRPG") && difficulty.equals("Easy")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("Lost Memory - Goblin") && difficulty.equals("Hard")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("Lost Memory - Goblin") && difficulty.equals("Easy")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("Samurai - DefKev") && difficulty.equals("Hard")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}else if(titleName.equals("Samurai - DefKev") && difficulty.equals("Easy")) {
			int startTime = 1000 - MainAction.REACH_TIME*1000;
			beats = new Beat[] {
				new Beat(startTime, "space")
			};
		}
		int i = 0;
		gameMusic.start();
		while(i<beats.length && !isInterrupted() ) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) { e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void judge(String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(MainAction.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeMiss.png")).getImage();
		}else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeGood.png")).getImage();
		}else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeGreat.png")).getImage();
		}else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgePerfect.png")).getImage();
		}else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeEarly.png")).getImage();
		}else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(MainAction.class.getResource("../images/judgeLate.png")).getImage();
		}
	}
	
}
