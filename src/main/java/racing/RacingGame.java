package racing;

import car.Car;

public class RacingGame {
	private final static int MIN_CONDITION_FOR_MOVING = 4;

	public static void play(Car car, int i) {
		if(i < MIN_CONDITION_FOR_MOVING){
			return;
		}
		car.go();
	}
}
