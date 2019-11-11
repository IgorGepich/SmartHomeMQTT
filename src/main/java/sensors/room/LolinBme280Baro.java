package sensors.room;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class LolinBme280Baro implements MqttCallback, Runnable {

	/**
	 * @param baroMsg - barometer value
	 */
	private static String baroMsg;
	public void setBaroMsg(String baroMsg) {
		this.baroMsg = baroMsg;
	}
	public static String getBaroMsg() {
		return baroMsg;
	}

	public void run(){
		try {
			MqttClient bme280LolinBarometer = new MqttClient(UiConstants.IP_ADDRESS, "RoomBarometer");
			bme280LolinBarometer.connect();
			bme280LolinBarometer.setCallback(this);
			bme280LolinBarometer.subscribe(TopicConstants.LOLIN_BME_BAROMETER_TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void connectionLost(Throwable throwable) {
	}

	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) {
		setBaroMsg(mqttMessage.toString());
		System.out.println("Lolin baro: " + mqttMessage);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
	}
}
