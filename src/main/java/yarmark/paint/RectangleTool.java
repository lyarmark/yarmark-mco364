package yarmark.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectangleTool extends Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public RectangleTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		if (x1 > x2 && y1 > y2) {
			// Q2
			g.fillRect(x2, y2, x1 - x2, y1 - y2);
		}
		if (x2 > x1 && y1 > y2) {
			// Q1
			g.fillRect(x1, y2, x2 - x1, y1 - y2);
		}
		if (x1 > x2 && y2 > y1) {
			// Q3
			g.fillRect(x2, y1, x1 - x2, y2 - y1);
		}
		if (x2 > x1 && y2 > y1) {
			// Q4
			g.fillRect(x1, y1, x2 - x1, y2 - y1);
		}
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		if (x1 > x2 && y1 > y2) {
			// Q2
			g.fillRect(x2, y2, x1 - x2, y1 - y2);
		}
		if (x2 > x1 && y1 > y2) {
			// Q1
			g.fillRect(x1, y2, x2 - x1, y1 - y2);
		}
		if (x1 > x2 && y2 > y1) {
			// Q3
			g.fillRect(x2, y1, x1 - x2, y2 - y1);
		}
		if (x2 > x1 && y2 > y1) {
			// Q4
			g.fillRect(x1, y1, x2 - x1, y2 - y1);
		}
	}
}
