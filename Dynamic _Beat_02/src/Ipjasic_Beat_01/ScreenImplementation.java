package Ipjasic_Beat_01;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScreenImplementation extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/buttonEnterd.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/buttonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/rightButtonBasic.png"));
	
	private Image titleImage = new ImageIcon(MainAction.class.getResource("../images/lostMemoryTitleImage.png")).getImage();
	private Image selectedImage = new ImageIcon(MainAction.class.getResource("../images/lostMemoryStartImage.png")).getImage();
	//private Image selectedImage = new ImageIcon(MainAction.class.getResource("../images/whitewallpaper.jpg")).getImage();
	private Image background = new ImageIcon(MainAction.class.getResource("../images/whitewallpaper.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(MainAction.class.getResource("../images/munuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	PlayAndStopMusic pasm = new PlayAndStopMusic("asterisk.wav", true);
	//pasm.start();
	
	public ScreenImplementation() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(MainAction.SCREEN_WIDTH, MainAction.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		

		// 우상단 게임 종료 버튼
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.wav",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.wav",false);
				buttonBasicMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex){
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		// 시작 버튼
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.wav",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.wav",false);
				buttonBasicMusic.start();
				// 게임 시작 버튼 구현
				try {
					pasm.close();
				} catch (UnsupportedAudioFileException e) {e.printStackTrace();
				} catch (IOException e) {e.printStackTrace();
				} catch (LineUnavailableException e) {e.printStackTrace();
				}
				PlayAndStopMusic selectedMusic = new PlayAndStopMusic("lostMemory.wav",true);
				selectedMusic.start();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(MainAction.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		// quit 버튼
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.wav",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.wav",false);
				buttonBasicMusic.start();
				// 현재 게임 종료 버튼
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex){
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		// left 버튼
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.wav",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.wav",false);
				buttonBasicMusic.start();
				
			}
		});
		add(leftButton);
		
		// right 버튼
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.wav",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.wav",false);
				buttonBasicMusic.start();
				
			}
		});
		add(rightButton);
		
		// 메뉴바 디자인
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(MainAction.SCREEN_WIDTH, MainAction.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);
		this.repaint();
	}
	
}
