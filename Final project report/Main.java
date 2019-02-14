import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame("Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1280, 635
				
				);
		f.add(new GamePanel());
		f.setVisible(true);

	}

	
	
	
}
