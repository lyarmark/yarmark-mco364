package yarmark.paint;

import java.awt.Graphics;

public interface Tool {

	// by definition, all methods of an interface are public
	void mousePressed(Graphics g, int x, int y);

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);
	
	void drawPreview(Graphics g);

}