package sw;

import constants.MqttTopic;
import constants.UiConstant;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lamp implements MqttCallback, Runnable {

	public String relayStatus;

	public String getRelayStatus() {
		return relayStatus;
	}

	public void setRelayStatus(String relayStatus) {
		this.relayStatus = relayStatus;
	}

	static MqttClient LampClient;

	{
		try {
			LampClient = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), "Lamp");
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
//			LampClient.subscribe(TopicConstants.LAMP_TOPIC);
			LampClient.subscribe(MqttTopic.LAMP.getTopicPath());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
			setRelayStatus(message.toString());
			System.out.println("Relay status: " + message);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	public static class LampListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
			MqttMessage statusMessage = new MqttMessage();
			message.setPayload("toggle"
					.getBytes());
			try {
				LampClient.publish(MqttTopic.LAMP.getTopicPath(), message);
//				LampClient.subscribe(TopicConstants.LAMP_STATUS);
//				System.out.println(statusMessage);
			} catch (MqttException ex) {
				ex.printStackTrace();
			}
		}
	}
}
