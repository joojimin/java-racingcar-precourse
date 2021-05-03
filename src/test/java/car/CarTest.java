package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@DisplayName("자동차 전진 기능 테스트")
	@Test
	void goTest(){
		// given
		Car car = new Car("");

		// when
		car.go();
		car.go();

		// then
		assertThat(car.getPosition()).isEqualTo(2);
	}


	@ParameterizedTest(name = "[기준 숫자=''{0}''] , [이동 여부=''{1}'']")
	@CsvSource(
		{"1, false", "2, false", "3, false", "4, true", "5, true", "6, true", "7, true", "8, true", "9, true"}
	)
	@DisplayName("레이싱 게임 테스트")
	void gamePlayTest(int condition, boolean isMove){
		// given
		Car car = new Car("");

		// when
		car.play(condition);

		// then
		assertThat(car.getPosition() == 1).isEqualTo(isMove);
	}
}
