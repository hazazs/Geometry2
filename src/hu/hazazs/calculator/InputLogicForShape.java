package hu.hazazs.calculator;

import java.util.function.Function;
import hu.hazazs.calculator.shape.Shape;

@FunctionalInterface
public interface InputLogicForShape extends Function<UserInputHandler, Shape> {

}