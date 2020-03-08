package ui;

import constants.UiConstants;
import sensors.SensorCreater;

/**
 Class UpdateDataTimer update data on screen
 */

public class UpdateSensorsData implements Runnable {

	SensorCreater sensorCreater = new SensorCreater();

	// TODO: 3/5/20 Add List or Map to collect sensors
	public void sensorConnector(){
		sensorCreater.dsTemperatureSensor.connectMqttServer();
		sensorCreater.lolinTemperatureSensor.connectMqttServer();
		sensorCreater.lolinHumiditySensor.connectMqttServer();
		sensorCreater.lolinBarometerSensor.connectMqttServer();
		sensorCreater.amicaTemperatureSensor.connectMqttServer();
		sensorCreater.amicaHumiditySensor.connectMqttServer();
		sensorCreater.amicaBarometerSensor.connectMqttServer();
	}

	@Override
	public void run() {
		sensorConnector();
		BalconyPanel.dsTemperatureLabel.setText(sensorCreater.dsTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);

		BalconyPanel.temperatureLabel.setText(sensorCreater.amicaTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		BalconyPanel.humidityLabel.setText(sensorCreater.amicaHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		BalconyPanel.barometerLabel.setText(sensorCreater.amicaBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);

		RoomPanel.roomTemperatureLabel.setText(sensorCreater.lolinTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		RoomPanel.roomHumidityLabel.setText(sensorCreater.lolinHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		RoomPanel.roomBarometerLabel.setText(sensorCreater.lolinBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);
	}


/**
 * Update UI data. Realisation with TIMER
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
