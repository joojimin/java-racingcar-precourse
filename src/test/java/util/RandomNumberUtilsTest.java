package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberUtilsTest {

	@RepeatedTest(10)
	@DisplayName("0~9사이의 랜덤한 숫자 생성 테스트")
	void generateTest(){
		assertThat(RandonNumberUtils.generate(10))
			.isGreaterThanOrEqualTo(0)
			.isLessThanOrEqualTo(9);
	}

}
