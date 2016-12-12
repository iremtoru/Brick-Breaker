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
	public JButton bgBackBtn;
	public JButton bgWhiteButton;
	public JButton bgGrayButton;
	public JButton bgPinkButton;
	public JButton speedOption1Button;
	public JButton speedOption2Button;
	public JButton speedOption3Button;

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
		s.setBounds(294, 100, 50, 20);

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
		// TODO Auto-generated method stub
		musicSettingPanel = new JPanel();
		JLabel music = new JLabel("music");
		musicSettingPanel.add(music);
		
		musicBackBtn = new JButton("<-Back");
		musicBackBtn.setBounds(10, 380, 150, 30);
		musicBackBtn.addActionListener(controller);
		musicBackBtn.setBackground(new Color(204, 255, 255));
		musicSettingPanel.add(musicBackBtn);
	}

	private void prepareSpeedChangePanel() {
		// TODO Auto-generated method stub
		speedChangePanel = new JPanel();
		JLabel speed = new JLabel("speed");
		speedChangePanel.add(speed);
		
		speedBackBtn = new JButton("<-Back");
		speedBackBtn.setBounds(10, 380, 150, 30);
		speedBackBtn.addActionListener(controller);
		speedBackBtn.setBackground(new Color(204, 255, 255));
		speedChangePanel.add(speedBackBtn);
		
		speedOption1Button = new JButton("Speed: 1.5");
		speedOption1Button.addActionListener(controller);
		speedChangePanel.add(speedOption1Button);
		
		speedOption2Button = new JButton("Speed: 2");
		speedOption2Button.addActionListener(controller);
		speedChangePanel.add(speedOption2Button);
		
		speedOption3Button = new JButton("Speed: 2.5");
		speedOption3Button.addActionListener(controller);
		speedChangePanel.add(speedOption3Button);
	}

	private void prepareBGChangePanel() {
		// TODO Auto-generated method stub
		BGChangePanel = new JPanel();
		JLabel bg = new JLabel("bg");
		BGChangePanel.add(bg);
		
		bgBackBtn = new JButton("<-Back");
		bgBackBtn.setBounds(10, 380, 150, 30);
		bgBackBtn.addActionListener(controller);
		BGChangePanel.add(bgBackBtn);
		
		bgWhiteButton = new JButton("White");
		bgWhiteButton.addActionListener(controller);
		BGChangePanel.add(bgWhiteButton);
		
		bgGrayButton = new JButton("Gray");
		bgGrayButton.addActionListener(controller);
		BGChangePanel.add(bgGrayButton);
		
		bgPinkButton = new JButton("Pink");
		bgPinkButton.addActionListener(controller);
		BGChangePanel.add(bgPinkButton);
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
		mainPanel.add(musicSettingPanel, "panel 4");
		mainPanel.add(speedChangePanel, "panel 5");
		mainPanel.add(BGChangePanel, "panel 6");

		frame.getContentPane().add(mainPanel);
	}
}
