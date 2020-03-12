package constants;

import java.awt.*;

public class UiConstants {
	public static final String PROGRAM_TITLE = "MQTT Smarthome v.2.0";
	public static final Font FONT = new Font("Serif", Font.BOLD, 22);
	public static final String DEGREE  = " C\u00b0";
	public static final String HUMIDITY = " %";
	public static final String BAROMETER = " hPa";

	public static final Dimension LABELSIZE = new Dimension(180, 80);
	public static final Dimension BUTTON_LABELSIZE = new Dimension(140, 60);

	public static final String BORDER_TITLE_BALCONY = "Balcony";
	public static final String BORDER_TITLE_ROOM = "Room";
	public static final String BORDER_TITLE_SWITCH = "Switch";
	public static final String BORDER_TITLE_TEMPERATURE = "Temperature";
	public static final String BORDER_TITLE_HUMIDITY = "Humidity";
	public static final String BORDER_TITLE_BAROMETER = "Barometer";

	public static final String BORDER_TITLE_DS_OUTDOOR = "DS Outdoor Temp";

	public static final String TEMPERATURE_LABEL_IMAGE = "./src/main/resources/images/tempIcon.png";
	public static final String HUMIDITY_LABEL_IMAGE = "./src/main/resources/images/humiIcon.png";
	public static final String BAROMETER_LABEL_IMAGE = "./src/main/resources/images/baroIcon.png";

	/**
	 * Local IP Address
	 */
	//	public static final String IP_ADDRESS = "tcp://10.0.1.7:1883";
	/**
	 * External IP Address
	 */
	public static final String IP_ADDRESS = "tcp://77.122.9.2:1883";


	//TODO
	/**
	 * Sensor Location
	 */
	public static final String LOCATION_ROOM = "room";
	public static final String LOCATION_BALCONY = "balcony";
	public static final String LOCATION_OUTDOOR = "outdoor";

}
