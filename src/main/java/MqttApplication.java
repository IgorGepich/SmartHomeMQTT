/**
 * @author Ihor Sutulov
 * @version 2.0 Gradle
 */

import sw.Lamp;
import sw.LampFlora;
import sw.LampPlus;
import ui.UpdateSensorsData;
import ui.MainFrame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MqttApplication  {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new MainFrame());

/**
* Lamp Switchers
*/
		executorService.execute(new Lamp());
		executorService.execute(new LampPlus());
		executorService.execute(new LampFlora());

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new UpdateSensorsData(), 5,30, TimeUnit.SECONDS);
	}
}
