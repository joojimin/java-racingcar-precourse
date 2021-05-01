package racing;

public class GameCommand {
	private int gameCount;

	public GameCommand(final int gameCount){
		this.gameCount = gameCount;
	}

	public int getGameCount(){
		return this.gameCount;
	}

	public boolean isPlaying(){
		if(gameCount == 0) return false;
		this.gameCount -= 1;
		return true;
	}
}
