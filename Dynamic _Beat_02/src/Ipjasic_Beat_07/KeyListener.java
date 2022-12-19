package Ipjasic_Beat_07;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if(ScreenImplementation.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			ScreenImplementation.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			ScreenImplementation.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			ScreenImplementation.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ScreenImplementation.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			ScreenImplementation.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			ScreenImplementation.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			ScreenImplementation.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(ScreenImplementation.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			ScreenImplementation.game.releasedS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			ScreenImplementation.game.releasedD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			ScreenImplementation.game.releasedF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			ScreenImplementation.game.releasedSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			ScreenImplementation.game.releasedJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			ScreenImplementation.game.releasedK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			ScreenImplementation.game.releasedL();
		}
	}
	
}
