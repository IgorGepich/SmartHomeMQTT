package sensors.room;

/**
 * LolinBme280Temperature implements reading temperature data from a sensor
 * @param tempMsg String value of data from the temperature sensor
 */

import constants.TopicConstants;
import constants.UiConstants;
import observer.IObserved;
import observer.IObserver;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;
import java.util.List;

public class LolinBme280Temperature implements MqttCallback, Runnable, IObserved {

	private static String tempMsg;

	private List<IObserver> tempObserver = new ArrayList<>();

	private void setTempMsg(String tempMsg) {
		this.tempMsg = tempMsg;
	}
	public static String getTempMsg() {
		return tempMsg;
	}


	public void run() {
		try {
			MqttClient bme280LolinTemperature = new MqttClient(UiConstants.IP_ADDRESS, "RoomIndoorTemperature");
			bme280LolinTemperature.connect();
			bme280LolinTemperature.setCallback(this);
			bme280LolinTemperature.subscribe(TopicConstants.LOLIN_BME_TEMPERATURE_TOPIC);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void connectionLost(Throwable throwable) {
		try{
			System.out.println("Connection lost. Trying to reconnect...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void messageArrived(String s, MqttMessage mqttMessage) {
		setTempMsg(mqttMessage.toString());
		notifyObservers();
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

	}

	@Override
	public void addObserver(IObserver o) {
		tempObserver.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {

	}

	@Override
	public void notifyObservers() {
		for(IObserver o : tempObserver){
			o.onHandleEvent(getTempMsg());
		}
	}
}
