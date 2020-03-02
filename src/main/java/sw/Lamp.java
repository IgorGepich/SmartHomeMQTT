package sw;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lamp implements MqttCallback, Runnable {

	static MqttClient LampClient;

	{
		try {
			LampClient = new MqttClient(UiConstants.IP_ADDRESS, "Lamp");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			LampClient.connect();
			LampClient.setCallback(this);
			LampClient.subscribe(TopicConstants.LAMP_TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	public static class LampListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
			message.setPayload("toggle"
					.getBytes());
			try {
				LampClient.publish(TopicConstants.LAMP_TOPIC, message);
			} catch (MqttException ex) {
				ex.printStackTrace();
			}
		}
	}
}
