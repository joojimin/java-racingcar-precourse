package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomStringUtilsTest {

	@ParameterizedTest(name = "regex ',' split test,  value={0} , size={1}")
	@CsvSource({
		"'a,b,c,d', 4",
		"'a,b,ddd', 3",
		"'a', 1",
		"'', 0",
	})
	void splitTest(final String value, final int size){
		assertThat(CustomStringUtils.split(value, ","))
			.isNotNull()
			.hasSize(size);
	}

	@ParameterizedTest(name = "isEmpty test,  value={0} , isEmpty={1}")
	@CsvSource({
		"'is', false",
		"'', true"
	})
	void isEmptyTest(final String value, final boolean isEmpty){
		assertThat(CustomStringUtils.isEmpty(value))
			.isEqualTo(isEmpty);
	}

	@ParameterizedTest(name = "isValidSize Test,  value={0}, limitSize={1}, isValid={2}")
	@CsvSource({
		"'valid', 5, true",
		"'valid', 4, false",
		"'', 5, false",
		"'v', 5, true",
		"'valid1', 5, false"
	})
	void isValidSize(final String value, final int limitSize, final boolean isValid) {
		assertThat(CustomStringUtils.isValidSize(value,limitSize))
			.isEqualTo(isValid);
	}
}
