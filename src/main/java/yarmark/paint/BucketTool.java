package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	private BufferedImage image;

	// public BucketTool(BufferedImage image) {
	// this.image = image;
	// }

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		fill(x, y, g.getColor(), Color.black);
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

	public void fill(int x, int y, Color source, Color target) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			// queue.add(e)
		}
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}
}
