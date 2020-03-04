package sensors.balcony;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class Bme280Temperature implements MqttCallback, Runnable {

	private static String tempMsg;

	private void setTempMsg(String tempMsg) {
		this.tempMsg = tempMsg;
	}
	public static String getTempMsg() {
		return tempMsg;
	}

	/** @link <a href = "https://www.eclipse.org/paho/clients/java/">Eclipse Paho. Using the Paho Java Client</a> */

	@Override
	public void run() {
		try {
			MqttClient bme280Temperature = new MqttClient(UiConstants.IP_ADDRESS, "BalconyIndoorTemperature");
			bme280Temperature.connect();
			bme280Temperature.setCallback(this);
			bme280Temperature.subscribe(TopicConstants.AMICA_BME_TEMPERATURE_TOPIC);
			bme280Temperature.messageArrivedComplete(1,0);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deprecated version 1.0
	 */
//	public void readTemperature() {
//		try {
//			MqttClient bme280Temperature = new MqttClient(UiConstants.IP_ADDRESS, "BalconyIndoorTemperature");
//			bme280Temperature.connect();
//			bme280Temperature.setCallback(this);
//			bme280Temperature.subscribe(TopicConstants.AMICA_BME_TEMPERATURE_TOPIC);
//			bme280Temperature.messageArrivedComplete(1,0);
//			//		PUBLISH
//			//		MqttMessage message = new MqttMessage();
//			//			message.setPayload("Test message to broker"
//			//					.getBytes());
//			//			client.publish("OK", message);
//		} catch (MqttException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void connectionLost(Throwable cause) {
	}
	@Override
	public void messageArrived(String topic, MqttMessage message)
		//TODO decide with exception
			throws Exception {
		setTempMsg(message.toString());
//		System.out.println("Amica temp: " + message);
	}
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}
}

