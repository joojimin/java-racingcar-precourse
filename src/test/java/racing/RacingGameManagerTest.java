package racing;

import exception.RacingGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
