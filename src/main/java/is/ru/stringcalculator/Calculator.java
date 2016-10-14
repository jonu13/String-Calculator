package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	public static int add(String text){

		

		if (text.equals("")) {
			return 0;
		}
		String text2;
		char separator = checkSeparator(text);
		if(separator != ',') {
			text2 = (text.substring(6));
		}

		if(isNegativeNumber(rawTextToNumberString(text,separator))) {
			return -1;
		}

		else if (text.contains(",")) {
			return sum(rawTextToNumberString(text,separator));
		}

		else {

			if(toInt(text) > 1000) {
				return 0;
			}
			else {
				return toInt(text);
			}
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, char separator) {

		String newSeparator = "" + separator;
		return numbers.split(newSeparator);
	}

	private static int sum(String[] numbers) {

		int total = 0;
		for(String number : noBigNumbers(numbers)) {
			total = total + toInt(number);
		}
		return total;
	}

	private static String makeOneLine(String text, char separator) {
		return text.replace('\n',separator);
	}

	private static Boolean isNegativeNumber(String[] numbers) {

		List<Integer> negativeNumberList = new ArrayList<>();

		for(int i = 0; i < numbers.length; i++) {

			if(toInt((numbers[i])) < 0) {
				negativeNumberList.add(toInt(numbers[i]));
			}
		}

		if(!negativeNumberList.isEmpty()) {
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumberList.toString());
		}

		return false;
	}

	private static String[] rawTextToNumberString(String text, char separator) {
		return splitNumbers(makeOneLine(text, separator),separator);
	}

	private static String[] noBigNumbers(String[] numbers) {

		String[] smallNumbers = new String[numbers.length];

		for(int i = 0; i < numbers.length;i++) {

			if(toInt(numbers[i]) > 1000) {
				smallNumbers[i] = "0";
			}
			else {
				smallNumbers[i] = numbers[i];
			}
		}
		return smallNumbers;
	}

	private static char checkSeparator(String text) {

		char fyrstiStafur = text.charAt(0);
		if(fyrstiStafur == '/') {
			return text.charAt(2);
		}
		else {
			return ',';
		}
	}
}

