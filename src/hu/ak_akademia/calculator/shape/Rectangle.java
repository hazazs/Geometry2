package hu.ak_akademia.calculator.shape;

import hu.ak_akademia.calculator.LengthUnit;
import hu.ak_akademia.calculator.ValueWithUnit;

public class Rectangle implements Shape {

	private final ValueWithUnit a;
	private final ValueWithUnit b;

	public Rectangle(ValueWithUnit a, ValueWithUnit b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public ValueWithUnit calculateArea(LengthUnit targetUnit) {
		a.convertTo(targetUnit);
		b.convertTo(targetUnit);
		return a.multiply(b);
	}

	@Override
	public ValueWithUnit calculatePerimeter(LengthUnit targetUnit) {
		a.convertTo(targetUnit);
		b.convertTo(targetUnit);
		return a.add(b).multiply(2);
	}

}