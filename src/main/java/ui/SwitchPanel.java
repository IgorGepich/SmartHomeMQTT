package ui;

import javax.swing.*;
import java.awt.*;

import static constants.UiConstants.*;

public class SwitchPanel {
	static JPanel switchPanel = new JPanel(new FlowLayout());
	private static JLabel secondLabel = new JLabel();

	public void createUISwitch(){
		switchPanel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_SWITCH));

		secondLabel.setFont(FONT);
		secondLabel.setOpaque(true);
		secondLabel.setVerticalAlignment(JLabel.CENTER);
		secondLabel.setHorizontalAlignment(JLabel.CENTER);
		secondLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_TEMPERATURE));
		secondLabel.setPreferredSize(LABELSIZE);
		switchPanel.add(secondLabel);

	}
}
