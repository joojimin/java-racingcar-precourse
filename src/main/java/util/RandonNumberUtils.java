package util;

import java.util.Random;

public class RandonNumberUtils {

	private static final Random RANDOM_INSTANCE = new Random();

	public static int generate(int range) {
		return RANDOM_INSTANCE.nextInt(range);
	}
}
