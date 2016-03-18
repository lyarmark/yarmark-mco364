package yarmark.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JPanel;

@Singleton
public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;

	@Inject
	public Canvas(PaintProperties properties) {
		tool = new PencilTool(properties);
		undo = new Stack<BufferedImage>();
		image = properties.getImage();
		undo.push(deepCopyImage());
		redo = new Stack<BufferedImage>();

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				undo.push(deepCopyImage());
				tool.mousePressed(image.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(image.getGraphics(), e.getX(), e.getY());
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(image.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		tool.drawPreview(g);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		repaint();
	}

	public BufferedImage getImage() {
		return image;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			if (!undo.isEmpty() && undo.size() != 1) {
				redo.push(deepCopyImage());
			}
			BufferedImage undoImage = undo.pop();
			this.setImage(undoImage);
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(deepCopyImage());
			BufferedImage redoImage = redo.pop();
			this.setImage(redoImage);
		}
	}

	public BufferedImage deepCopyImage() {
		ColorModel model = this.image.getColorModel();
		boolean isAlphaPremultiplied = model.isAlphaPremultiplied();
		WritableRaster raster = this.image.copyData(null);
		BufferedImage copyImage = new BufferedImage(model, raster, isAlphaPremultiplied, null);
		return copyImage;
	}
}
