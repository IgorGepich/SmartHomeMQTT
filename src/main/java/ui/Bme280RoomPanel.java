package ui;

import java.awt.*;
import javax.swing.*;
import static constants.UiConstants.*;

public class Bme280RoomPanel {
	//TODO static
	static JPanel roomPanel = new JPanel(new FlowLayout());
	static JLabel roomTemperatureLabel = new JLabel();
	static JLabel roomHumidityLabel = new JLabel();
	static JLabel roomBarometerLabel = new JLabel();

	//Image Area
//	private final String imageLocation = "img/tempIcon.png";
//	Image image = ImageIO.read(new File(imageLocation));
//
//	public Bme280RoomPanel() throws IOException {
//		try {
//			image = ImageIO.read(new File(imageLocation));
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//			System.out.println("NO IMAGE DETECTED");
//		}
//	}
//	Image resizedImage =
//			image.getScaledInstance(roomTemperatureLabel.getWidth(), roomTemperatureLabel.getHeight(), 5);

//End Image Area


	public void createUIRoom(){
		roomPanel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_ROOM));

		roomTemperatureLabel.setFont(FONT);
		roomTemperatureLabel.setOpaque(true);
		roomTemperatureLabel.setVerticalAlignment(JLabel.CENTER);
		roomTemperatureLabel.setHorizontalAlignment(JLabel.CENTER);
		roomTemperatureLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_TEMPERATURE));
		roomTemperatureLabel.setPreferredSize(LABELSIZE);
		roomTemperatureLabel.setIcon(new ImageIcon(TEMPERATURE_LABEL_IMAGE));
		roomPanel.add(roomTemperatureLabel);

		roomHumidityLabel.setFont(FONT);
		roomHumidityLabel.setOpaque(true);
		roomHumidityLabel.setVerticalAlignment(JLabel.CENTER);
		roomHumidityLabel.setHorizontalAlignment(JLabel.CENTER);
		roomHumidityLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_HUMIDITY));
		roomHumidityLabel.setPreferredSize(LABELSIZE);
		roomHumidityLabel.setIcon(new ImageIcon(HUMIDITY_LABEL_IMAGE));
		roomPanel.add(roomHumidityLabel);

		roomBarometerLabel.setFont(FONT);
		roomBarometerLabel.setOpaque(true);
		roomBarometerLabel.setVerticalAlignment(JLabel.CENTER);
		roomBarometerLabel.setHorizontalAlignment(JLabel.CENTER);
		roomBarometerLabel.setBorder(BorderFactory.createTitledBorder(BORDER_TITLE_BAROMETER));
		roomBarometerLabel.setPreferredSize(LABELSIZE);
		roomBarometerLabel.setIcon(new ImageIcon(BAROMETER_LABEL_IMAGE));
		roomPanel.add(roomBarometerLabel);
	}
}

