package constants;

/**
 * Class contains constants for sensor topics received from the mosquitto server
 */

public class TopicConstants {

	public static final String AMICA_BME_HUMIDITY_TOPIC = "boardAmica/sensorBme280/humidity/percentRelative";
	public static final String AMICA_BME_TEMPERATURE_TOPIC = "boardAmica/sensorBme280/temperature/BmeIndoorCelsius";
	public static final String AMICA_BME_BAROMETER_TOPIC = "boardAmica/sensorBme280/barometer/hectoPascal";

	public static final String LOLIN_BME_HUMIDITY_TOPIC = "boardLolin/sensorBme280/humidity/percentRelative";
	public static final String LOLIN_BME_TEMPERATURE_TOPIC = "boardLolin/sensorBme280/temperature/BmeIndoorCelsius";
	public static final String LOLIN_BME_BAROMETER_TOPIC = "boardLolin/sensorBme280/barometer/hectoPascal";

	public static final String LAMP_TOPIC = "cmnd/sonoff_1.0/POWER";
	public static final String LAMP_PLUS_TOPIC = "cmnd/sonoff_1.1/POWER";
	public static final String LAMP_FLORA_TOPIC = "cmnd/sonoff_1.2/POWER";
}
