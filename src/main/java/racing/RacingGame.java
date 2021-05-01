package racing;

import car.Car;
import util.ConsoleUtils;

public class RacingGame {
	private final static int MIN_CONDITION_FOR_MOVING = 4;

	public static void play(Car car, int i) {
		if(i >= MIN_CONDITION_FOR_MOVING){
			car.go();
		}
		ConsoleUtils.print(car.makeResult());
	}
}
