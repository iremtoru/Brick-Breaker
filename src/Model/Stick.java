package Model;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Stick {
	int x, y, width, height;
	Image image;
	String paddle = GameConfig.getStick();
	int prevX = 0;
	int dx;

	public Stick() {
		ImageIcon ii = new ImageIcon(paddle);
		image = ii.getImage();

		width = image.getWidth(null);
		height = image.getHeight(null);

		resetState();
	}

	public void move() {

		int mouseX = MouseInfo.getPointerInfo().getLocation().x - (GameConfig.getWinx() + 20);
		if (mouseX != prevX) {
			x = mouseX;
			prevX = mouseX;
		} else
			x += dx;
		if (x <= 2)
			x = 2;
		if (x >= GameConfig.getStickRight())
			x = GameConfig.getStickRight();
	}

	public void resetState() {
		x = GameConfig.getWidth() / 2;
		y = (int) (GameConfig.getHeight() * 0.8);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Rectangle returnRectangleObj() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
}
