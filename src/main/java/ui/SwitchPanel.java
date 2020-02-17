package ui;

import sw.Lamp;
import sw.LampPlus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static constants.UiConstants.*;

public class SwitchPanel {
	static JPanel switchPanel = new JPanel(new FlowLayout());
	private JLabel secondLabel = new JLabel();
	LampPlus.LampPlusListener lampPlusListener = new LampPlus.LampPlusListener();
	Lamp.LampListener lampListener = new Lamp.LampListener();

	public void createUISwitch(){
		switchPanel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_SWITCH));

		secondLabel.setFont(FONT);
		secondLabel.setOpaque(true);
		secondLabel.setVerticalAlignment(JLabel.CENTER);
		secondLabel.setHorizontalAlignment(JLabel.CENTER);
		secondLabel.setPreferredSize(LABELSIZE);
		switchPanel.add(secondLabel);

		/**
		 * Lamp + Button area
		 */
		JToggleButton lampPlusPowerButton = new JToggleButton("Lamp+");
		lampPlusPowerButton.addActionListener(lampPlusListener);
//
		lampPlusPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				String buttonText = (lampPlusPowerButton.isSelected()) ? "On" : "Off";
				lampPlusPowerButton.setText(buttonText);
			}
		});
		/**
		 * END Lamp + Button area
		 */

		/**
		 * Lamp Button area
		 */

		JToggleButton lampPowerButton = new JToggleButton("Lamp");
		lampPowerButton.addActionListener(lampListener);

		lampPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String buttonText = (lampPowerButton.isSelected()) ? "Lamp" : "Lamp";
				lampPowerButton.setText(buttonText);
			}
		});

		/**
		 * END Lamp Button area
		 */
//
		switchPanel.add(lampPowerButton);
		switchPanel.add(lampPlusPowerButton);

	}
}
