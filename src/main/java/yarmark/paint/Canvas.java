package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;

	public Canvas(Color color) {
		this.tool = new PencilTool(color);
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		undo = new Stack<BufferedImage>();
		undo.push(deepCopyImage());
		redo = new Stack<BufferedImage>();

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

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

	public void setColor(Color color) {
		this.tool.setColor(color);
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
			BufferedImage undoImage = undo.pop();
			this.setImage(undoImage);
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
