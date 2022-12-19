package Ipjasic_Beat_09;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{

	private Image noteBasicImage = new ImageIcon(MainAction.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / MainAction.SLEEP_TIME * MainAction.NOTE_SPEED;
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void scrrenDraw(Graphics2D g) {
		if(noteType.equals("short")) 
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		else if(noteType.equals("long")) 
		{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
	}
	
	public void drop() {
		y += MainAction.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				Thread.sleep(MainAction.SLEEP_TIME);
			}
		} catch(Exception e){
			System.err.print(e.getMessage());
		}
	}
}
