package ui;

/**
 * @class MainFrame creates UI frames and panels
 */
import constants.UiConstants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame implements Runnable{
	private JPanel mainPanel = new JPanel();

	@Override
	public void run() {

		/**
		 *Creating new Panels
		 */
		Bme280BalconyPanel balcony = new Bme280BalconyPanel();
		balcony.createUIBme280Balcony();

		Bme280RoomPanel roomPanel = new Bme280RoomPanel();
		roomPanel.createUIRoom();

		SwitchPanel switchPanel = new SwitchPanel();
		switchPanel.createUISwitch();

		/**
		 * Basic Frame preferences
		 */
		JFrame basicFrame = new JFrame();
		basicFrame.setVisible(true);
		basicFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		basicFrame.setBounds(400, 250, 800, 500);
		basicFrame.setLocationRelativeTo(null);// center
		basicFrame.setTitle(UiConstants.PROGRAM_TITLE);

		/**
		 * JMenu
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu mainMenu = new JMenu("Menu");
		//EXIT Item
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		//End Exit Item
		JMenuItem settingsItem = new JMenuItem("Settings");
		mainMenu.add(settingsItem);
		mainMenu.add(exitItem);
		menuBar.add(mainMenu);

		/**
		 * Add panels on the MainFrame
		 */
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(Bme280BalconyPanel.balconyPanel, BorderLayout.NORTH);
		mainPanel.add(Bme280RoomPanel.roomPanel, BorderLayout.CENTER);
		mainPanel.add(SwitchPanel.switchPanel, BorderLayout.SOUTH);

		basicFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		/**
		 * Add MenuBar on the Frame
		 */
		basicFrame.setJMenuBar(menuBar);
	}
}
