package Model;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Ball {
	int x, y, width, height;
	Image ballImage = null;
	int xDirection;
	int yDirection;
	String ballUrl = GameConfig.getBall();

	public Ball() {
		xDirection = 1;
		yDirection = -1;
		ballImage = (new ImageIcon(ballUrl)).getImage();
		width = ballImage.getWidth(null);
		height = ballImage.getHeight(null);
		resetState();
	}

	public String getBall() {
		return ballUrl;
	}

	public Image getBallImage() {
		return ballImage;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getYDir() {
		return yDirection;
	}

	public void move() {
		x += xDirection;
		y += yDirection;
		if (x == GameConfig.getBallRight()) {
			setXDir(-1);
		}
		if (x == 0) {
			setXDir(1);
		}
		if (y == 0) {
			setYDir(1);
		}
	}

	public void resetState() {
		x = GameConfig.getWinx() / 4;
		y = GameConfig.getWiny() + 100;
	}

	public Rectangle returnRectangleObj() {
		return new Rectangle(x, y, ballImage.getWidth(null), ballImage.getHeight(null));
	}

	public void setBall(String ball) {
		this.ballUrl = ball;
	}

	public void setBallImage(Image image) {
		this.ballImage = image;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setXDir(int x) {
		xDirection = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setYDir(int y) {
		yDirection = y;
	}

}
