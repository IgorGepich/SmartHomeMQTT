package sensors.balcony;

/**
 * Bme280Baro implements reading barometer data from a sensor
 * @param baroMsg String value of data from the temperature sensor
 */

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class Bme280Baro implements MqttCallback, Runnable{

	private static String baroMsg;
	public static String getBaroMsg() {
		return baroMsg;
	}
	private void setBaroMsg(String baroMsg) {
		this.baroMsg = baroMsg;
	}

	@Override
	public void run() {
		try {
			MqttClient bme280Barometer = new MqttClient(UiConstants.IP_ADDRESS, "BalconyIndoorBarometer");
			bme280Barometer.connect();
			bme280Barometer.setCallback(this);
			bme280Barometer.subscribe(TopicConstants.AMICA_BME_BAROMETER_TOPIC);
			bme280Barometer.messageArrivedComplete(1,0);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deprecated version 1.0
	 */
//	public void readBarometer(){
//		try {
//			bme280Barometer = new MqttClient(UiConstants.IP_ADDRESS, "BalconyIndoorBarometer");
//			bme280Barometer.connect();
//			bme280Barometer.setCallback(this);
//			bme280Barometer.subscribe(TopicConstants.AMICA_BME_BAROMETER_TOPIC);
//			bme280Barometer.messageArrivedComplete(1,0);
//		} catch (MqttException e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public void connectionLost(Throwable throwable) {
	}

	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		setBaroMsg(mqttMessage.toString());
		System.out.println("Amica baro: " + mqttMessage);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
	}
}
