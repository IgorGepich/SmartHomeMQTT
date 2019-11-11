package ui;

import java.awt.*;
import javax.swing.*;
import static constants.UiConstants.*;
import constants.UiConstants;

public class Bme280BalconyPanel {
	static JPanel balconyPanel = new JPanel(new FlowLayout());
	static JLabel temperatureLabel = new JLabel();
	static JLabel humidityLabel = new JLabel();
	static JLabel barometerLabel = new JLabel();

	public void createUIBme280Balcony(){
		balconyPanel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_BALCONY));

// TEMPERATURE
		temperatureLabel.setFont(UiConstants.FONT);
		temperatureLabel.setOpaque(true);
		temperatureLabel.setVerticalAlignment(JLabel.CENTER);
		temperatureLabel.setHorizontalAlignment(JLabel.CENTER);
		temperatureLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_TEMPERATURE));
		temperatureLabel.setPreferredSize(UiConstants.LABELSIZE);
		temperatureLabel.setIcon(new ImageIcon(TEMPERATURE_LABEL_IMAGE));
		balconyPanel.add(temperatureLabel);

// HUMIDITY
		humidityLabel.setFont(UiConstants.FONT);
		humidityLabel.setOpaque(true);
		humidityLabel.setVerticalAlignment(JLabel.CENTER);
		humidityLabel.setHorizontalAlignment(JLabel.CENTER);
		humidityLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_HUMIDITY));
		humidityLabel.setPreferredSize(LABELSIZE);
		humidityLabel.setIcon(new ImageIcon(HUMIDITY_LABEL_IMAGE));
		balconyPanel.add(humidityLabel);

// BAROMETER
		barometerLabel.setFont(FONT);
		barometerLabel.setOpaque(true);
		barometerLabel.setVerticalAlignment(JLabel.CENTER);
		barometerLabel.setHorizontalAlignment(JLabel.CENTER);
		barometerLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_BAROMETER));
		barometerLabel.setPreferredSize(LABELSIZE);
		barometerLabel.setIcon(new ImageIcon(BAROMETER_LABEL_IMAGE));
		balconyPanel.add(barometerLabel);

//		MainFrame.mainPanel.add(balconyPanel, BorderLayout.CENTER);

	}
}