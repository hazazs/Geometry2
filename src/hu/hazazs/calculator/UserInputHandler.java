package hu.hazazs.calculator;

import java.util.Scanner;
import java.util.stream.Stream;

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

	public int readMenuNumber(int menuSize, String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine();
		} while (!isValidMenuOption(input, menuSize));
		return Integer.parseInt(input);
	}

	private boolean isValidValueWithUnit(final String input) {
		return Stream.of(LengthUnit.values())
				.anyMatch(lengthUnit -> input.matches("\\d+(,\\d+)? " + lengthUnit.getUnitName())
						&& input.matches(".*[123456789].*"));
	}

	private ValueWithUnit getValueWithUnitFrom(String input) {
		String[] elements = input.split(" ");
		double value = Double.parseDouble(elements[0].replaceAll(",", "."));
		LengthUnit unit = LengthUnit.getFrom(elements[1]);
		return new ValueWithUnit(value, unit);
	}

	private boolean isValidLengthUnit(final String input) {
		return Stream.of(LengthUnit.values())
				.anyMatch(lengthUnit -> input.equals(lengthUnit.getUnitName()));
	}

	private boolean isValidMenuOption(String input, int menuSize) {
		try {
			int menuOption = Integer.parseInt(input);
			return menuOption > 0 && menuOption <= menuSize;
		} catch (NumberFormatException exception) {
			return false;
		}
	}

}