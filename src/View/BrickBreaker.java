package View;

import java.awt.Color;
import javax.swing.JFrame;
import Model.Game;
import Model.GameConfig;



public class BrickBreaker extends JFrame {
	private static final long serialVersionUID = 1L;

	public BrickBreaker(Color color) {
		Game game = new Game();
		add(game);
		game.setBackground(color);
		setTitle("Brick Breaker");
		setSize(GameConfig.getWidth(), GameConfig.getHeight());
		setBounds(GameConfig.getWinx(), GameConfig.getWiny(), GameConfig.getWidth(), GameConfig.getHeight());
		setResizable(false);
		setVisible(true);
	}
	
	public BrickBreaker() {
		Game game = new Game();
		add(game);
		setTitle("Brick Breaker");
		setSize(GameConfig.getWidth(), GameConfig.getHeight());
		setBounds(GameConfig.getWinx(), GameConfig.getWiny(), GameConfig.getWidth(), GameConfig.getHeight());
		setResizable(false);
		setVisible(true);
	}
	
}