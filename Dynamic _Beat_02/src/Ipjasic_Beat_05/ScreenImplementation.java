package Ipjasic_Beat_05;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScreenImplementation extends JFrame{
	/**
	PlayAndStopMusic 클래스 설명서
	1. 일반 1회 재생
	2. 무한 루프 재생
	3. pause (일시 정지)
	4. close (노래 정지)
	
	pasm 클래스의 객체를 만들어서 각 노래별로 관리를 합니다.
	*/
	
	
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
	
	private ImageIcon easyButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/hardButtonBasic.png"));

	//private ImageIcon backButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(MainAction.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(MainAction.class.getResource("../images/backButtonBasic.png"));
	
	//private Image selectedImage = new ImageIcon(MainAction.class.getResource("../images/whitewallpaper.jpg")).getImage();
	private Image background = new ImageIcon(MainAction.class.getResource("../images/whitewallpaper.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(MainAction.class.getResource("../images/munuBar.png")));
	private JLabel gameBottomArea = new JLabel(new ImageIcon(MainAction.class.getResource("../images/gameBottomArea.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	static ArrayList<Track> trackList = new ArrayList<>();
	
	public PlayAndStopMusic selectedMusic;
	private Image titleImage;
	private Image selectedImage;
	private int nowSelected = 0;
	
	
	
	
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
		
		selectedMusic = new PlayAndStopMusic("asterisk.mp3", true);
		selectedMusic.start();
		
		// 게임에 사용할 음악들을 Track 이라는 어레이 리스트에 담는 작업입니다.
		// 첫번째 곡, 디폴트로 처음부터 시작될 음악, 인덱스 0번
		String FistTrack = "lostMemory";
		trackList.add(new Track(FistTrack+"TitleImage.png",FistTrack+"StartImage.png",
				FistTrack+"GameImage.png",FistTrack+"BFS.mp3",FistTrack+".mp3"));
		// 두번째 곡, 인덱스 1번
		String SecondTrack = "saintTail";
		trackList.add(new Track(SecondTrack+"TitleImage.png",SecondTrack+"StartImage.png",
				SecondTrack+"GameImage.png",SecondTrack+"BFS.mp3",SecondTrack+".mp3"));
		// 세번째 곡, 인덱스 2번
		String ThirdTrack = "squareworld";
		trackList.add(new Track(ThirdTrack+"TitleImage.png",ThirdTrack+"StartImage.png",
				ThirdTrack+"GameImage.png",ThirdTrack+"BFS.mp3",ThirdTrack+".mp3"));
		// 네번째 곡, 인덱스 3번
		String FourthTrack = "samurai";
		trackList.add(new Track(FourthTrack+"TitleImage.png",FourthTrack+"StartImage.png",
				FourthTrack+"GameImage.png",FourthTrack+"BFS.mp3",FourthTrack+".mp3"));

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
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
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
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				//selectedMusic.close();
				moveToMain();
				
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
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
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
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				selectLeft();
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
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		
		
		// easy 모드 버튼
		easyButton.setVisible(false);
		easyButton.setBounds(260, 550, 250, 141);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				moveToGame();
			}
		});
		add(easyButton);
		
		
		// hard 모드 버튼
		hardButton.setVisible(false);
		hardButton.setBounds(760, 550, 250, 141);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				moveToGame();
			}
		});
		add(hardButton);
		
		
		// 게임 화면에서 back 버튼(메인으로 돌아갑니다.)
		backButton.setVisible(false);
		backButton.setBounds(40, 400, 120, 120);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent E) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				PlayAndStopMusic buttonEnteredMusic = new PlayAndStopMusic("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent E) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent E){
				PlayAndStopMusic buttonBasicMusic = new PlayAndStopMusic("buttonBasicMusic.mp3",false);
				buttonBasicMusic.start();
				moveToMain();
			}
		});
		add(backButton);
		
		
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
		
		
		// 인게임 밑의 영역 디자인
		gameBottomArea.setBounds(0, 640, 1280, 80);
		add(gameBottomArea);
		gameBottomArea.setVisible(false);
		
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
	
	/** 
	 * 매우 정말 정말 중요한 기능이다. 이 함수 하나로 파일들을 관리한다.
	 */
	public void selectTrack( int nowSelected ) {
		if(selectedMusic != null) selectedMusic.close();
		titleImage = new ImageIcon(MainAction.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage() )).getImage();
		selectedImage = new ImageIcon(MainAction.class.getResource("../images/" + trackList.get(nowSelected).getStartImage() )).getImage();
		selectedMusic = new PlayAndStopMusic(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectGameTrack( int nowSelected ) {
		if(selectedMusic != null) selectedMusic.close();
		selectedMusic = new PlayAndStopMusic(trackList.get(nowSelected).getGameMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) nowSelected = trackList.size() -1;
		else nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1) nowSelected = 0;
		else nowSelected++;
		selectTrack(nowSelected);
	}
	
	
	public void moveToMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		selectTrack(nowSelected);
		background = new ImageIcon(MainAction.class.getResource("../images/mainBackground.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		gameBottomArea.setVisible(false);
		isMainScreen = true;
	}
	public void moveToGame() {
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(MainAction.class.getResource("../images/" + trackList.get(nowSelected).getGameImage() )).getImage();
		backButton.setVisible(true);
		gameBottomArea.setVisible(true);
		selectGameTrack(nowSelected);
		isMainScreen = false;
	}
	
	
	
	
}
