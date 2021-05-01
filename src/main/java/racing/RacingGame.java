package racing;

import car.Car;
import car.CarFactory;
import util.ConsoleUtils;
import util.CustomStringUtils;
import util.MessageUtils;
import util.RandonNumberUtils;

import java.util.ArrayList;
import java.util.List;

import static type.GameMessage.GAME_RESULT;

public class RacingGame {

	private static final String REGEX = ",";
	private static final int MAX_SIZE_FOR_CAR_NAME = 5;
	private static final int STANDARD_RANGE_NUMBER = 10;
	private final static int MIN_CONDITION_FOR_MOVING = 4;

	private CarFactory carFactory;

	public RacingGame(CarFactory carFactory){
		this.carFactory = carFactory;
	}

	public void createCarList(String inputData) {
		List<String> splitList = CustomStringUtils.split(inputData, REGEX);
		for(String value : splitList){
			carFactory.add(Car.getInstance(value, MAX_SIZE_FOR_CAR_NAME));
		}
	}

	public void playGames(final GameCommand gameCommand){
		ConsoleUtils.printLine();
		ConsoleUtils.printLine(GAME_RESULT.getMessage());
		while(gameCommand.isPlaying()){
			movingCars();
			ConsoleUtils.printLine();
		}
		ConsoleUtils.printLine(MessageUtils.makeWinnerMessage(getWinnerList()));
	}

	private void movingCars(){
		carFactory.processAboutCarList(car-> play(car, RandonNumberUtils.generate(STANDARD_RANGE_NUMBER)));
	}

	void play(Car car, int i) {
		if(i >= MIN_CONDITION_FOR_MOVING){
			car.go();
		}
		ConsoleUtils.printLine(car.makeResult());
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
