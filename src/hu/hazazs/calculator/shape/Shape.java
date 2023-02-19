package hu.hazazs.calculator.shape;

import hu.hazazs.calculator.LengthUnit;
import hu.hazazs.calculator.ValueWithUnit;

public interface Shape {

	ValueWithUnit calculateArea(LengthUnit targetUnit);

	ValueWithUnit calculatePerimeter(LengthUnit targetUnit);

}