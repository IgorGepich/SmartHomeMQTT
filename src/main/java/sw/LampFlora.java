package sw;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LampFlora implements MqttCallback, Runnable{

	static MqttClient FloraLampClient;

	{
		try {
			FloraLampClient = new MqttClient(UiConstants.IP_ADDRESS, "FloraLamp");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			FloraLampClient.connect();
			FloraLampClient.setCallback(this);
			FloraLampClient.subscribe(TopicConstants.FLORA_LAMP_TOPIC);
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

	public static class FloraLampListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
			message.setPayload("toggle"
					.getBytes());
			try {
				FloraLampClient.publish(TopicConstants.FLORA_LAMP_TOPIC, message);
			} catch (MqttException ex) {
				ex.printStackTrace();
			}
		}
	}

}
