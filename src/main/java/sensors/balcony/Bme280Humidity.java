package sensors.balcony;

/**
 * Bme280Humidity implements reading humidity data from a sensor
 * @param humMsg String value of data from the humidity sensor
 */

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class Bme280Humidity implements MqttCallback, Runnable {

	private static String humMsg;

	public static String getHumMsg() {
		return humMsg;
	}

	private void setHumMsg(String humMsg) {
		this.humMsg = humMsg;
	}

	@Override
	public void run() {
		try {
			MqttClient bme280Humidity = new MqttClient(UiConstants.IP_ADDRESS, "BalconyIndoorHumidity");
			bme280Humidity.connect();
			bme280Humidity.setCallback(this);
			bme280Humidity.subscribe(TopicConstants.AMICA_BME_HUMIDITY_TOPIC);
			bme280Humidity.messageArrivedComplete(1,0);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deprecated version 1.0
	 */
//	public void readHumidity() {
//		try {
//			bme280Humidity.connect();
//			bme280Humidity.setCallback(this);
//			bme280Humidity.subscribe(TopicConstants.AMICA_BME_HUMIDITY_TOPIC);
//			bme280Humidity.messageArrivedComplete(1,0);
//		} catch (MqttException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void connectionLost(Throwable cause) {
		try{
			System.out.println("Connection lost. Trying to reconnect...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		setHumMsg(message.toString());
		System.out.println("Amica hum: " + message);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("Complete");
	}
}
