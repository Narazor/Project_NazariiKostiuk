import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class Vehicle implements GameObjectBase {

	protected  int x;
	protected int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getRect() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public void paint(Graphics2D graphic) {
		graphic.drawImage(getImage(), getX(), getY(), null);
	}
	
	public abstract Image getImage();

	public abstract int getWidth();

	public abstract int getHeight();

}
