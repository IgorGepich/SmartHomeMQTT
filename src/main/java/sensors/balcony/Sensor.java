package sensors.balcony;

import org.eclipse.paho.client.mqttv3.*;

public class Sensor implements MqttCallback, Runnable{

	private static String tempMsg;

	private String clientId;

	private String IpAddress;

	private String mqttTopic;

	private String sensorType;

	private String sensorLocation;

	public String getSensorLocation() {
		return sensorLocation;
	}

	public String getSensorType() {
		return sensorType;
	}

	public String getMqttTopic() {
		return mqttTopic;
	}

	public String getIpAddress() {
		return IpAddress;
	}

	public String getClientId() {
		return clientId;
	}

	public static String getTempMsg() {
		return tempMsg;
	}

	private void setTempMsg(String tempMsg) {
		this.tempMsg = tempMsg;
	}

	public Sensor(String sensorLocation, String clientId, String ipAddress, String mqttTopic, String sensorType) {
		this.sensorLocation = sensorLocation;
		this.clientId = clientId;
		IpAddress = ipAddress;
		this.mqttTopic = mqttTopic;
		this.sensorType = sensorType;
	}

	public void run() {
			try {
			MqttClient sensor = new MqttClient(getIpAddress(), getClientId());
			sensor.connect();
			sensor.setCallback(this);
			sensor.subscribe(getMqttTopic());
			sensor.messageArrivedComplete(1, 0);

			}
			catch (MqttException e){

			}
	}
	@Override
	public void messageArrived(String topic, MqttMessage message) {
		setTempMsg(message.toString());
		System.out.println("SENSOR LOCATION: " + getSensorLocation()
				+ " SENSOR NAME: " + getClientId()
				+ " VALUE: " + message
				+ getSensorType());
	}


	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}
}
