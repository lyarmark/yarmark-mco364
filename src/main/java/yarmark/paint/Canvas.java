package yarmark.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage bufferedImage;
	private Tool tool;

	public Canvas() {
		this.tool = new LineTool();
		bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

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
				tool.mousePressed(bufferedImage.getGraphics(), e.getX(), e.getY());
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				addMouseMotionListener(new MouseMotionListener() {

					@Override
					public void mouseDragged(MouseEvent e) {
						tool.mouseDragged(bufferedImage.getGraphics(), e.getX(), e.getY());
						repaint();
					}

					@Override
					public void mouseMoved(MouseEvent e) {

					}
				});

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bufferedImage, 0, 0, null);
		tool.drawPreview(g);

	}

}
