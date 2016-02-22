package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton pencil;
	private JButton line;
	private JButton rectangle;
	private JButton oval;
	private JButton bucket;
	private JPanel buttons;
	private Canvas canvas;

	public PaintFrame() {
		setTitle("Paint Frame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		pencil = new JButton("Pencil");
		line = new JButton("Line");
		rectangle = new JButton("Rectangle");
		oval = new JButton("Oval");
		bucket = new JButton("Bucket");
		buttons = new JPanel();

		pencil.addActionListener(this);
		line.addActionListener(this);
		rectangle.addActionListener(this);
		oval.addActionListener(this);

		canvas = new Canvas();
		buttons.add(pencil);
		buttons.add(line);
		buttons.add(rectangle);
		buttons.add(oval);

		container.add(canvas, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		PaintFrame paintFrame = new PaintFrame();
		paintFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pencil) {
			canvas.setTool(new PencilTool());
		}
		if (e.getSource() == line) {
			canvas.setTool(new LineTool());

		}
		if (e.getSource() == rectangle) {
			canvas.setTool(new RectangleTool());

		}
		if (e.getSource() == oval) {
			canvas.setTool(new OvalTool());

		}
	}
}
