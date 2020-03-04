package constants;

/**
 * Class contains constants for sensor topics received from the mosquitto server
 */

public class TopicConstants {

	// TODO: 3/3/20 Root topics

	public static final String AMICA_BME_HUMIDITY_TOPIC = "boardAmica/sensorBme280/humidity/percentRelative";
	public static final String AMICA_BME_TEMPERATURE_TOPIC = "boardAmica/sensorBme280/temperature/BmeIndoorCelsius";
	public static final String AMICA_BME_BAROMETER_TOPIC = "boardAmica/sensorBme280/barometer/hectoPascal";

	public static final String LOLIN_BME_HUMIDITY_TOPIC = "boardLolin/sensorBme280/humidity/percentRelative";
	public static final String LOLIN_BME_TEMPERATURE_TOPIC = "boardLolin/sensorBme280/temperature/BmeIndoorCelsius";
	public static final String LOLIN_BME_BAROMETER_TOPIC = "boardLolin/sensorBme280/barometer/hectoPascal";

	public static final String LAMP_TOPIC = "cmnd/sonoff_1.0/POWER";
	public static final String LAMP_PLUS_TOPIC = "cmnd/sonoff_1.1/POWER";
	public static final String FLORA_LAMP_TOPIC = "cmnd/sonoff_1.2/POWER";

	public static final String DS_TEMPERATURE_TOPIC = "boardAmica/sensorDS/temperature/DsOutdoorCelsius";

	enum lamp {
		LAMP_TOPIC,
		LAMP_PLUS_TOPIC,
		FLORA_LAMP_TOPIC
	}
}
