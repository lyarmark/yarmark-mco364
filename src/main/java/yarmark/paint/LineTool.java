package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;

public class LineTool implements Tool {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.green);
		g.drawLine(x1, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.pink);
		g.drawLine(x1, y1, x2, y2);
	}
}
