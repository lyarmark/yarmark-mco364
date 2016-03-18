package yarmark.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@Singleton
public class PaintToolbar extends Container {

	private ToolButton[] tools;
	private JButton colorChooser;
	private JButton undo, redo;

	// PaintProperties properties;

	@Inject
	public PaintToolbar(Canvas canvas, PaintProperties properties) {
		// this.properties = properties;
		setLayout(new GridLayout(2, 1));

		setUndoRedo();

		// ToolButton[]
		tools = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.jpg"),
				new ToolButton(new LineTool(properties), "/line.jpg"),
				new ToolButton(new RectangleTool(properties), "/rectangle.jpg"),
				new ToolButton(new OvalTool(properties), "/oval.jpg"),
				new ToolButton(new BucketTool(properties), "/bucket.png") };

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == undo) {
					canvas.undo();
				} else if (e.getSource() == redo) {
					canvas.redo();
				} else {
					ToolButton button = (ToolButton) e.getSource();
					canvas.setTool(button.getTool());
				}
			}
		};
		JColorChooser cc = new JColorChooser();
		setColorChooser(cc, properties);

		undo.addActionListener(listener);
		redo.addActionListener(listener);
		JPanel buttons = new JPanel();
		for (ToolButton tool : tools) {
			buttons.add(tool);
			tool.addActionListener(listener);
		}
		buttons.add(undo);
		buttons.add(redo);
		add(buttons);
		add(cc);

	}

	private void setUndoRedo() {
		undo = new JButton();
		redo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/undo.jpg")).getImage().getScaledInstance(70,
				70, Image.SCALE_SMOOTH)));
		undo.setBackground(Color.white);
		redo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/redo.jpg")).getImage().getScaledInstance(70,
				70, Image.SCALE_SMOOTH)));
		redo.setBackground(Color.white);
	}

	private void setColorChooser(JColorChooser cc, PaintProperties properties) {
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
				properties.setColor(model.getSelectedColor());
			}
		};
		model.addChangeListener(changeListener);
	}
}