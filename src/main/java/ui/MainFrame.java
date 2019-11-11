package ui;

/**
 * @class MainFrame creates UI frames and panels
 */
import constants.UiConstants;
import java.awt.*;
import javax.swing.*;

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
		JFrame basicFrame = new JFrame(){};
		basicFrame.setVisible(true);
		basicFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		basicFrame.setBounds(400, 250, 800, 500);
		basicFrame.setLocationRelativeTo(null);// center
		basicFrame.setTitle(UiConstants.PROGRAM_TITLE);

		/**
		 * Add panels on the MainFrame
		 */
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(Bme280BalconyPanel.balconyPanel, BorderLayout.NORTH);
		mainPanel.add(Bme280RoomPanel.roomPanel, BorderLayout.CENTER);
		mainPanel.add(SwitchPanel.switchPanel, BorderLayout.SOUTH);

		basicFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		/**
		 * Data update timer
		 * DEPRECATED from class UpdateDataTimer
		 */
//		new UpdateDataTimer().updateTimer();
	}
}
