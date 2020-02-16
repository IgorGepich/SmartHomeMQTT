package observer;

import sensors.room.LolinBme280Baro;
import sensors.room.LolinBme280Temperature;

public class PrinterToCli implements IObserver {

	@Override
	public void onHandleEvent(String message) {
		System.out.println("Lolin data: ");
		System.out.println("Observer temperature data: " + LolinBme280Temperature.getTempMsg());
		System.out.println("Observer hum data: " + message);
		System.out.println("Observer barometer data: " + LolinBme280Baro.getBaroMsg());
		System.out.println("Amica data");
	}
}
