package sensors;

import constants.MqttTopic;
import constants.UiConstant;

import java.util.ArrayList;
import java.util.List;

public class SensorCreater {

	public List<Sensor> sensorCollection = new ArrayList<>();

	public void fillArray(){
		sensorCollection.add(dsTemperatureSensor);
		sensorCollection.add(lolinTemperatureSensor);
		sensorCollection.add(lolinHumiditySensor);
		sensorCollection.add(lolinBarometerSensor);
		sensorCollection.add(amicaTemperatureSensor);
		sensorCollection.add(amicaHumiditySensor);
		sensorCollection.add(amicaBarometerSensor);
	}

	public Sensor dsTemperatureSensor = new Sensor("Outdoor",
			"DS",
			MqttTopic.DS_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public Sensor lolinTemperatureSensor = new Sensor("Room",
			"BmeRoomTemp",
			MqttTopic.LOLIN_BME_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public Sensor lolinHumiditySensor = new Sensor("Room",
			"BmeRoomHum",
			MqttTopic.LOLIN_BME_HUMIDITY.getTopicPath(),
			UiConstant.HUMIDITY.getUiConstant());

	public Sensor lolinBarometerSensor = new Sensor("Room",
			"BmeRoomBaro",
			MqttTopic.LOLIN_BME_BAROMETER.getTopicPath(),
			UiConstant.BAROMETER.getUiConstant());

	public Sensor amicaTemperatureSensor = new Sensor("Balcony",
			"BmeBalconyTemp",
			MqttTopic.AMICA_BME_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public Sensor amicaHumiditySensor = new Sensor("Balcony",
			"BmeBalconyHumidity",
			MqttTopic.AMICA_BME_HUMIDITY.getTopicPath(),
			UiConstant.HUMIDITY.getUiConstant());

	public Sensor amicaBarometerSensor = new Sensor("Balcony",
			"BmeBalconyBarometer",
			MqttTopic.AMICA_BME_BAROMETER.getTopicPath(),
			UiConstant.BAROMETER.getUiConstant());
}
