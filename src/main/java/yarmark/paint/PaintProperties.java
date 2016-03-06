package yarmark.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PaintProperties {
	private BufferedImage image;
	private Color color;
	private int weight;
	private boolean fill;
	private int width;
	private int height;

	public PaintProperties() {
		this.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.RED;
	}

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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
