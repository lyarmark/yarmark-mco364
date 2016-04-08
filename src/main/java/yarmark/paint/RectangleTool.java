package yarmark.paint;

import java.awt.Graphics2D;

public class RectangleTool extends Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public RectangleTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
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
		int xStart = Math.min(x1, x2);
		int yStart = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		g.fillRect(xStart, yStart, width, height);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		int xStart = Math.min(x1, x2);
		int yStart = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		g.fillRect(xStart, yStart, width, height);
	}
}
