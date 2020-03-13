package ui;

import constants.UiConstant;
import sensors.SensorCreater;

import java.util.HashMap;
import java.util.Map;

/**
 Class UpdateDataTimer update data on screen
 */

public class UpdateSensorsData extends SensorCreater implements Runnable {

	public void sensorConnector(){
		this.fillArray();
		for (sensors.Sensor sensor : this.sensorCollection) {
			sensor.connectMqttServer();
		}
	}

	public Map<String, String> map = new HashMap<>();
		public Map addValue(){
			map.put(dsTemperatureSensor.getSensorId(), dsTemperatureSensor.getSensorDataValue());
			map.put(amicaTemperatureSensor.getSensorId(), amicaTemperatureSensor.getSensorDataValue());
			map.put(amicaHumiditySensor.getSensorId(), amicaHumiditySensor.getSensorDataValue());
			map.put(amicaBarometerSensor.getSensorId(), amicaBarometerSensor.getSensorDataValue());
			map.put(lolinTemperatureSensor.getSensorId(), lolinTemperatureSensor.getSensorDataValue());
			map.put(lolinHumiditySensor.getSensorId(), lolinHumiditySensor.getSensorDataValue());
			map.put(lolinBarometerSensor.getSensorId(), lolinBarometerSensor.getSensorDataValue());

			return map;
		}

	public void find(){
			for(Map.Entry<String, String> entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
	}

	@Override
	public void run() {
		//unchecked
		addValue();
		find();
		BalconyPanel.dsTemperatureLabel.setText(map.get(dsTemperatureSensor.getSensorId()) +
				UiConstant.DEGREE.getUiConstant());

		BalconyPanel.temperatureLabel.setText(map.get(amicaTemperatureSensor.getSensorId()) +
				UiConstant.DEGREE.getUiConstant());
		BalconyPanel.humidityLabel.setText(map.get(amicaHumiditySensor.getSensorId()) +
				UiConstant.HUMIDITY.getUiConstant());
		BalconyPanel.barometerLabel.setText(map.get(amicaBarometerSensor.getSensorId()) +
				UiConstant.BAROMETER.getUiConstant());

		RoomPanel.roomTemperatureLabel.setText(map.get(lolinTemperatureSensor.getSensorId()) +
				UiConstant.DEGREE.getUiConstant());
		RoomPanel.roomHumidityLabel.setText(map.get(lolinHumiditySensor.getSensorId()) +
				UiConstant.HUMIDITY.getUiConstant());
		RoomPanel.roomBarometerLabel.setText(map.get(lolinBarometerSensor.getSensorId()) +
				UiConstant.BAROMETER.getUiConstant());
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
