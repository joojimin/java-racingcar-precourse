package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameCommandTest {


	@Test
	@DisplayName("5번의 게임후 6번째에서 멈추는지 테스트")
	void isPlayingTest(){
		GameCommand gameCommand = new GameCommand(5);

		assertThat(gameCommand.isPlaying()).isTrue();
		assertThat(gameCommand.isPlaying()).isTrue();
		assertThat(gameCommand.isPlaying()).isTrue();
		assertThat(gameCommand.isPlaying()).isTrue();
		assertThat(gameCommand.isPlaying()).isTrue();
		assertThat(gameCommand.isPlaying()).isFalse();
	}

}
