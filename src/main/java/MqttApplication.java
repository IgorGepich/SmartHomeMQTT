/**
 * @author Ihor Sutulov
 * @version 2.0 Gradle
 */

import sw.Lamp;
import sw.LampPlus;
import ui.MainFrame;
import ui.UpdateDataTimer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MqttApplication  {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(6);

		executorService.execute(new MainFrame());

/**
* Lamp Switchers
*/
		executorService.execute(new Lamp());
		executorService.execute(new LampPlus());

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new UpdateDataTimer(), 5,15, TimeUnit.SECONDS);
	}
}
