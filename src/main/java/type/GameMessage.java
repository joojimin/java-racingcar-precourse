package type;

public enum GameMessage {

	GAME_WINNER("가 최종 우승했습니다."),
	;

	private String message;

	GameMessage(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}

}
