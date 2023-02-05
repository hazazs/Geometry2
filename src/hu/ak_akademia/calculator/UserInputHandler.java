package hu.ak_akademia.calculator;

import java.util.Scanner;

@Singleton
public final class UserInputHandler {

	private static UserInputHandler inputHandler;
	private final Scanner scanner;

	private UserInputHandler(Scanner scanner) {
		this.scanner = scanner;
	}

	static UserInputHandler get(Scanner scanner) {
		if (inputHandler == null) {
			inputHandler = new UserInputHandler(scanner);
		}
		return inputHandler;
	}

	ValueWithUnit readValueWithUnit(String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine();
		} while (!isValidValueWithUnit(input));
		return getValueWithUnitFrom(input);
	}

	public LengthUnit readLengthUnit(String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine();
		} while (!isValidLengthUnit(input));
		return LengthUnit.getFrom(input);
	}

	private boolean isValidValueWithUnit(String input) {
		for (LengthUnit lengthUnit : LengthUnit.values()) {
			if (input.matches(String.format("\\d+(,\\d+)? %s", lengthUnit.getUnitName()))) {
				return true;
			}
		}
		return false;
	}

	private ValueWithUnit getValueWithUnitFrom(String input) {
		String[] elements = input.split(" ");
		double value = Double.parseDouble(elements[0].replaceAll(",", "."));
		LengthUnit unit = LengthUnit.getFrom(elements[1]);
		return new ValueWithUnit(value, unit);
	}

	private boolean isValidLengthUnit(String input) {
		for (LengthUnit lengthUnit : LengthUnit.values()) {
			if (lengthUnit.getUnitName().equals(input)) {
				return true;
			}
		}
		return false;
	}

}