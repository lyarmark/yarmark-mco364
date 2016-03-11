package yarmark.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);

		// calling a method of a mock does nothing.
		// if it's supposed to return something, it returns the default of the
		// value. (ex: int =0)
		// so you can set the return value for testing purposes
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);

		Graphics g = Mockito.mock(Graphics.class);
		tool.mousePressed(g, 5, 4);
		tool.mouseReleased(g, 9, 10);

		// this is tedious, and draw line might do anti-aliasing to smooth the
		// picture
		// int rgb = image.getRGB(5, 5);
		// Assert.assertEquals(Color.black, rgb);

		// check that g.drawLine(5,5,10,10) was called
		// using mockito to get a mock graphics object
		Mockito.verify(g).drawLine(5, 4, 9, 10);

		// verfiy that color was set
		Mockito.verify(g).setColor(Color.RED);

	}

	public void testDrawPreview() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		LineTool tool = new LineTool(properties);

		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 5, 4);
		tool.mouseReleased(g, 9, 10);
		tool.drawPreview(g);
		Mockito.verify(g).drawLine(5, 4, 9, 10);

		// verfiy that color was set
		Mockito.verify(g).setColor(Color.RED);
	}
}
