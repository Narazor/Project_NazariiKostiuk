import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Road implements GameObjectBase {
	
	Image img = new ImageIcon("res/MyRoad.jpg").getImage();
	
	private int layer1 = 0;
	private int layer2 = 1200;
	private double roadSpeed;
	
	public Road(double roadSpeed) {
		this.roadSpeed = roadSpeed;
	}
	
	public double getRoadSpeed() {
		return roadSpeed;
	}

	@Override
	public void paint(Graphics2D graphic) {
		graphic.drawImage(img, layer1, 0, null);
		graphic.drawImage(img, layer2, 0, null);
	}

	@Override
	public void move() {
		roadSpeed += 0.01;
		if ((layer2 - roadSpeed) <= 0) {
			layer1 = 0;
			layer2 = 1200;
		} else {
			layer1 -= roadSpeed;
			layer2 -= roadSpeed;
		}
	}	
}
