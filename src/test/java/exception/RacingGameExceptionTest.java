package exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameExceptionTest {

	@Test
	@DisplayName("RacingGameException Message Test")
	void exceptionMessageTest(){
		assertThat(new RacingGameException(ExceptionMessage.INVALID_SIZE_CAR_NAME))
			.isNotNull()
			.hasMessageContaining(ExceptionMessage.INVALID_SIZE_CAR_NAME.getMessage());
	}

}
