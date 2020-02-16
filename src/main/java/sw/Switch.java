package sw;

import constants.TopicConstants;
import constants.UiConstants;
import org.eclipse.paho.client.mqttv3.*;

public class Switch implements MqttCallback, Runnable {


			MqttClient testSwitchLamp;

	{
		try {
			testSwitchLamp = new MqttClient(UiConstants.IP_ADDRESS, "TestLamp");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
				try {
			testSwitchLamp.connect();
			testSwitchLamp.setCallback(this);
			testSwitchLamp.subscribe(TopicConstants.LAMP_TOPIC);
			//		PUBLISH
					MqttMessage message = new MqttMessage();
						message.setPayload("on"
								.getBytes());
						testSwitchLamp.publish(TopicConstants.LAMP_TOPIC, message);
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
}
