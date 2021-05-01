package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MessageUtilsTest {

	@Test
	@DisplayName("Play Message Test")
	void makePlayMessageTest() {
		assertThat(MessageUtils.makePlayMessage("test",3))
			.isNotBlank()
			.isEqualTo("test : ---");
	}

	@Test
	@DisplayName("Winner Message Test")
	void makeWinnerMessageTest() {
		List<String> list = new ArrayList<>();
		list.add("car1");
		list.add("car2");
		assertThat(MessageUtils.makeWinnerMessage(list))
			.isNotBlank()
			.isEqualTo("car1,car2가 최종 우승했습니다.");
	}
}
