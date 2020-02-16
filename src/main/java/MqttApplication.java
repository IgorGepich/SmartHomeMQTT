/**
 * @author Ihor Sutulov
 * @version 1.1 Gradle
 */

import sensors.balcony.Bme280Baro;
import sensors.balcony.Bme280Humidity;
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
//		UpdateDataTimer update = new UpdateDataTimer();
//		update.run();

		//Observer
//		PrinterToCli printerToCli = new PrinterToCli();
//
//		LolinBme280Humidity lolinBme280Humidity = new LolinBme280Humidity();
//		lolinBme280Humidity.addObserver(printerToCli);
//
//		LolinBme280Temperature lolinBme280Temperature = new LolinBme280Temperature();
//		lolinBme280Temperature.addObserver(printerToCli);
	//END Observer
		ExecutorService executorService = Executors.newFixedThreadPool(6);

//		executorService.execute(new Bme280TestSensor(Bme280TestSensor.getSensorMsg()));

		executorService.execute(new MainFrame());
//		executorService.execute(new Bme280Temperature());
		executorService.execute(new Bme280Humidity());
		executorService.execute(new Bme280Baro());
		executorService.execute(new LolinBme280Temperature());
		executorService.execute(new LolinBme280Humidity());
		executorService.execute(new LolinBme280Baro());
//		executorService.execute(lolinBme280Humidity);
//		executorService.execute(lolinBme280Temperature);

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
