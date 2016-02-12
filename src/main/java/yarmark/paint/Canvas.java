package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage bufferedImage;
	private Point previous;
	private Point current;

	public Canvas() {

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
				previous = e.getPoint();

				Graphics g = bufferedImage.getGraphics();
				g.setColor(Color.blue);
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				addMouseMotionListener(new MouseMotionListener() {

					@Override
					public void mouseDragged(MouseEvent e) {
						current = e.getPoint();

						Graphics g = bufferedImage.getGraphics();
						g.setColor(Color.blue);
						g.drawLine((int) previous.getX(), (int) previous.getY(), (int) current.getX(),
								(int) current.getY());
						previous = current;
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
	}

}
