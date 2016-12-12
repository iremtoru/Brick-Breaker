package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	Image imageBoard;
	String message;
	Ball ball;
	Stick gameStick;
	Brick bricks[];
	boolean msgShown = false;
	boolean gameInProgress = true;
	GameIteration gameIter = null;

	public Game() {
		addKeyListener(new MyKeyListener());
		setFocusable(true);
		message = GameConfig.getLoosemsg();
		bricks = new Brick[GameConfig.getNoOfBricks()];
	}

	public void checkCollision() {

		if (ball.returnRectangleObj().getMaxY() > GameConfig.getBottom()) {
			stopGame();
		}

		int deadBrickCnt = 1;
		for (int i = 0; i < GameConfig.getNoOfBricks(); i++) {
			// System.out.println(deadBrickCnt + " " +
			// GameConfig.getNoOfBricks());
			if (deadBrickCnt == GameConfig.getNoOfBricks()) {
				if (!msgShown) {
					gameIter.stopThread();
					System.out.println("win");
					message = GameConfig.getWinmsg();
					JOptionPane.showMessageDialog(this, message);
					msgShown = true;
					System.exit(0);
				}
				stopGame();
			}
			if (bricks[i].isDead())
				deadBrickCnt++;
		}

		Rectangle gameStickRect = gameStick.returnRectangleObj();
		Rectangle ballRect = ball.returnRectangleObj();
		if (gameStickRect.intersects(ballRect)) {
			int stickLPos = (int) gameStickRect.getMinX();
			int ballLPos = (int) ballRect.getMinX();
			int stickPart1 = stickLPos + GameConfig.getStickpartsize();
			int stickPart2 = stickLPos + GameConfig.getStickpartsize() * 2;
			int stickPart3 = stickLPos + GameConfig.getStickpartsize() * 3;
			int stickPart4 = stickLPos + GameConfig.getStickpartsize() * 4;

			if (ballLPos < stickPart1) {
				ball.setXDir(-1);
				ball.setYDir(-1);
			} else if (ballLPos > stickPart4) {
				ball.setXDir(1);
				ball.setYDir(-1);
			} else if (ballLPos >= stickPart2 && ballLPos < stickPart3) {
				ball.setXDir(0);
				ball.setYDir(-1);
			} else if (ballLPos >= stickPart1 && ballLPos < stickPart2) {
				ball.setXDir(-1);
				int ydir = ball.getYDir();
				ball.setYDir(-1 * ydir);
			} else if (ballLPos >= stickPart3 && ballLPos < stickPart4) {
				ball.setXDir(1);
				int ydir = ball.getYDir();
				ball.setYDir(-1 * ydir);
			}
		}

		for (int i = 0; i < GameConfig.getNoOfBricks(); i++) {
			Rectangle curBrickRect = bricks[i].returnRectangleObj();
			if (ballRect.intersects(curBrickRect)) {
				int ballLeft = (int) ballRect.getMinX();
				int ballTop = (int) ballRect.getMinY();
				int ballHeight = (int) ballRect.getHeight();
				int ballWidth = (int) ballRect.getWidth();

				Point ballPointRight = new Point(ballLeft + ballWidth + 1, ballTop);
				Point ballPointLeft = new Point(ballLeft - 1, ballTop);
				Point ballPointTop = new Point(ballLeft, ballTop - 1);
				Point ballPointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

				if (!bricks[i].isDead()) {
					bricks[i].setDead(true);
					if (curBrickRect.contains(ballPointRight))
						ball.setXDir(-1);
					else if (curBrickRect.contains(ballPointLeft))
						ball.setXDir(1);
					if (curBrickRect.contains(ballPointTop))
						ball.setYDir(1);
					else if (curBrickRect.contains(ballPointBottom))
						ball.setYDir(-1);
				}
			}
		}
	}

	public void gameLogic() {
		ball = new Ball();
		gameStick = new Stick();
		int brickCnt = 0;
		int x = 0, y = 0;
		for (int i = 0; i < GameConfig.getNoOfColumns(); i++) {
			for (int j = 0; j < GameConfig.getNoOfRows(); j++) {
				x = j * 40 + GameConfig.getNoOfBricks();
				y = i * 10 + 50;
				bricks[brickCnt] = new Brick(x, y);
				brickCnt++;
			}
		}
		gameIter = new GameIteration();
		gameIter.start();
	}

	public void addNotify() {
		super.addNotify();
		gameLogic();
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (gameInProgress) {
			g.drawImage(ball.getBallImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this); // ball
			g.drawImage(gameStick.getImage(), gameStick.getX(), gameStick.getY(), gameStick.getWidth(),
					gameStick.getHeight(), this); // stick

			for (int i = 0; i < GameConfig.getNoOfBricks(); i++) {
				if (!bricks[i].isDead())
					g.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), bricks[i].getWidth(),
							bricks[i].getHeight(), this); // bricks
			}
		} else {
			if (!msgShown) {
				gameIter.stopThread();
				System.out.println("game over");
				msgShown = true;
				JOptionPane.showMessageDialog(this, message);
				System.exit(0);
			}
		}
		// g.dispose(); // to release resources
	}

	public void stopGame() {
		gameInProgress = false;

	}

	private class GameIteration extends Thread {
		boolean stopCondition = false;

		public void run() {

			while (!stopCondition) {
				ball.move();
				gameStick.move();
				checkCollision();
				repaint();
				try {
					sleep(GameConfig.getSpeed());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void stopThread() {
			stopCondition = true;
		}
	}

	private class MyKeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			int dx = gameStick.getDx();
			if (key == KeyEvent.VK_LEFT) {
				dx = -GameConfig.getkeySpeed();
			}
			if (key == KeyEvent.VK_RIGHT) {
				dx = GameConfig.getkeySpeed();
			}
			gameStick.setDx(dx);
		}

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			int dx = gameStick.getDx();
			if (key == KeyEvent.VK_LEFT) {
				dx = 0;
			}
			if (key == KeyEvent.VK_RIGHT) {
				dx = 0;
			}
			gameStick.setDx(dx);
		}
	}
}
