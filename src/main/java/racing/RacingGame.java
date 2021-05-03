package racing;

import car.Car;
import car.CarFactory;
import util.ConsoleUtils;
import util.MessageUtils;
import util.RandonNumberUtils;

import java.util.ArrayList;
import java.util.List;

import static type.GameMessage.GAME_RESULT;

public class RacingGame {
	private static final int STANDARD_RANGE_NUMBER = 10;

	private CarFactory carFactory;

	public RacingGame(CarFactory carFactory){
		this.carFactory = carFactory;
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
		carFactory.processAboutCarList(car-> car.play(RandonNumberUtils.generate(STANDARD_RANGE_NUMBER)));
	}

	List<String> getWinnerList(){
		Car winnerCar = carFactory.getMax();
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
