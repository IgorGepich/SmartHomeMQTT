package ui;

import constants.UiConstants;
import sensors.SensorCreater;

/**
 Class UpdateDataTimer update data on screen
 */

public class UpdateSensorsData extends SensorCreater implements Runnable {

	public void sensorConnector(){
		this.fillArray();
		for (sensors.Sensor sensor : this.sensorArrayList) {
			sensor.connectMqttServer();
		}
	}

	@Override
	public void run() {
		BalconyPanel.dsTemperatureLabel.setText(dsTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);

		BalconyPanel.temperatureLabel.setText(amicaTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		BalconyPanel.humidityLabel.setText(amicaHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		BalconyPanel.barometerLabel.setText(amicaBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);

		RoomPanel.roomTemperatureLabel.setText(lolinTemperatureSensor.getSensorDataValue() + UiConstants.DEGREE);
		RoomPanel.roomHumidityLabel.setText(lolinHumiditySensor.getSensorDataValue() + UiConstants.HUMIDITY);
		RoomPanel.roomBarometerLabel.setText(lolinBarometerSensor.getSensorDataValue() + UiConstants.BAROMETER);
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
