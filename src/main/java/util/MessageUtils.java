package util;

import java.util.List;

import static type.GameMessage.GAME_WINNER;

public class MessageUtils {

	public static String makePlayMessage(final String name, final int position){
		StringBuilder stringBuilder = new StringBuilder(name).append(" : ");
		for(int i = 0; i < position; ++i){
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}

	public static String makeWinnerMessage(final List<String> list){
		return new StringBuilder(String.join(",", list))
			.append(GAME_WINNER.getMessage())
			.toString();
	}
}
