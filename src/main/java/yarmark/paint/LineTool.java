package yarmark.paint;

import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool extends Tool {

	// every class gets its own logger
	// param should be a unique name associated with the class
	private static final Logger LOG = Logger.getLogger(LineTool.class.getName());
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public LineTool(PaintProperties properties) {
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
		g.drawLine(x1, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		// deliberate mistake to show logging
		// testing this with the debugger interrupts it
		// g.drawLine(x1, y1, x2, x2);
		// System.out.println(String.format("%d %d %d %d", x1, y1, x2, y2));

		g.drawLine(x1, y1, x2, y2);

		String logMessage = (String.format("%d %d %d %d", x1, y1, x2, y2));
		LOG.fine(logMessage);
		// different levels of logging
		// https://docs.oracle.com/javase/6/docs/api/java/util/logging/Level.html
	}
}
