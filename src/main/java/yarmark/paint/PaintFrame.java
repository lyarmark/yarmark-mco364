package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PaintFrame() {
		setTitle("Paint Frame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Canvas canvas = new Canvas();
		container.add(canvas);
 
	}

	public static void main(String[] args) {
		PaintFrame paintFrame = new PaintFrame();
		paintFrame.setVisible(true);
	}
}
