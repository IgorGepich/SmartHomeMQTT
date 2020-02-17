package constants;

import java.awt.*;

public class UiConstants {
	public static final String DEGREE  = " C\u00b0";
	public static final String PROGRAM_TITLE = "MQTT Smarthome Application v.1.2";
	public static final Font FONT = new Font("Serif", Font.BOLD, 22);
	public static final String HUMIDITY = " %";
	public static final String BAROMETER = " hPa";

	public static final Dimension LABELSIZE = new Dimension(180, 80);

	public static final String BORDER_TITLE_BALCONY = "Balcony";
	public static final String BORDER_TITLE_ROOM = "Room";
	public static final String BORDER_TITLE_SWITCH = "Switch";
	public static final String BORDER_TITLE_TEMPERATURE = "Temperature";
	public static final String BORDER_TITLE_HUMIDITY = "Humidity";
	public static final String BORDER_TITLE_BAROMETER = "Barometer";

//	public static final String LOCAL_IP_ADDRESS = "tcp://10.0.1.7:1883";
//	public static final String EXTERNAL_IP_ADDRESS = "tcp://77.122.9.2:1883";

	public static final String TEMPERATURE_LABEL_IMAGE = "../img/tempIcon.png";
	public static final String HUMIDITY_LABEL_IMAGE = "../img/humiIcon.png";
	public static final String BAROMETER_LABEL_IMAGE = "../img/baroIcon.png";

	/**
	 * Local IP Address
	 */
//	public static final String IP_ADDRESS = "tcp://10.0.1.7:1883";
	/**
	 * External IP Address
	 */
	public static final String IP_ADDRESS = "tcp://77.122.9.2:1883";

}
