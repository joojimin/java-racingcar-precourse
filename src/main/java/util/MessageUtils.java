package util;

import type.GameMessage;

import java.util.List;

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
			.append(GameMessage.GAME_WINNER.getMessage())
			.toString();
	}
}
