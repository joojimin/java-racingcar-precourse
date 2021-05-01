import car.CarFactory;
import exception.RacingGameException;
import racing.GameCommand;
import racing.RacingGame;
import util.ConsoleUtils;

import static type.GameMessage.INPUT_CAR_NAME;
import static type.GameMessage.INPUT_GAME_COUNT;
import static util.ConsoleUtils.nextInt;
import static util.ConsoleUtils.nextString;

public class GameManager {

	public static void run(){
		RacingGame racingGame = new RacingGame(new CarFactory());
		try {
			racingGame.createCarList(nextString(INPUT_CAR_NAME.getMessage()));
			racingGame.playGames(new GameCommand(nextInt(INPUT_GAME_COUNT.getMessage())));
		}catch(RacingGameException exception){
			ConsoleUtils.printLine(exception.getMessage());
		}
	}
}
