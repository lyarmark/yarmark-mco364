package yarmark.paint;

import java.awt.Graphics2D;

public abstract class Tool {

	protected PaintProperties properties;

	// passing in PaintProperties to classes that depend on it is called
	// dependency injection
	// the tool class depends on paint properties
	public Tool(PaintProperties properties) {
		this.properties = properties;
	}

	abstract void mousePressed(Graphics2D g, int x, int y);

	abstract void mouseReleased(Graphics2D g, int x, int y);

	abstract void mouseDragged(Graphics2D g, int x, int y);

	abstract void drawPreview(Graphics2D g);

}
