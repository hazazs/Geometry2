package hu.ak_akademia.calculator;

import java.util.function.Function;
import hu.ak_akademia.calculator.shape.Shape;

@FunctionalInterface
public interface InputLogicForShape extends Function<UserInputHandler, Shape> {

}