package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.Controller;
import Model.Music;

import javax.swing.ImageIcon;

public class HomeScreen {
	public final JPanel mainPanel = new JPanel();
	private JFrame frame;
	private JPanel buttonPanel;
	public JPanel settingsPanel;
	private JPanel helpMenuPanel;
	public JPanel musicSettingPanel;
	public JPanel speedChangePanel;
	public JPanel BGChangePanel;
	private Controller controller;
	public JButton btnStart;
	public JButton btnSettings;
	public JButton btnHelpMenu;
	public JButton btnExit;
	public JButton BGChangeButton;
	public JButton musicSettingButton;
	public JButton speedChangeButton;
	public JButton backButton;
	public JButton musicBackBtn;
	public JButton speedBackBtn;
	public JButton helpBackBtn;
	public JButton bgBackBtn;
	public JButton bgWhiteButton;
	public JButton bgGrayButton;
	public JButton bgPinkButton;
	public JButton speedOption1Button;
	public JButton speedOption2Button;
	public JButton speedOption3Button;
	public JButton btnOn;
	public Music music;

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
		music = new Music();
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
		prepareMusicSettingPanel();
		prepareSpeedChangePanel();
		prepareBGChangePanel();
		prepareMainPanel();

	}

	private void prepareButtonPanel() {
		buttonPanel = new JPanel();

		btnStart = new JButton("Start");
		btnStart.addActionListener(controller);
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.setBackground(new Color(240, 128, 128));
		btnStart.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnStart.setBounds(240, 150, 150, 30);

		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(controller);
		btnSettings.setBackground(new Color(255, 255, 224));
		btnSettings.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSettings.setBounds(240, 200, 150, 30);

		btnHelpMenu = new JButton("Help Menu");
		btnHelpMenu.addActionListener(controller);
		btnHelpMenu.setForeground(new Color(0, 0, 0));
		btnHelpMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnHelpMenu.setBackground(new Color(255, 222, 173));
		btnHelpMenu.setBounds(240, 250, 150, 30);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(controller);
		btnExit.setBackground(new Color(224, 255, 255));
		btnExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnExit.setBounds(240, 300, 150, 30);
		buttonPanel.setLayout(null);

		buttonPanel.add(btnStart);
		buttonPanel.add(btnSettings);
		buttonPanel.add(btnHelpMenu);
		buttonPanel.add(btnExit);
	}

	private void prepareSettingsPanel() {
		settingsPanel = new JPanel();

		musicSettingButton = new JButton("Music Settings");
		musicSettingButton.setBounds(240, 150, 150, 30);
		musicSettingButton.addActionListener(controller);
		musicSettingButton.setBackground(new Color(224, 255, 255));
		musicSettingButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

		speedChangeButton = new JButton("Change Speed");
		speedChangeButton.setBounds(240, 200, 150, 30);
		speedChangeButton.addActionListener(controller);
		speedChangeButton.setBackground(new Color(224, 255, 255));
		speedChangeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

		BGChangeButton = new JButton("Change Backround");
		BGChangeButton.setBounds(240, 250, 150, 30);
		BGChangeButton.addActionListener(controller);
		BGChangeButton.setBackground(new Color(224, 255, 255));
		BGChangeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

		JLabel s = new JLabel("SETTINGS");
		s.setBounds(294, 100, 70, 20);

		backButton = new JButton("<-Back");
		backButton.setBounds(10, 380, 150, 30);
		backButton.addActionListener(controller);
		backButton.setBackground(new Color(204, 255, 255));
		settingsPanel.setLayout(null);

		settingsPanel.add(s);
		settingsPanel.add(musicSettingButton);
		settingsPanel.add(speedChangeButton);
		settingsPanel.add(BGChangeButton);
		settingsPanel.add(backButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 604, 531);
		settingsPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("wall.jpg"));

	}

	private void prepareMusicSettingPanel() {
		musicSettingPanel = new JPanel();
		musicSettingPanel.setLayout(null);

		JLabel musicLabel = new JLabel("Music On/Off");
		musicLabel.setBounds(278, 99, 110, 20);

		musicBackBtn = new JButton("<-Back");
		musicBackBtn.setBounds(10, 380, 150, 30);
		musicBackBtn.addActionListener(controller);
		musicBackBtn.setBackground(new Color(204, 255, 255));

		btnOn = new JButton("On");
		btnOn.addActionListener(controller);
		btnOn.setBackground(new Color(240, 128, 128));
		btnOn.setBounds(240, 150, 150, 30);

		musicSettingPanel.add(musicLabel);
		musicSettingPanel.add(btnOn);
		musicSettingPanel.add(musicBackBtn);
	}

	private void prepareSpeedChangePanel() {
		speedChangePanel = new JPanel();
		speedChangePanel.setLayout(null);
		JLabel speed = new JLabel("Speed");
		speed.setBounds(294, 100, 70, 20);
		speedChangePanel.add(speed);

		speedBackBtn = new JButton("<-Back");
		speedBackBtn.setBounds(10, 380, 150, 30);
		speedBackBtn.addActionListener(controller);
		speedBackBtn.setBackground(new Color(204, 255, 255));
		speedChangePanel.add(speedBackBtn);

		speedOption1Button = new JButton("Speed: 1.5");
		speedOption1Button.setBackground(new Color(240, 128, 128));
		speedOption1Button.setBounds(240, 150, 150, 30);
		speedOption1Button.addActionListener(controller);
		speedChangePanel.add(speedOption1Button);

		speedOption2Button = new JButton("Speed: 2");
		speedOption2Button.setBackground(new Color(240, 128, 128));
		speedOption2Button.setBounds(240, 200, 150, 30);
		speedOption2Button.addActionListener(controller);
		speedChangePanel.add(speedOption2Button);

		speedOption3Button = new JButton("Speed: 2.5");
		speedOption3Button.setBackground(new Color(240, 128, 128));
		speedOption3Button.setBounds(240, 250, 150, 30);
		speedOption3Button.addActionListener(controller);
		speedChangePanel.add(speedOption3Button);
	}

	private void prepareBGChangePanel() {
		BGChangePanel = new JPanel();
		BGChangePanel.setLayout(null);
		JLabel bg = new JLabel("Background");
		bg.setBounds(294, 100, 100, 20);
		BGChangePanel.add(bg);

		bgBackBtn = new JButton("<-Back");
		bgBackBtn.setBackground(new Color(204, 255, 255));
		bgBackBtn.setBounds(10, 380, 150, 30);
		bgBackBtn.addActionListener(controller);
		BGChangePanel.add(bgBackBtn);

		bgWhiteButton = new JButton("White");
		bgWhiteButton.setBounds(240, 150, 150, 30);
		bgWhiteButton.setBackground(new Color(255, 255, 255));
		bgWhiteButton.addActionListener(controller);
		BGChangePanel.add(bgWhiteButton);

		bgGrayButton = new JButton("Gray");
		bgGrayButton.setBackground(new Color(192, 192, 192));
		bgGrayButton.setBounds(240, 200, 150, 30);
		bgGrayButton.addActionListener(controller);
		BGChangePanel.add(bgGrayButton);

		bgPinkButton = new JButton("Pink");
		bgPinkButton.setBackground(new Color(255, 105, 180));
		bgPinkButton.setBounds(240, 250, 150, 30);
		bgPinkButton.addActionListener(controller);
		BGChangePanel.add(bgPinkButton);
	}

	private void prepareHelpMenuPanel() {
		helpMenuPanel = new JPanel();
		helpMenuPanel.setLayout(null);

		String text = "You can play the game with both arrow keys and the mouse. You can change background color of the game, play/stop the music, change the speed of the ball via Settings Menu";
		JLabel helpInfo = new JLabel("<html>" + text + "</html>");
		helpInfo.setBounds(230, 10, 200, 500);
		helpMenuPanel.add(helpInfo);
		
		helpBackBtn = new JButton("<-Back");
		helpBackBtn.setBackground(new Color(204, 255, 255));
		helpBackBtn.setBounds(10, 380, 150, 30);
		helpBackBtn.addActionListener(controller);
		helpMenuPanel.add(helpBackBtn);
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
		mainPanel.add(musicSettingPanel, "panel 4");
		mainPanel.add(speedChangePanel, "panel 5");
		mainPanel.add(BGChangePanel, "panel 6");

		frame.getContentPane().add(mainPanel);
	}
}
