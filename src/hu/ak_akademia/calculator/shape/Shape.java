package hu.ak_akademia.calculator.shape;

import hu.ak_akademia.calculator.LengthUnit;
import hu.ak_akademia.calculator.ValueWithUnit;

public interface Shape {

	ValueWithUnit calculateArea(LengthUnit targetUnit);

	ValueWithUnit calculatePerimeter(LengthUnit targetUnit);

}