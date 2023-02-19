package hu.hazazs.calculator.shape;

import hu.hazazs.calculator.LengthUnit;
import hu.hazazs.calculator.ValueWithUnit;

public final class Parallelogram implements Shape {

	private final ValueWithUnit a;
	private final ValueWithUnit b;
	private final ValueWithUnit m;

	public Parallelogram(ValueWithUnit a, ValueWithUnit b, ValueWithUnit m) {
		this.a = a;
		this.b = b;
		this.m = m;
	}

	@Override
	public ValueWithUnit calculateArea(LengthUnit targetUnit) {
		a.convertTo(targetUnit);
		m.convertTo(targetUnit);
		return a.multiply(m);
	}

	@Override
	public ValueWithUnit calculatePerimeter(LengthUnit targetUnit) {
		a.convertTo(targetUnit);
		b.convertTo(targetUnit);
		return a.add(b).multiply(2);
	}

}