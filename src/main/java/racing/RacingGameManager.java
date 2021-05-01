package racing;

import car.Car;
import car.CarFactory;
import util.ConsoleUtils;
import util.CustomStringUtils;
import util.MessageUtils;
import util.RandonNumberUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGameManager {

	private static final String REGEX = ",";
	private static final int MAX_SIZE_FOR_CAR_NAME = 5;
	private static final int STANDARD_RANGE_NUMBER = 10;
	private final static int MIN_CONDITION_FOR_MOVING = 4;

	private CarFactory carFactory;

	public RacingGameManager(CarFactory carFactory){
		this.carFactory = carFactory;
	}

	void createCarList(String inputData) {
		List<String> splitList = CustomStringUtils.split(inputData, REGEX);
		for(String value : splitList){
			carFactory.add(Car.getInstance(value, MAX_SIZE_FOR_CAR_NAME));
		}
	}

	void playGames(final GameCommand gameCommand){
		while(gameCommand.isPlaying()){
			movingCars();
			ConsoleUtils.printLine();
		}
		ConsoleUtils.print(MessageUtils.makeWinnerMessage(getWinnerList()));
	}

	private void movingCars(){
		carFactory.processAboutCarList(car-> play(car, RandonNumberUtils.generate(STANDARD_RANGE_NUMBER)));
	}

	void play(Car car, int i) {
		if(i >= MIN_CONDITION_FOR_MOVING){
			car.go();
		}
		ConsoleUtils.print(car.makeResult());
	}

	List<String> getWinnerList(){
		Car winnerCar = carFactory.getMaxPositionCar();
		List<String> winnerCarNameList = new ArrayList<>();
		carFactory.processAboutCarList(car -> assembleWinnerCar(car, winnerCar, winnerCarNameList));
		return winnerCarNameList;
	}

	private void assembleWinnerCar(Car car, Car winnerCar, List<String> winnerCarNameList){
		if(car.getPosition() != winnerCar.getPosition()){
			return;
		}
		winnerCarNameList.add(car.getName());
	}
}
