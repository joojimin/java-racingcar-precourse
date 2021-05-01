package racing;

import car.Car;
import car.CarFactory;
import exception.RacingGameException;
import type.ExceptionMessage;
import util.CustomStringUtils;
import java.util.List;

public class RacingGameManager {

	private static final String REGEX = ",";
	private static final int MAX_SIZE_FOR_CAR_NAME = 5;

	private CarFactory carFactory;

	public RacingGameManager(){
		this.carFactory = new CarFactory();
	}

	public void createCarList(String inputData) {
		List<String> splitList = CustomStringUtils.split(inputData, REGEX);
		for(String value : splitList){
			carFactory.add(makeCar(value));
		}
	}

	private Car makeCar(String value){
		if(false == CustomStringUtils.isValidSize(value, MAX_SIZE_FOR_CAR_NAME)){
			throw new RacingGameException(ExceptionMessage.INVALID_SIZE_CAR_NAME);
		}
		return new Car(value);
	}
}
