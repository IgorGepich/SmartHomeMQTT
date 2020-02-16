package ui;

import constants.UiConstants;
import sensors.balcony.Bme280Baro;
import sensors.balcony.Bme280Humidity;
import sensors.balcony.Bme280TestSensor;
import sensors.room.LolinBme280Baro;
import sensors.room.LolinBme280Humidity;
import sensors.room.LolinBme280Temperature;

/**
 Class UpdateDataTimer realize updating data on screen
 */

public class UpdateDataTimer implements Runnable{
	Bme280TestSensor bme280TestSensor = new Bme280TestSensor();

	@Override
	public void run() {
	bme280TestSensor.run();
		Bme280BalconyPanel.temperatureLabel.setText(bme280TestSensor.getSensorMsg() + UiConstants.DEGREE);
//		Bme280BalconyPanel.temperatureLabel.setText(Bme280Temperature.getTempMsg() + UiConstants.DEGREE);
		Bme280BalconyPanel.humidityLabel.setText(Bme280Humidity.getHumMsg() + UiConstants.HUMIDITY);
		Bme280BalconyPanel.barometerLabel.setText(Bme280Baro.getBaroMsg() + UiConstants.BAROMETER);

		Bme280RoomPanel.roomTemperatureLabel.setText(LolinBme280Temperature.getTempMsg() + UiConstants.DEGREE);
		Bme280RoomPanel.roomHumidityLabel.setText(LolinBme280Humidity.getHumMsg() + UiConstants.HUMIDITY);
		Bme280RoomPanel.roomBarometerLabel.setText(LolinBme280Baro.getBaroMsg() + UiConstants.BAROMETER);

//		Bme280BalconyPanel.temperatureLabel.setText(Bme280TestSensor.getSensorMsg() + UiConstants.DEGREE);
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
