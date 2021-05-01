import car.CarFactory;
import racing.RacingGame;

public class GameManager {

	public static void run(){
		RacingGame racingGame = new RacingGame(new CarFactory());
		
	}
}
