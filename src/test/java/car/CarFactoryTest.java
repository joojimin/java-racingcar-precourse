package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

	@Test
	@DisplayName("자동차 관리 Factory add 테스트")
	void addTest(){
		// given
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");

		// then
		assertThat(new CarFactory("car1,car2").getCarList())
			.isNotNull()
			.hasSize(2)
			.contains(car1, car2);
	}
}
