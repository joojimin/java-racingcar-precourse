package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomStringUtils {

	public static List<String> split(String value, String regex) {
		if(isEmpty(value)){
			return Collections.emptyList();
		}
		return Arrays.asList(value.split(regex));
	}

	public static boolean isEmpty(String value){
		if(null == value || value.isEmpty()){
			return true;
		}
		return false;
	}

	public static boolean isValidSize(String value, int limitSize){
		if(isEmpty(value)){
			return false;
		}
		return value.length() <= limitSize;
	}
}
