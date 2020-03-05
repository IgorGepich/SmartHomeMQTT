package ui;

import constants.TopicConstants;
import constants.UiConstants;
import sensors.Sensor;

/**
 Class UpdateDataTimer realize creating Sensors and updating data on screen
 */

public class UpdateDataTimer implements Runnable{

		Sensor DsSensor = new Sensor("Outdoor",
				"DS",
				UiConstants.IP_ADDRESS,
				TopicConstants.DS_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

		Sensor LolinTemperatureSensor = new Sensor("Room",
				"BmeRoomTemp",
				UiConstants.IP_ADDRESS,
				TopicConstants.LOLIN_BME_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

		Sensor LolinHumiditySensor = new Sensor("Room",
				"BmeRoomHum",
				UiConstants.IP_ADDRESS,
				TopicConstants.LOLIN_BME_HUMIDITY_TOPIC,
				UiConstants.HUMIDITY);

		Sensor LolinBarometerSensor = new Sensor("Room",
				"BmeRoomBaro",
				UiConstants.IP_ADDRESS,
				TopicConstants.LOLIN_BME_BAROMETER_TOPIC,
				UiConstants.BAROMETER);

		Sensor AmicaTemperatureSensor = new Sensor("Balcony",
				"BmeBalconyTemp",
				UiConstants.IP_ADDRESS,
				TopicConstants.AMICA_BME_TEMPERATURE_TOPIC,
				UiConstants.DEGREE);

	Sensor AmicaHumiditySensor = new Sensor("Balcony",
			"BmeBalconyHumidity",
			UiConstants.IP_ADDRESS,
			TopicConstants.AMICA_BME_HUMIDITY_TOPIC,
			UiConstants.HUMIDITY);

	Sensor AmicaBarometerSensor = new Sensor("Balcony",
			"BmeBalconyBarometer",
			UiConstants.IP_ADDRESS,
			TopicConstants.AMICA_BME_BAROMETER_TOPIC,
			UiConstants.BAROMETER);


	// TODO: 3/5/20 Add List or Map to collect sensors
	public void sensorConnector(){
		DsSensor.connectMqttServer();
		LolinTemperatureSensor.connectMqttServer();
		LolinHumiditySensor.connectMqttServer();
		LolinBarometerSensor.connectMqttServer();
		AmicaTemperatureSensor.connectMqttServer();
		AmicaHumiditySensor.connectMqttServer();
		AmicaBarometerSensor.connectMqttServer();
	}
	@Override
	public void run() {
		sensorConnector();
		BalconyPanel.dsTemperatureLabel.setText(DsSensor.getSensorDataValue() + UiConstants.DEGREE);

		BalconyPanel.temperatureLabel.setText(AmicaTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		BalconyPanel.humidityLabel.setText(AmicaHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		BalconyPanel.barometerLabel.setText(AmicaBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);

		RoomPanel.roomTemperatureLabel.setText(LolinTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		RoomPanel.roomHumidityLabel.setText(LolinHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		RoomPanel.roomBarometerLabel.setText(LolinBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);

		//		System.out.println(DsSensor.getSensorDataValue() + UiConstants.DEGREE);
	}


/**
 * Update UI data.
 * Full working code. Deprecated from v1.0
 */
//	void updateTimer(){
//		Timer update = new Timer();
//		update.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				Bme280BalconyPanel.temperatureLabel.setText(Bme280Temperature.getTempMsg() + UiConstants.DEGREE);
//				Bme280BalconyPanel.humidityLabel.setText(Bme280Humidity.getHumMsg() + UiConstants.HUMIDITY);
//				Bme280BalconyPanel.barometerLabel.setText(Bme280Baro.getBaroMsg() + UiConstants.BAROMETER);
//
//				Bme280RoomPanel.roomTemperatureLabel.setText(LolinBme280Temperature.getTempMsg() + UiConstants.DEGREE);
//				Bme280RoomPanel.roomHumidityLabel.setText(LolinBme280Humidity.getTempMsg() + UiConstants.HUMIDITY);
//				Bme280RoomPanel.roomBarometerLabel.setText(LolinBme280Baro.getBaroMsg() + UiConstants.BAROMETER);
//			}
//		}, 10000, 4000);
//	}
}
