package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage buffer;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Color color;

	public Canvas() {
		this.tool = new PencilTool();
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		undo = new Stack<BufferedImage>();
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
				tool.mousePressed(buffer.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				tool.mouseReleased(buffer.getGraphics(), e.getX(), e.getY());
				repaint();

			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				tool.mouseDragged(buffer.getGraphics(), e.getX(), e.getY());
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
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
