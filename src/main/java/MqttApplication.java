/**
 * @author Ihor Sutulov
 * @version 1.1 Gradle
 */

import sensors.balcony.Bme280Baro;
import sensors.balcony.Bme280Humidity;
import sensors.balcony.Bme280Temperature;
import sensors.room.LolinBme280Baro;
import sensors.room.LolinBme280Humidity;
import sensors.room.LolinBme280Temperature;
import ui.MainFrame;
import ui.UpdateDataTimer;

import java.util.concurrent.*;

public class MqttApplication  {
	public static void main(String[] args){

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new MainFrame());
		executorService.execute(new Bme280Temperature());
		executorService.execute(new Bme280Humidity());
		executorService.execute(new Bme280Baro());
		executorService.execute(new LolinBme280Temperature());
		executorService.execute(new LolinBme280Humidity());
		executorService.execute(new LolinBme280Baro());

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new UpdateDataTimer(), 5,15, TimeUnit.SECONDS);
	}
}
