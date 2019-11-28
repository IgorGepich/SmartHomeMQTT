package sensors.room;

import constants.TopicConstants;
import constants.UiConstants;
import observer.IObserved;
import observer.IObserver;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;
import java.util.List;

public class LolinBme280Baro implements MqttCallback, Runnable, IObserved {

	/**
	 * @param baroMsg - barometer value
	 */

	private List<IObserver> baroObserver = new ArrayList<>();
	private static String baroMsg;
	private void setBaroMsg(String baroMsg) {
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
		notifyObservers();
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
	}

	@Override
	public void addObserver(IObserver o) {
		baroObserver.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {

	}

	@Override
	public void notifyObservers() {
		for(IObserver o : baroObserver){
			o.onHandleEvent(getBaroMsg());
		}
	}
}
