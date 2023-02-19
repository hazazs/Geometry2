package hu.hazazs.calculator.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import hu.hazazs.calculator.UserInputHandler;

public final class Menu {

	private final Map<Integer, MenuOption> menuOptions = new HashMap<>();
	private final UserInputHandler inputHandler;

	public Menu(List<MenuOption> menuOptions, UserInputHandler inputHandler) {
		menuOptions.forEach(menuOption -> this.menuOptions.put(menuOption.getNumber(), menuOption));
		this.inputHandler = inputHandler;
	}

	public void run() {
		System.out.println(this);
		int menuNumber = inputHandler.readMenuNumber(menuOptions.keySet().size(), "Choose an option from the menu: ");
		System.out.println();
		menuOptions.get(menuNumber).execute();
		run();
	}

	@Override
	public String toString() {
		return "\n" + menuOptions.keySet().stream()
				.sorted()
				.map(menuOptions::get)
				.map(MenuOption::toString)
				.collect(Collectors.joining("\n"));
	}

}