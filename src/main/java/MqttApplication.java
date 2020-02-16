/**
 * @author Ihor Sutulov
 * @version 1.1 Gradle
 */

import sw.Switch;
import sensors.balcony.Bme280Baro;
import sensors.balcony.Bme280Humidity;
import sensors.balcony.Bme280Temperature;
import sensors.room.LolinBme280Baro;
import sensors.room.LolinBme280Humidity;
import sensors.room.LolinBme280Temperature;
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

		executorService.execute(new Switch());

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
