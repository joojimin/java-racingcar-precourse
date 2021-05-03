package util;

import java.util.Scanner;

public class ConsoleUtils {

	public static void printLine(String message){
		System.out.println(message);
	}
	public static void printLine(){ printLine(""); }

	public static String nextString(String inputMessage){
		printLine(inputMessage);
		return new Scanner(System.in).nextLine();
	}

	public static int nextInt(String inputMessage){
		printLine(inputMessage);
		return new Scanner(System.in).nextInt();
	}
}
