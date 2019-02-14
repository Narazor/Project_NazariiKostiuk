import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	private final double SPEED = 50;
	private final int BORDER_TOP = 10;
	private final int BORDER_BOTTOM = 500;

	private Timer mainTimer = new Timer(20, this);
	
	Vehicle player = new PlayerCar(BORDER_TOP, BORDER_BOTTOM);
	Road road = new Road(SPEED);

	List<OtherVehicle> passingVehicles = new ArrayList<OtherVehicle>();

	public GamePanel() {
		mainTimer.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);

		passingVehicles.addAll(generateVehicles());
	}

	private class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			((PlayerCar) player).keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			((PlayerCar) player).keyReleased(e);
		}
	}

	public void paint(Graphics g) {
		Graphics2D graphic2D = (Graphics2D) g;
		road.paint(graphic2D);
		player.paint(graphic2D);
		
		for (Vehicle vehicle : passingVehicles) {
				vehicle.paint(graphic2D);
		}		
	}

	public void actionPerformed(ActionEvent e) {
		road.move();
		player.move();
		for (Vehicle vehicle : passingVehicles) {
			vehicle.move();
		}
		repaint();
		testCollisionWithOtherVehicle();
		testWin();
	}

	private void testWin() {
		if (((Road) road).getRoadSpeed() > 90) {
			JOptionPane.showMessageDialog(null, "You win");
			System.exit(0);
		}
	}

	private void testCollisionWithOtherVehicle() {
		for (Vehicle vehicle : passingVehicles) {
			if (player.getRect().intersects(vehicle.getRect())) {
				JOptionPane.showMessageDialog(null, "Game Over");
				System.exit(1);;
			}
		}
	}

	private List<OtherVehicle> generateVehicles() {
		List<OtherVehicle> all = new ArrayList<OtherVehicle>();
		
		all.add(new Bike());
		all.add(new Truck());
		return all;
	}
}
