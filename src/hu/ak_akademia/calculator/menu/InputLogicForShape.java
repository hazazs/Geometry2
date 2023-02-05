package hu.ak_akademia.calculator.menu;

import java.util.function.Function;
import hu.ak_akademia.calculator.UserInputHandler;
import hu.ak_akademia.calculator.shape.Shape;

@FunctionalInterface
public interface InputLogicForShape extends Function<UserInputHandler, Shape> {

}