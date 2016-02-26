package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton pencil;
	private JButton line;
	private JButton rectangle;
	private JButton oval;
	private JButton bucket;
	private JPanel buttons;
	private Canvas canvas;
	private Color color;

	public void setColor(Color color) {
		this.color = color;
	}

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
		buttons.add(bucket);

		JColorChooser cc = new JColorChooser();

		AbstractColorChooserPanel[] panels = cc.getChooserPanels();

		for (AbstractColorChooserPanel p : panels) {
			if (!p.getDisplayName().equals("Swatches")) {
				cc.removeChooserPanel(p);
			}
		}
		cc.setPreviewPanel(new JPanel());
		ColorSelectionModel model = cc.getSelectionModel();
		ChangeListener changeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent c) {
				setColor(model.getSelectedColor());
			}
		};
		model.addChangeListener(changeListener);

		buttons.add(cc);

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
		if (e.getSource() == bucket) {
			canvas.setTool(new BucketTool());
		}
	}
}
