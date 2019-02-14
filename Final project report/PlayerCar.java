import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class PlayerCar extends Vehicle {
	
	private int maxTop;
	private int maxBottom ;
	private int moveOn_Y;

	private Image img = getImage();
	private Image img_left = new ImageIcon("res/Player-left.png").getImage();
	private Image img_right = new ImageIcon("res/Player-right.png").getImage();
	
	public PlayerCar(int maxTop, int maxBottom) {
		this.maxTop = maxTop;
		this.maxBottom = maxBottom;
		x = 25;
		y = 250;
	}
	
	@Override
	public Image getImage() {
		return new ImageIcon("res/PlayerCar.png").getImage();
	}

	@Override
	public int getWidth() {
		return 300;
	}

	@Override
	public int getHeight() {
		return 84;
	}

	public void paint(Graphics2D graphic) {
		graphic.drawImage(img, getX(), getY(), null);
	}

	@Override
	public void move() {
		y += moveOn_Y;
		if (y <= maxTop) {
			y = maxTop;
		}
		if (y >= maxBottom) {
			y = maxBottom;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			moveOn_Y = -12;
			img = img_left;
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveOn_Y = 12;
			img = img_right;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			moveOn_Y = 0;
			img = getImage();
		}
	}
}
