package type;

public enum ExceptionMessage {

	INVALID_SIZE_CAR_NAME("자동차 이름이 유효하지 않습니다. (0 ~ 5자 사이)"),
	;

	private String message;


	ExceptionMessage(final String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message;
	}
}
