package sensors;

import constants.TopicConstants;
import constants.UiConstants;

public class SensorCreater {

		public Sensor dsTemperatureSensor = new Sensor("Outdoor",
				"DS",
				TopicConstants.DS_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

		public Sensor lolinTemperatureSensor = new Sensor("Room",
				"BmeRoomTemp",
				TopicConstants.LOLIN_BME_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

		public Sensor lolinHumiditySensor = new Sensor("Room",
				"BmeRoomHum",
				TopicConstants.LOLIN_BME_HUMIDITY_TOPIC,
				UiConstants.HUMIDITY);

		public Sensor lolinBarometerSensor = new Sensor("Room",
				"BmeRoomBaro",
				TopicConstants.LOLIN_BME_BAROMETER_TOPIC,
				UiConstants.BAROMETER);

		public Sensor amicaTemperatureSensor = new Sensor("Balcony",
				"BmeBalconyTemp",
				TopicConstants.AMICA_BME_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

		public Sensor amicaHumiditySensor = new Sensor("Balcony",
				"BmeBalconyHumidity",
				TopicConstants.AMICA_BME_HUMIDITY_TOPIC,
				UiConstants.HUMIDITY);

		public Sensor amicaBarometerSensor = new Sensor("Balcony",
				"BmeBalconyBarometer",
				TopicConstants.AMICA_BME_BAROMETER_TOPIC,
				UiConstants.BAROMETER);
}
