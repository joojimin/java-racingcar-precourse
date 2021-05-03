package car;

import exception.RacingGameException;
import util.ConsoleUtils;
import util.MessageUtils;
import type.ExceptionMessage;
import util.CustomStringUtils;

public class Car implements Comparable<Car>{
	private static final int MAX_SIZE_FOR_CAR_NAME = 5;
	private final static int MIN_CONDITION_FOR_MOVING = 4;

	private final String name;
	private int position;

	public Car(final String name){
		this.name = name;
	}

	public int getPosition(){
		return this.position;
	}
	public String getName(){ return this.name; }

	public String makeResult(){
		return MessageUtils.makePlayMessage(this.name, this.position);
	}

	public void play(int i) {
		if(i >= MIN_CONDITION_FOR_MOVING){
			go();
		}
		ConsoleUtils.printLine(makeResult());
	}

	void go() {
		this.position += 1;
	}


	public static Car getInstance(String name){
		if(false == CustomStringUtils.isValidSize(name, MAX_SIZE_FOR_CAR_NAME)){
			throw new RacingGameException(ExceptionMessage.INVALID_SIZE_CAR_NAME);
		}
		return new Car(name);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Car car  = (Car)obj;
		return this.name.equals(car.getName());
	}

	@Override
	public int compareTo(Car o) {
		return Integer.compare(this.position, o.getPosition());
	}
}
