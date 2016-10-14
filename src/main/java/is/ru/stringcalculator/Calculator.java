package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	
	public static int add(String text){

		if (text.equals("")) {
			return 0;
		}

		else if(isNegativeNumber(rawTextToNumberString(text))) {
			return -1;
		}

		else if (text.contains(",")) {
			return sum(rawTextToNumberString(text));
		}

		else {
			return 1;
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
		return numbers.split(",");
	}

	private static int sum(String[] numbers) {

		int total = 0;
		for(String number : numbers) {
			total = total + toInt(number);
		}
		return total;
	}

	private static String makeOneLine(String text) {
		return text.replace('\n',',');
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

	private static String[] rawTextToNumberString(String text) {
		return splitNumbers(makeOneLine(text));
	}
}

