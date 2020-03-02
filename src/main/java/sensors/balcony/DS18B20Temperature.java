package sensors.balcony;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class DS18B20Temperature implements MqttCallback, Runnable {

	private static String tempMsg;

	public static String getTempMsg() {
		return tempMsg;
	}

	private void setTempMsg(String tempMsg) {
		this.tempMsg = tempMsg;
	}

	@Override
	public void run() {
		try {
			MqttClient ds18b20Temperature = new MqttClient(UiConstants.IP_ADDRESS, "DS18B20");
			ds18b20Temperature.connect();
			ds18b20Temperature.setCallback(this);
			ds18b20Temperature.subscribe(TopicConstants.DS_TEMPERATURE_TOPIC);
			ds18b20Temperature.messageArrivedComplete(1, 0);

		} catch (MqttException e){

		}

	}

	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		setTempMsg(message.toString());
		System.out.println("DS temperature: " + message);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}
}
