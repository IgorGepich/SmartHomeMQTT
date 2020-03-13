package sw;

import constants.MqttTopic;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LampPlus implements MqttCallback, Runnable {

	static MqttClient LampPlusClient;

	{
		try {
			LampPlusClient = new MqttClient(UiConstants.IP_ADDRESS, "Lamp+");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			LampPlusClient.connect();
			LampPlusClient.setCallback(this);
			LampPlusClient.subscribe(MqttTopic.LAMP_PLUS.getTopicPath());
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

	public static class LampPlusListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
				message.setPayload("toggle"
					.getBytes());
			try {
				LampPlusClient.publish(MqttTopic.LAMP_PLUS.getTopicPath(), message);
			} catch (MqttException ex) {
				ex.printStackTrace();
			}
		}
	}
}
