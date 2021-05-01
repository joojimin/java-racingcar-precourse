package racing;

import car.Car;
import exception.RacingGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import type.ExceptionMessage;

import static org.assertj.core.api.Assertions.*;

class RacingGameManagerTest {

	@Test
	@DisplayName("5글자 이하의 자동차 이름으로 생성 테스트")
	void createCarListTest(){
		assertThatCode(()->new RacingGameManager().createCarList("a,b,c"))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("0글자의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithEmptyNameTest(){
		assertThatThrownBy(()->new RacingGameManager().createCarList("a,,c"))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	@DisplayName("5글자 초과의 자동차 이름이 포함되어 있는 경우")
	void createCarListWithOverSizeNameTest(){
		assertThatThrownBy(()->new RacingGameManager().createCarList("a,dddddddddddd,c"))
			.isInstanceOf(RacingGameException.class)
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

	@Test
	void playGames() {
		// given
		RacingGameManager racingGameManager = new RacingGameManager();
		racingGameManager.createCarList("a,b,c");

		// when
		racingGameManager.playGames(new GameCommand(5));
		
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
		RacingGameManager racingGameManager = new RacingGameManager();
		Car car = new Car("");

		// when
		racingGameManager.play(car, condition);

		// then
		assertThat(car.getPosition() == 1).isEqualTo(isMove);
	}
}
