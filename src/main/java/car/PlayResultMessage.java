package car;

public class PlayResultMessage {

	public static String makeMessage(final String name, final int position){
		StringBuilder stringBuilder = new StringBuilder(name).append(" : ");
		for(int i = 0; i < position; ++i){
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}
