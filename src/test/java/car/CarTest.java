package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@DisplayName("자동차 전진 기능 테스트")
	@Test
	void goTest(){
		// given
		Car car = new Car();

		// when
		car.go();
		car.go();

		// then
		assertThat(car.getPosition()).isEqualTo(2);
	}
}
