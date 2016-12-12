package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Brick {

	int x, y, width, height;
	Image image;
	String brick = GameConfig.getBrick();
	String[] coloredBricks = GameConfig.getColoredBricks();
	boolean dead;

	public Brick(int x, int y) {
		this.x = x;
		this.y = y;

		Random r = new Random();
		image = (new ImageIcon(coloredBricks[r.nextInt(7)])).getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		dead = false;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle returnRectangleObj() {
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}
