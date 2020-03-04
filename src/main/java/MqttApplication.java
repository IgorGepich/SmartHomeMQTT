/**
 * @author Ihor Sutulov
 * @version 1.1 Gradle
 */

import constants.TopicConstants;
import constants.UiConstants;
import sensors.balcony.*;
import sensors.room.LolinBme280Baro;
import sensors.room.LolinBme280Humidity;
import sensors.room.LolinBme280Temperature;
import sw.Lamp;
import sw.LampPlus;
import ui.MainFrame;
import ui.UpdateDataTimer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MqttApplication  {
	public static void main(String[] args){

		ExecutorService executorService = Executors.newFixedThreadPool(6);

		executorService.execute(new MainFrame());
		executorService.execute(new Bme280Temperature());
		executorService.execute(new Bme280Humidity());
		executorService.execute(new Bme280Baro());
		executorService.execute(new LolinBme280Temperature());
		executorService.execute(new LolinBme280Humidity());
		executorService.execute(new LolinBme280Baro());
//		executorService.execute(lolinBme280Humidity);
//		executorService.execute(lolinBme280Temperature);

		executorService.execute(new DS18B20Temperature());

		executorService.execute(new Sensor(UiConstants.LOCATION_OUTDOOR,
				"DS",
				UiConstants.IP_ADDRESS,
				TopicConstants.DS_TEMPERATURE_TOPIC,
				UiConstants.DEGREE));
		executorService.execute(new Sensor(UiConstants.LOCATION_ROOM,
				"Lolin",
				UiConstants.IP_ADDRESS,
				TopicConstants.LOLIN_BME_TEMPERATURE_TOPIC,
				UiConstants.DEGREE));


/**
* Lamp Switchers
*/
		executorService.execute(new Lamp());
		executorService.execute(new LampPlus());

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new UpdateDataTimer(), 5,15, TimeUnit.SECONDS);
/**
 * Scheduled connection to data base
 */
//		scheduledExecutorService.scheduleWithFixedDelay(new ConnectionDb(), 5, 15, TimeUnit.SECONDS);

//		ConnectionDb connectionDb = new ConnectionDb();
//		connectionDb.addSensorData();
//		connectionDb.deleteAllData();

	}
}
