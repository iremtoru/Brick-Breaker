package Model;

public class GameConfig {
	private static final String STICK = "images_paddle.jpg";
	private static final String BALL = "images_ball.png";
	private static final String BRICK = "images_brick.png";
	private static final String[] COLORED_BRICKS = new String[] { "images1.png", "images2.png", "images3.png",
			"images4.png", "images5.png", "images6.png", "images7.png" };
	private static final int NO_OF_ROWS = 5;
	private static final int NO_OF_COLUMNS = 5;
	private static final int NO_OF_BRICKS = NO_OF_ROWS * NO_OF_COLUMNS;
	private static final int WIDTH = NO_OF_COLUMNS * 50;
	private static final int HEIGHT = 400;
	private static final int WINX = 400;
	private static final int WINY = 200;
	private static final int GAME_BOTTOM_BORDER = HEIGHT + 10;
	private static final int STICK_RIGHT = WIDTH - 40;
	private static final int BALL_RIGHT = WIDTH - 20;
	private static final String WINMSG = "You Win :)";
	private static final String LOOSEMSG = "Game Over!";
	private static final int SPEED = 8; // the speed increases if you decrease
										// this number.
	private static final int KEYSPEED = 1;
	private static final int STICKPARTSIZE = 5;
	
	public static String getBall() {
		return BALL;
	}

	public static int getBallRight() {
		return BALL_RIGHT;
	}

	public static int getBottom() {
		return GAME_BOTTOM_BORDER;
	}

	public static String getBrick() {
		return BRICK;
	}

	public static String[] getColoredBricks() {
		return COLORED_BRICKS;
	}

	public static int getGameBottomBorder() {
		return GAME_BOTTOM_BORDER;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public static int getkeySpeed() {
		return KEYSPEED;
	}

	public static int getKeyspeed() {
		return KEYSPEED;
	}

	public static String getLoosemsg() {
		return LOOSEMSG;
	}

	public static int getNoOfBricks() {
		return NO_OF_BRICKS;
	}

	public static int getNoOfColumns() {
		return NO_OF_COLUMNS;
	}

	public static int getNoOfRows() {
		return NO_OF_ROWS;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public static String getStick() {
		return STICK;
	}

	public static int getStickpartsize() {
		return STICKPARTSIZE;
	}

	public static int getStickRight() {
		return STICK_RIGHT;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static String getWinmsg() {
		return WINMSG;
	}

	public static int getWinx() {
		return WINX;
	}

	public static int getWiny() {
		return WINY;
	}

}
