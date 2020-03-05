package sensors;

import org.eclipse.paho.client.mqttv3.*;

public class Sensor implements MqttCallback{

	private String sensorDataValue;

	private String sensorId;

	private String ipAddress;

	private String mqttTopic;

	private String sensorType;

	private String sensorLocation;

	public void setSensorLocation(String sensorLocation) {
		this.sensorLocation = sensorLocation;
	}

	public String getSensorLocation() {
		return sensorLocation;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setMqttTopic(String mqttTopic) {
		this.mqttTopic = mqttTopic;
	}

	public String getMqttTopic() {
		return mqttTopic;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorId() {
		return sensorId;
	}

	public String getSensorDataValue() {
		return sensorDataValue;
	}

	private void setSensorDataValue(String sensorDataValue) {
		this.sensorDataValue = sensorDataValue;
	}

//	public Sensor() {
//	}

	public Sensor(String sensorLocation, String sensorId, String ipAddress, String mqttTopic, String sensorType) {
		this.sensorLocation = sensorLocation;
		this.sensorId = sensorId;
		this.ipAddress = ipAddress;
		this.mqttTopic = mqttTopic;
		this.sensorType = sensorType;
	}

	public void connectMqttServer() {
			try {
			MqttClient sensor = new MqttClient(getIpAddress(), getSensorId());
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
		setSensorDataValue(message.toString());
		System.out.println("SENSOR LOCATION: " + getSensorLocation()
				+ " SENSOR NAME: " + getSensorId()
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
