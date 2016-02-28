package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	private BufferedImage image;

	public BucketTool(BufferedImage image) {
		this.image = image;
	}

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		fill(x, y, image.getRGB(x, y), Color.black);
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {

	}

	@Override
	public void drawPreview(Graphics g) {

	}

	public void fill(int x, int y, int source, Color target) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		Point p;
		while (!queue.isEmpty()) {
			p = queue.remove();
			int x1 = p.getX();
			int y1 = p.getY();
			if (x1 > 0 && y1 > 0 && x1 < image.getWidth() && y1 < image.getHeight() && image.getRGB(x1, y1) == source) {
				image.setRGB(x1, y1, target.getRGB());
				addFourSides(x1, y1, source, queue);
			}
		}
	}

	private void addFourSides(int x, int y, int source, Queue<Point> queue) {
		addSide(x + 1, y, source, queue);
		addSide(x - 1, y, source, queue);
		addSide(x, y + 1, source, queue);
		addSide(x, y - 1, source, queue);
	}

	private void addSide(int x, int y, int source, Queue<Point> queue) {
		queue.add(new Point(x, y));
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}
}
