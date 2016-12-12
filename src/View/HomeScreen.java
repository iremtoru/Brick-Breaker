package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;

import javax.swing.ImageIcon;

public class HomeScreen {
	public final JPanel mainPanel = new JPanel();
	private JFrame frame;
	private JPanel buttonPanel;
	private JPanel settingsPanel;
	private JPanel helpMenuPanel;
	private Controller controller;
	public JButton btnStart;
	public JButton btnSettings;
	public JButton btnHelpMenu;
	public JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeScreen() {
		controller = new Controller(this);

		prepareGUI();
	}

	private void prepareGUI() {
		frame = new JFrame("**Brick Breaker**");
		frame.setBounds(400, 100, 650, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		preparePanels();
	}

	private void preparePanels() {
		prepareButtonPanel();
		prepareSettingsPanel();
		prepareHelpMenuPanel();
		prepareMainPanel();
	}

	private void prepareButtonPanel() {
		buttonPanel = new JPanel();

		btnStart = new JButton("Start");
		btnStart.addActionListener(controller);
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setBackground(new Color(240, 128, 128));
		btnStart.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnStart.setBounds(245, 101, 150, 48);
		btnStart.setSize(150, 48);

		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(controller);
		btnSettings.setBackground(new Color(255, 255, 224));
		btnSettings.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSettings.setBounds(245, 166, 150, 48);

		btnHelpMenu = new JButton("Help Menu");
		btnHelpMenu.addActionListener(controller);
		btnHelpMenu.setForeground(new Color(0, 0, 0));
		btnHelpMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnHelpMenu.setBackground(new Color(255, 222, 173));
		btnHelpMenu.setBounds(245, 235, 150, 48);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(controller);
		btnExit.setBackground(new Color(224, 255, 255));
		btnExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnExit.setBounds(245, 300, 150, 48);

		buttonPanel.add(btnStart);
		buttonPanel.add(btnSettings);
		buttonPanel.add(btnHelpMenu);
		buttonPanel.add(btnExit);
	}

	private void prepareSettingsPanel() {
		// add contents of the panel
		settingsPanel = new JPanel();

		JLabel s = new JLabel("SETTINGS PAGE...");

		settingsPanel.add(s);
	}

	private void prepareHelpMenuPanel() {
		// add contents of the panel
		helpMenuPanel = new JPanel();

		JLabel helpInfo = new JLabel("Help Info goes here.");

		helpMenuPanel.add(helpInfo);
	}

	private void prepareMainPanel() {
		mainPanel.setSize(650, 600);

		CardLayout layout = new CardLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		mainPanel.setLayout(layout);
		layout.show(mainPanel, "panel 1");

		mainPanel.add(buttonPanel, "panel 1");
		mainPanel.add(settingsPanel, "panel 2");
		mainPanel.add(helpMenuPanel, "panel 3");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("wall.jpg"));
		lblNewLabel.setBounds(0, 0, 650, 600);
		frame.getContentPane().add(lblNewLabel);

		frame.add(mainPanel);
	}
}
