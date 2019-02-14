import java.awt.Image;

import javax.swing.ImageIcon;

public class Truck extends OtherVehicle {

	public Truck() {
		super();
	}
	
	@Override
	public void move() {
		if(speed > 8) {
			speed = getSpeed() - 0.5;
		}
		super.move();
	}

	@Override
	public int getSpeed() {
		return 18;
	}

	@Override
	public Image getImage() {
		return new ImageIcon("res/Truck.png").getImage();
	}

	@Override
	public int getWidth() {
		return 288;
	}

	@Override
	public int getHeight() {
		return 170;
	}
}
