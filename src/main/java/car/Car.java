package car;

import exception.RacingGameException;
import util.MessageUtils;
import type.ExceptionMessage;
import util.CustomStringUtils;

public class Car implements Comparable<Car>{
	private final String name;
	private int position;

	public Car(final String name){
		this.name = name;
	}

	public int getPosition(){
		return this.position;
	}
	public String getName(){ return this.name; }

	public void go() {
		this.position += 1;
	}

	public String makeResult(){
		return MessageUtils.makePlayMessage(this.name, this.position);
	}

	public static Car getInstance(String value, int maxSizeForCarName){
		if(false == CustomStringUtils.isValidSize(value, maxSizeForCarName)){
			throw new RacingGameException(ExceptionMessage.INVALID_SIZE_CAR_NAME);
		}
		return new Car(value);
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
