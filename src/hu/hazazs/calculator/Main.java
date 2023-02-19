package hu.hazazs.calculator;

import java.util.List;
import java.util.Scanner;
import hu.hazazs.calculator.menu.Menu;
import hu.hazazs.calculator.menu.MenuOption;
import hu.hazazs.calculator.menu.SimpleMenuOption;
import hu.hazazs.calculator.shape.Kite;
import hu.hazazs.calculator.shape.Parallelogram;
import hu.hazazs.calculator.shape.Rectangle;
import hu.hazazs.calculator.shape.Rhombus;
import hu.hazazs.calculator.shape.Square;

final class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputHandler inputHandler = UserInputHandler.get(scanner);
			System.out.println("Hello!");
			MenuOption squareMenuOption = new SimpleMenuOption(1, "SQUARE", inputHandler, handler -> {
				ValueWithUnit a = handler.readValueWithUnit("Please give the length of the side A: ");
				return new Square(a);
			});
			MenuOption rectangleMenuOption = new SimpleMenuOption(2, "RECTANGLE", inputHandler, handler -> {
				ValueWithUnit a = handler.readValueWithUnit("Please give the length of the side A: ");
				ValueWithUnit b = handler.readValueWithUnit("Please give the length of the side B: ");
				return new Rectangle(a, b);
			});
			MenuOption parallelogramMenuOption = new SimpleMenuOption(3, "PARALLELOGRAM", inputHandler, handler -> {
				ValueWithUnit a = handler.readValueWithUnit("Please give the length of the side A: ");
				ValueWithUnit b = handler.readValueWithUnit("Please give the length of the side B: ");
				ValueWithUnit m = handler
						.readValueWithUnit("Please give the length of the height related to the side A: ");
				return new Parallelogram(a, b, m);
			});
			MenuOption rhombusMenuOption = new SimpleMenuOption(4, "RHOMBUS", inputHandler, handler -> {
				ValueWithUnit a = handler.readValueWithUnit("Please give the length of the side A: ");
				ValueWithUnit e = handler.readValueWithUnit("Please give the length of the diagonal E: ");
				ValueWithUnit f = handler.readValueWithUnit("Please give the length of the diagonal F: ");
				return new Rhombus(a, e, f);
			});
			MenuOption kiteMenuOption = new SimpleMenuOption(5, "KITE", inputHandler, handler -> {
				ValueWithUnit a = handler.readValueWithUnit("Please give the length of the side A: ");
				ValueWithUnit b = handler.readValueWithUnit("Please give the length of the side B: ");
				ValueWithUnit e = handler.readValueWithUnit("Please give the length of the diagonal E: ");
				ValueWithUnit f = handler.readValueWithUnit("Please give the length of the diagonal F: ");
				return new Kite(a, b, e, f);
			});
			MenuOption exitMenuOption = new SimpleMenuOption(6, "EXIT", inputHandler, handler -> {
				System.out.print("Good bye!");
				System.exit(0);
				return null;
			});
			new Menu(List.of(squareMenuOption, rectangleMenuOption, parallelogramMenuOption,
					rhombusMenuOption, kiteMenuOption, exitMenuOption), inputHandler)
				.run();
		}
	}

}