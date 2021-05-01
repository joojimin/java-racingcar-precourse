package racing;

import car.Car;
import car.CarFactory;
import exception.RacingGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import type.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

	@Test
	@DisplayName("5글자 이하의 자동차 이름으로 생성 테스트")
	void createCarListTest(){
		assertThatCode(()->new RacingGame(new CarFactory()).createCarList("a,b,c"))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("0글자의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithEmptyNameTest(){
		assertThatThrownBy(()->new RacingGame(new CarFactory()).createCarList("a,,c"))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("5글자 초과의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithOverSizeNameTest(){
		assertThatThrownBy(()->new RacingGame(new CarFactory()).createCarList("a,dddddddddddd,c"))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("통합 게임 테스트(콘솔로 파악)")
	void playGames() {
		// given
		RacingGame racingGame = new RacingGame(new CarFactory());
		racingGame.createCarList("a,b,c");

		// when
		racingGame.playGames(new GameCommand(5));
		
		// then
		// isEmpty.. print console
	}

	@ParameterizedTest(name = "[기준 숫자=''{0}''] , [이동 여부=''{1}'']")
	@CsvSource(
		{"1, false", "2, false", "3, false", "4, true", "5, true", "6, true", "7, true", "8, true", "9, true"}
	)
	@DisplayName("레이싱 게임 테스트")
	void gamePlayTest(int condition, boolean isMove){
		// given
		RacingGame racingGame = new RacingGame(new CarFactory());
		Car car = new Car("");

		// when
		racingGame.play(car, condition);

		// then
		assertThat(car.getPosition() == 1).isEqualTo(isMove);
	}

	@Test
	@DisplayName("우승자 한명 테스트")
	void getOneWinnerListTest() {
		// given
		CarFactory carFactory = new CarFactory();
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		carFactory.add(car1)
				  .add(car2)
				  .add(car3);

		RacingGame racingGame = new RacingGame(carFactory);
		racingGame.play(car1, 5); // car1을 우승자로 만들기위해 전진시킴

		// when
		assertThat(racingGame.getWinnerList())
			.hasSize(1); // then
	}

	@Test
	@DisplayName("우승자 두명 테스트")
	void getMultiWinnerListTest() {
		// given
		CarFactory carFactory = new CarFactory();
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		carFactory.add(car1)
				  .add(car2)
				  .add(car3);

		RacingGame racingGame = new RacingGame(carFactory);
		racingGame.play(car1, 5); // car1을 우승자로 만들기위해 전진시킴
		racingGame.play(car2, 6); // car1을 우승자로 만들기위해 전진시킴

		// when
		assertThat(racingGame.getWinnerList())
			.hasSize(2); // then
	}
}
