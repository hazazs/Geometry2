package hu.ak_akademia.calculator;

import java.util.Scanner;

final class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputHandler inputHandler = UserInputHandler.get(scanner);
			ValueWithUnit side1 = inputHandler.readValueWithUnit("Give me Side A: ");
			ValueWithUnit side2 = inputHandler.readValueWithUnit("Give me Side B: ");
			System.out.println("Sum = " + side1.add(side2));
		}
	}

}