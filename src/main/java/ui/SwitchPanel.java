package ui;

import sw.Lamp;
import sw.LampFlora;
import sw.LampPlus;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static constants.UiConstants.BORDER_TITLE_SWITCH;
import static constants.UiConstants.BUTTON_LABELSIZE;

public class SwitchPanel {
	static JPanel switchPanel = new JPanel(new FlowLayout());
	LampPlus.LampPlusListener lampPlusListener = new LampPlus.LampPlusListener();
	Lamp.LampListener lampListener = new Lamp.LampListener();
	LampFlora.FloraLampListener floraLampListener = new LampFlora.FloraLampListener();

	public void createUISwitch(){
		switchPanel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_SWITCH));

		/**
		 * Lamp + Button area
		 */
		JToggleButton lampPlusPowerButton = new JToggleButton("Lamp+");
		lampPlusPowerButton.setVerticalAlignment(JLabel.CENTER);
		lampPlusPowerButton.setHorizontalAlignment(JLabel.CENTER);
		lampPlusPowerButton.setPreferredSize(BUTTON_LABELSIZE);
		lampPlusPowerButton.addActionListener(lampPlusListener);
//
		lampPlusPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				String buttonText = (lampPlusPowerButton.isSelected()) ? "Lamp+" : "Lamp+";
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
		lampPowerButton.setVerticalAlignment(JLabel.CENTER);
		lampPowerButton.setHorizontalAlignment(JLabel.CENTER);
		lampPowerButton.setPreferredSize(BUTTON_LABELSIZE);
//		lampPowerButton.setIcon(new ImageIcon(TEMPERATURE_LABEL_IMAGE)); // SET IMAGE
		lampPowerButton.addActionListener(lampListener);

		lampPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String buttonText = (lampPowerButton.isSelected()) ? "Lamp" : "Lamp";
				lampPowerButton.setText(buttonText);

			}
		});
// TODO StateChanged
		lampPowerButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

			}
		});
		/**
		 * END Lamp Button area
		 */

		/**
		 * Flora Lamp Button area
		 */
		JToggleButton floraLampButton = new JToggleButton("FloraLamp");
		floraLampButton.setHorizontalAlignment(JLabel.CENTER);
		floraLampButton.setVerticalAlignment(JLabel.CENTER);
		floraLampButton.setPreferredSize(BUTTON_LABELSIZE);
		floraLampButton.addActionListener(floraLampListener);

		floraLampButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String buttonText = (floraLampButton.isSelected()) ? "Lamp" : "Lamp";
				floraLampButton.setText(buttonText);
			}
		});
		/**
		 * END Flora Lamp Button area
		 */

		switchPanel.add(lampPowerButton);
		switchPanel.add(lampPlusPowerButton);
		switchPanel.add(floraLampButton);
	}
}
