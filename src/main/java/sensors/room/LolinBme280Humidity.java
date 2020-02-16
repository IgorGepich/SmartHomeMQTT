package sensors.room;

/**
 * LolinBme280Humidity implements reading humidity data from a sensor
 */

import constants.TopicConstants;
import constants.UiConstants;
import observer.IObserved;
import observer.IObserver;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;
import java.util.List;

public class LolinBme280Humidity implements MqttCallback, Runnable, IObserved {

	private static String humMsg;

	private List<IObserver> humObserver = new ArrayList<>();

	public void setHumMsg(String humMsg) {
		this.humMsg = humMsg;
	}
	public static String getHumMsg() {
		return humMsg;
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
		setHumMsg(mqttMessage.toString());
		notifyObservers();
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

	}

	@Override
	public void addObserver(IObserver o) {
		humObserver.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
	}

	@Override
	public void notifyObservers() {
		for(IObserver o : humObserver){
			o.onHandleEvent(getHumMsg());
		}
	}
}
