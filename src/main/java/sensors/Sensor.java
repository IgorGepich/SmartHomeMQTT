package sensors;

import constants.UiConstant;
import org.eclipse.paho.client.mqttv3.*;

public class Sensor implements MqttCallback{

	private String sensorDataValue;

	private String sensorId;

	private String mqttTopic;

	private String sensorType;

	private String sensorLocation;

	public String getSensorDataValue() {
		return sensorDataValue;
	}

	public String getSensorId() {
		return sensorId;
	}

	public String getSensorType() {
		return sensorType;
	}

	public String getMqttTopic() {
		return mqttTopic;
	}

	public String getSensorLocation() {
		return sensorLocation;
	}

	private void setSensorDataValue(String sensorDataValue) {
		this.sensorDataValue = sensorDataValue;
	}

	public Sensor() {
	}

	public Sensor(String sensorLocation, String sensorId, String mqttTopic, String sensorType) {
		this.sensorLocation = sensorLocation;
		this.sensorId = sensorId;
		this.mqttTopic = mqttTopic;
		this.sensorType = sensorType;
	}

	public void connectMqttServer() {
			try {
			MqttClient sensor = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), getSensorId());
			sensor.connect();
			sensor.setCallback(this);
			sensor.subscribe(getMqttTopic());
			sensor.messageArrivedComplete(1, 0);
			}
			catch (MqttException e){
				System.out.println("Can't connect to the server.");
			}
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		setSensorDataValue(message.toString());
	}

	@Override
	public void connectionLost(Throwable cause) {
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	@Override
	public String toString() {
		return "Sensor{" +
				"sensorDataValue='" + sensorDataValue + '\'' +
				", sensorId='" + sensorId + '\'' +
				", mqttTopic='" + mqttTopic + '\'' +
				", sensorType='" + sensorType + '\'' +
				", sensorLocation='" + sensorLocation + '\'' +
				'}';
	}
}
