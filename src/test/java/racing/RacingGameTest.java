package racing;

import car.Car;
import car.CarFactory;
import exception.RacingGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.ExceptionMessage;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	@Test
	@DisplayName("5글자 이하의 자동차 이름으로 생성 테스트")
	void createCarListTest(){
		assertThatCode(()->new RacingGame(new CarFactory("a,b,c")))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("0글자의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithEmptyNameTest(){
		assertThatThrownBy(()->new RacingGame(new CarFactory("a,,c")))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("5글자 초과의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithOverSizeNameTest(){
		assertThatThrownBy(()->new RacingGame(new CarFactory("a,dddddddddddd,c")))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("통합 게임 테스트(콘솔로 파악)")
	void playGames() {
		// given
		RacingGame racingGame = new RacingGame(new CarFactory("a,b,c"));

		// when
		racingGame.playGames(new GameCommand(5));
		
		// then
		// isEmpty.. print console
	}

	@Test
	@DisplayName("우승자 한명 테스트")
	void getOneWinnerListTest() {
		// given
		CarFactory carFactory = new CarFactory("car1,car2,car3");
		List<Car> carList = carFactory.getCarList();
		Car car1 = carList.get(0);
		RacingGame racingGame = new RacingGame(carFactory);
		car1.play(5); // car1을 우승자로 만들기위해 전진시킴

		// when
		assertThat(racingGame.getWinnerList())
			.hasSize(1); // then
	}

	@Test
	@DisplayName("우승자 두명 테스트")
	void getMultiWinnerListTest() {
		// given
		CarFactory carFactory = new CarFactory("car1,car2,car3");
		List<Car> carList = carFactory.getCarList();
		Car car1 = carList.get(0);
		Car car2 = carList.get(1);
		RacingGame racingGame = new RacingGame(carFactory);
		car1.play(5); // car1을 우승자로 만들기위해 전진시킴
		car2.play(6); // car2을 우승자로 만들기위해 전진시킴

		// when
		assertThat(racingGame.getWinnerList())
			.hasSize(2); // then
	}
}
