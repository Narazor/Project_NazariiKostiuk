import java.awt.Image;

import javax.swing.ImageIcon;

public class Bike extends OtherVehicle {

	public Bike() {
		super();
	}
	
	@Override
	public void move() {
		if(speed < 50) {
		speed = getSpeed() + 0.1;
		}
		super.move();
	}
	
	@Override
	public int getSpeed() {
		return 50;
	}

	@Override
	public Image getImage() {
		return new ImageIcon("res/Bike.png").getImage();
	}

	@Override
	public int getWidth() {
		return 115;
	}

	@Override
	public int getHeight() {
		return 101;
	}
}
