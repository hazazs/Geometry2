package hu.ak_akademia.calculator.menu;

import hu.ak_akademia.calculator.InputLogicForShape;
import hu.ak_akademia.calculator.LengthUnit;
import hu.ak_akademia.calculator.UserInputHandler;
import hu.ak_akademia.calculator.shape.Shape;

public class SimpleMenuOption implements MenuOption {

	private final int number;
	private final String description;
	private final UserInputHandler inputHandler;
	private final InputLogicForShape inputLogic;

	public SimpleMenuOption(int number, String description, UserInputHandler inputHandler,
			InputLogicForShape inputLogic) {
		this.number = number;
		this.description = description;
		this.inputHandler = inputHandler;
		this.inputLogic = inputLogic;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void execute() {
		Shape shape = inputLogic.apply(inputHandler);
		LengthUnit targetUnit = inputHandler
				.readLengthUnit("In which length unit do you want the area and perimeter to be calculated? ");
		System.out.println("Area = " + shape.calculateArea(targetUnit) + "²");
		System.out.println("Perimeter = " + shape.calculatePerimeter(targetUnit));
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", number, description);
	}

}