package sensors.room;

/**
 * LolinBme280Humidity implements reading humidity data from a sensor
 */

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class LolinBme280Humidity implements MqttCallback, Runnable {

	private static String tempMsg;

	public void setTempMsg(String tempMsg) {
		this.tempMsg = tempMsg;
	}
	public static String getTempMsg() {
		return tempMsg;
	}


	public void run() {
		try {
			MqttClient bme280LolinHumidity = new MqttClient(UiConstants.IP_ADDRESS, "RoomIndoorHumidity");
			bme280LolinHumidity.connect();
			bme280LolinHumidity.setCallback(this);
			bme280LolinHumidity.subscribe(TopicConstants.LOLIN_BME_HUMIDITY_TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable throwable) {

	}

	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) {
		setTempMsg(mqttMessage.toString());
		System.out.println("Lolin hum: " + mqttMessage);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

	}
}
