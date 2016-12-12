package Controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
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
				|| e.getSource() == view.bgBackBtn) {
			cardLayout.show(view.mainPanel, "panel 2");
		}
	}
}
