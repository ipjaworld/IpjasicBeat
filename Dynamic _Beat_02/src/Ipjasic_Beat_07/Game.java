package Ipjasic_Beat_07;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteBasicImage = new ImageIcon(MainAction.class.getResource("../images/noteBasic.png")).getImage();
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
		g.drawImage(noteBasicImage, 228, 120, null);
		g.drawImage(noteBasicImage, 332, 580, null);
		g.drawImage(noteBasicImage, 436, 500, null);
		g.drawImage(noteBasicImage, 540, 340, null);
		g.drawImage(noteBasicImage, 640, 340, null);
		g.drawImage(noteBasicImage, 744, 325, null);
		g.drawImage(noteBasicImage, 848, 305, null);
		g.drawImage(noteBasicImage, 952, 305, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Areal", Font.BOLD, 30));
		g.drawString("SquareWorld - DigimonRPG", 20, 702);
		g.drawString("Easy", 1190, 702);
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
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popSmall1.mp3", false).start();
	}
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popBig1.mp3", false).start();
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(MainAction.class.getResource("../images/noteRoutePressed.png")).getImage();
		new PlayAndStopMusic("popBig2.mp3", false).start();
	}
	
	public void releasedS() {
		noteRouteSImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedD() {
		noteRouteDImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedF() {
		noteRouteFImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedSpace() {
		noteRouteSpace1Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedJ() {
		noteRouteJImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedK() {
		noteRouteKImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void releasedL() {
		noteRouteLImage = new ImageIcon(MainAction.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		
	}
}
