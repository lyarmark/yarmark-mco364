package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
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
	private JButton undo;
	private JButton redo;
	private JPanel buttons;
	private Canvas canvas;
	private Color color;

	public static void main(String[] args) {
		PaintFrame paintFrame = new PaintFrame();
		paintFrame.setVisible(true);
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
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		buttons = new JPanel();

		pencil.addActionListener(this);
		line.addActionListener(this);
		rectangle.addActionListener(this);
		oval.addActionListener(this);
		bucket.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);

		buttons.add(pencil);
		buttons.add(line);
		buttons.add(rectangle);
		buttons.add(oval);
		buttons.add(bucket);
		buttons.add(undo);
		buttons.add(redo);

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

		setColor(Color.BLACK);
		canvas = new Canvas(this.color);

		container.add(canvas, BorderLayout.CENTER);
		container.add(buttons, BorderLayout.SOUTH);
	}

	public void setColor(Color color) {
		this.color = color;
		if (canvas != null) {
			this.canvas.setColor(color);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pencil) {
			canvas.setTool(new PencilTool(this.color));
		}
		if (e.getSource() == line) {
			canvas.setTool(new LineTool(this.color));
		}
		if (e.getSource() == rectangle) {
			canvas.setTool(new RectangleTool(this.color));
		}
		if (e.getSource() == oval) {
			canvas.setTool(new OvalTool(this.color));
		}
		if (e.getSource() == bucket) {
			canvas.setTool(new BucketTool(canvas.getImage(), this.color));
		}
		if (e.getSource() == undo) {
			canvas.undo();
		}
		if (e.getSource() == redo) {
			canvas.redo();
		}
	}
}
