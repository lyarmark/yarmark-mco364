package yarmark.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {
	private BufferedImage image;
	private Color color;
	private Stroke stroke;
	private boolean fill;
	private int width;
	private int height;

	public PaintProperties() {
		this.width = 800;
		this.height = 600;
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		this.stroke = new BasicStroke(6);
		this.fill = false;
		this.color = Color.black;
	}

	/*
	 * public PaintProperties(int width, int height, BufferedImage image, Color
	 * color, int weight, boolean fill) { this.width = width; this.height =
	 * height; this.image = image; this.color = color; this.weight = weight;
	 * this.fill = fill; }
	 */
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setWeight(int weight) {
		this.stroke = new BasicStroke(weight);
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
