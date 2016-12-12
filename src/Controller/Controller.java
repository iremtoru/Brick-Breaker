package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.BrickBreaker;
import View.HomeScreen;

public class Controller implements ActionListener {
	private HomeScreen view;

	public Controller(HomeScreen view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout) (view.mainPanel.getLayout());

		if (e.getSource() == view.btnStart) {
			new BrickBreaker();
		} else if (e.getSource() == view.btnSettings) {
			cardLayout.show(view.mainPanel, "panel 2");
		} else if (e.getSource() == view.btnHelpMenu) {
			cardLayout.show(view.mainPanel, "panel 3");
		} else if (e.getSource() == view.btnExit) {
			System.exit(0);
		} else if (e.getSource() == view.musicSettingButton) {
			cardLayout.show(view.mainPanel, "panel 4");
		} else if (e.getSource() == view.speedChangeButton) {
			cardLayout.show(view.mainPanel, "panel 5");
		} else if (e.getSource() == view.BGChangeButton) {
			cardLayout.show(view.mainPanel, "panel 6");
		} else if (e.getSource() == view.backButton) {
			cardLayout.show(view.mainPanel, "panel 1");
		} else if (e.getSource() == view.musicBackBtn || e.getSource() == view.speedBackBtn
				|| e.getSource() == view.bgBackBtn || e.getSource() == view.helpBackBtn) {
			cardLayout.show(view.mainPanel, "panel 2");
		} else if (e.getSource() == view.bgWhiteButton) {
			new BrickBreaker(Color.WHITE);
		} else if (e.getSource() == view.bgGrayButton) {
			new BrickBreaker(Color.lightGray);
		} else if (e.getSource() == view.bgPinkButton) {
			new BrickBreaker(Color.pink);
		} else if (e.getSource() == view.btnOn) {
			if (view.btnOn.getText() == "On") {
				view.btnOn.setText("Off");
				view.music.stopBackgroundSong();
			} else if (view.btnOn.getText() == "Off") {
				view.btnOn.setText("On");
				view.music.playBackgroundSong();
			}
		}
	}
}
