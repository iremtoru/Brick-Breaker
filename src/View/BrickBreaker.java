package View;

import java.awt.Color;

/*
 *author: Idil Utkusoy
 */
import javax.swing.JFrame;

import Model.Game;
import Model.GameConfig;

public class BrickBreaker extends JFrame {
	private static final long serialVersionUID = 1L;

	public BrickBreaker() {
		add(new Game());
		setBackground(Color.black);
		setTitle("Brick Breaker");
		setSize(GameConfig.getWidth(), GameConfig.getHeight());
		setBounds(GameConfig.getWinx(), GameConfig.getWiny(), GameConfig.getWidth(), GameConfig.getHeight());
		setResizable(false);
		setVisible(true);
	}
}