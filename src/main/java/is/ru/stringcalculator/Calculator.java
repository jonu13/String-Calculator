package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text){

		String newText = text.replace('\n',',');

		if (newText.equals("")) {
			return 0;
		}

		else if (newText.contains(",")) {
			return sum(splitNumbers(newText));
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
}

