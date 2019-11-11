package ui;

import constants.UiConstants;

import javax.swing.*;
import java.awt.*;

public class SwitchPanel {
	static JPanel switchPanel = new JPanel(new FlowLayout());

	public void createUISwitch(){
		switchPanel.setBorder(BorderFactory.createTitledBorder(UiConstants.BORDER_TITLE_SWITCH));

	}
}
